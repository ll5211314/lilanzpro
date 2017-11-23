package com.example.demo.Mapping;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.Model.*;

@Mapper
public interface TestMapper {
	
	/**
    * 查询信息
    * @return
    * @throws Exception
    */
	public List<TestModel> getArtist(int id) throws Exception;
	
	/**
    * 增加
    * @return
    * @throws Exception
    */
	public int addArtist(String name) throws Exception;
	
	/**
    * 修改
    * @return
    * @throws Exception
    */
	public int updateArtist(TestModel testModel) throws Exception;
	
	/**
    * 删除
    * @return
    * @throws Exception
    */
	public int deleteArtist(int id) throws Exception;
}
