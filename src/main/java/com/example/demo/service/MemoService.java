package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.Memo;

public interface MemoService {
	public String addMemo(Memo memo);
	public List<Memo> getAllMemos();
	public Memo getMemo(int id);
	public String updateMemo(Memo memo);
	public String deleteMemo(int id);
}
