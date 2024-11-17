package com.example.test.service;

import com.example.test.dto.MemberDto;

public interface IMemberService {
	public int regist(MemberDto member);
	public MemberDto getMember(String id);
	public int modify(MemberDto member);
	public int login(String id, String pw);
	public int remove(String id);
	
}
