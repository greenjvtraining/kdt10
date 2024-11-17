package com.example.test.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.test.dto.MemberDto;

@Mapper
public interface IMemberDao {
	public int insert(MemberDto member);
	public MemberDto findByid(String id);
	public int update(MemberDto member);
	public int login(String id, String pw);
	public int delete(String id);
}
