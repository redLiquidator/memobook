package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.FileEntity;
import com.example.demo.entity.MemoEntity;
import com.example.demo.repository.FileRepository;
import com.example.demo.repository.MemoRepository;
import com.example.demo.vo.UserFile;
import com.example.demo.vo.Memo;

/* mysql command history...
 * in terminal, access mysql: mysql -u root -p 
 * Create database memo; 
 * Use memo; 
 * Show tables; 
 * Create table memo(id int(100) UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
 * content varchar(1000), create_date datetime, 
 * update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP); 
 * Select * from memo;
 * 
 * sample| alter table user add column password varchar(30) after name;
 */

@Service
public class MemoServiceImpl implements MemoService{

	@Autowired
	MemoRepository memoRepository;
	
	@Autowired
	FileRepository fileRepository;
	
	/* 
	 * jpa insert & update. file table(joined) also should be affected. 
	 * 
	 * */
	@Override
	public String addMemo(Memo memo) {
		
		MemoEntity memoEntity = new MemoEntity() ;
		
		//insert file data
		List<FileEntity> fileEntity = new ArrayList<>();
		    for(UserFile file: memo.getFileList()){
		      FileEntity entity = new FileEntity();

		      entity.setFile_id(file.getFile_id());
		      entity.setCreate_date(file.getCreate_date());
		      entity.setFile_path(file.getFile_path()); 
		      fileEntity.add(entity);
		    }
		
		memoEntity.setFileEntity(fileEntity);
		
        //insert memo data
		memoEntity.setId(memo.getId());
		memoEntity.setContent(memo.getContent());
		memoEntity.setCreate_date(memo.getCreate_date());
		memoEntity.setUpdate_date(memo.getUpdate_date());
		memoEntity.setWriter(memo.getWriter());
		

		Optional<MemoEntity> memo2 = memoRepository.findById(memo.getId());
		memoRepository.save(memoEntity);
		
		if(memo2.isPresent()) {			
			return "memo & its attached files "+memo.getId()+ "has been successfully updated!";
		}
	
		return "memo & its attached files "+memo.getId()+ " has been successfully added!";
	
	}

	@Override
	public List<Memo> getAllMemos() {
		List<Memo> list = new ArrayList<>();
		//jpa select query
		List<MemoEntity> memoEntityList = memoRepository.findAll();
		//fileRepository.findById()
		for(MemoEntity entity: memoEntityList) {
			Memo memo = new Memo();
			memo.setId(entity.getId());
			memo.setContent(entity.getContent());
			memo.setCreate_date(entity.getCreate_date());
			memo.setUpdate_date(entity.getUpdate_date());
			memo.setWriter(entity.getWriter());

			//memo.setFileList(entity.getFileEntity()); datatype mismatch error : list vs single object
			List<FileEntity> fileEntityList = entity.getFileEntity();
			List<UserFile> userFileList = new ArrayList<>();
			for(FileEntity entity1 : fileEntityList) {
				UserFile userfile = new UserFile();
				userfile.setFile_id(entity1.getFile_id());
				userfile.setCreate_date(entity1.getCreate_date());
				userfile.setFile_path(entity1.getFile_path());
				userFileList.add(userfile);
			}
			
			memo.setFileList(userFileList);
			
			System.out.println("memo.getFileList() |  "+memo.getFileList());	
			for(FileEntity entity1 : fileEntityList) {
	
				System.out.println(entity1.getFile_id());
				System.out.println(entity1.getCreate_date());
				System.out.println(entity1.getFile_path());
			
			}

			list.add(memo);
		}
		return list;	
	}

	@Override
	public Memo getMemo(int id) {
		Optional<MemoEntity> memoEntity = memoRepository.findById(id);
		MemoEntity entity = memoEntity.get();
		
		Memo memo = new Memo();
		memo.setId(entity.getId());
		memo.setContent(entity.getContent());
		memo.setCreate_date(entity.getCreate_date());
		memo.setUpdate_date(entity.getUpdate_date());
		memo.setWriter(entity.getWriter());
		//get file data
		//memo.setFile_list(entity.getFileEntity());		
		return memo;
	}

	@Override
	public String updateMemo(Memo memo) {

		MemoEntity memoEntity = new MemoEntity();
		memoEntity.setId(memo.getId());
		memoEntity.setContent(memo.getContent());
		memoEntity.setCreate_date(memo.getCreate_date());
		memoEntity.setUpdate_date(memo.getUpdate_date());
		
		List<FileEntity> fileEntity = new ArrayList<>();
	    for(UserFile file: memo.getFileList()){
		      FileEntity entity = new FileEntity();

		      entity.setFile_id(file.getFile_id());
		      entity.setCreate_date(file.getCreate_date());
		      entity.setFile_path(file.getFile_path());  
		      fileEntity.add(entity);
		    }
		
		memoEntity.setFileEntity(fileEntity);	
		memoRepository.save(memoEntity);
		return "ok";
	}

	@Override
	public String deleteMemo(int id) {
		memoRepository.deleteById(id);
		//delete related file data
		Optional<MemoEntity> memoEntity = memoRepository.findById(id);
		MemoEntity entity = memoEntity.get();

		System.out.println(entity.getFileEntity());
		//fileRepository.deleteById(file_id);
		return "ok";
	}
}
