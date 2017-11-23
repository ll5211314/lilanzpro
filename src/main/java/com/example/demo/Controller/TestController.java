package com.example.demo.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Mapping.*;
import com.example.demo.Model.*;

@RestController
public class TestController {

    /**
     * 查询所有信息
    */
	@RequestMapping("/selectAllArtist")
    private String selectAllArtist(HttpServletRequest request){
        SqlSession session=SQLController.getSession();
        TestMapper mapper=session.getMapper(TestMapper.class);
        List<TestModel> Artists= null;
        try {
        	String id=request.getParameter("id");
        	if(id==null || id=="") id="0";
        	Artists=mapper.getArtist(Integer.parseInt(id));
        	session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        String str="";
        for(int i=0; i<Artists.size(); i++){
        	str += Artists.get(i).toString()+"<br/>";
        }
        return str;
    }

    /**
     * 增加
    */
	@RequestMapping("/addArtist")
    private String addArtist(HttpServletRequest request){
        SqlSession session=SQLController.getSession();
        TestMapper mapper=session.getMapper(TestMapper.class);
        int num = 0;
        try {
        	String name=request.getParameter("name");
        	if(name==null || name=="") {
        		return "请输入名字!!!";
        	}
        	num=mapper.addArtist(name);
        	session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return num+"";
    }

    /**
     * 修改
    */
	@RequestMapping("/updateArtist")
    private String updateArtist(HttpServletRequest request){
        SqlSession session=SQLController.getSession();
        TestMapper mapper=session.getMapper(TestMapper.class);
        int num = 0;
        try {
        	String id=request.getParameter("id");
        	String name=request.getParameter("name");
        	if(id==null || id=="") {
        		return "id不能为空！！！";
        	}
        	if(name==null || name=="") {
        		return "name不能为空！！！";
        	}
        	TestModel testModel=new TestModel(Integer.parseInt(id), name);
        	num=mapper.updateArtist(testModel);
        	session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return num+"";
    }

    /**
     * 删除
    */
	@RequestMapping("/deleteArtist")
    private String deleteArtist(HttpServletRequest request){
        SqlSession session=SQLController.getSession();
        TestMapper mapper=session.getMapper(TestMapper.class);
        int num = 0;
        try {
        	String id=request.getParameter("id");
        	if(id==null || id=="")  {
        		return "id不能为空！！！";
        	}
        	num=mapper.deleteArtist(Integer.parseInt(id));
        	session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return num+"";
    }
    
    
}
