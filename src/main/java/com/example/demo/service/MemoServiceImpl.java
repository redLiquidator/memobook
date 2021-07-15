package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MemoEntity;
import com.example.demo.repository.MemoRepository;
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
	
	@Override
	public String addMemo(Memo memo) {
		MemoEntity memoEntity = new MemoEntity() ;
		 
		List<FileEntity> fileEntity = new ArrayList<>();
		    for(File file: memo.getFileList()){
		      FileEntity entity = new FileEntity();

		      entity.setFileId(file.getFileId());
		      entity.setCreateDate(file.getCreateDate());
		      entity.setFilepath(file.getFilepath());  
		      fileEntity.add(entity);
		    }
		memoEntity.setFileEntity(fileEntity);

		memoEntity.setId(memo.getId());
		memoEntity.setContent(memo.getContent());
		memoEntity.setCreate_date(memo.getCreate_date());
		memoEntity.setUpdate_date(memo.getUpdate_date());
		
		//jpa insert & update. file table(joined) also should be affected.
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
		for(MemoEntity entity: memoEntityList) {
			Memo memo = new Memo();
			memo.setId(entity.getId());
			memo.setContent(entity.getContent());
			memo.setCreate_date(entity.getCreate_date());
			memo.setUpdate_date(entity.getUpdate_date());
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
		return memo;
	}

	@Override
	public String updateMemo(Memo memo) {

		MemoEntity memoEntity = new MemoEntity();
		memoEntity.setId(memo.getId());
		memoEntity.setContent(memo.getContent());
		memoEntity.setCreate_date(memo.getCreate_date());
		memoEntity.setUpdate_date(memo.getUpdate_date());
		
		memoRepository.save(memoEntity);
		return "ok";
	}

	@Override
	public String deleteMemo(int id) {
		memoRepository.deleteById(id);
		return "ok";
	}
}
