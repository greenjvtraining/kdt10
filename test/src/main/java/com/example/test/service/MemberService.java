package com.example.test.service;

import org.springframework.stereotype.Service;

import com.example.test.dto.MemberDto;

@Service
public class MemberService implements IMemberService{

	@Override
	public int regist(MemberDto member) {
		return 0;
	}

	@Override
	public MemberDto getMember(String id) {
		return null;
	}

	@Override
	public int modify(MemberDto member) {
		return 0;
	}

	@Override
	public int login(String id, String pw) {
		return 0;
	}

	@Override
	public int remove(String id) {
		return 0;
	}

}
