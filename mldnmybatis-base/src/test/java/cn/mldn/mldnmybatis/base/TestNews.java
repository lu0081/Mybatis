package cn.mldn.mldnmybatis.base;

import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.mldn.util.MyBatisSessionFactory;
import cn.mldn.vo.News;

public class TestNews {
	@Test
	public void testAdd() throws Exception {
	News vo = new News();
	vo.setTitle("今天是个好天气");
	vo.setPubdate(new Date());
	System.out.println(MyBatisSessionFactory.getSession().insert("cn.mldn.mapping.NewsNS.doCreate",vo));
	MyBatisSessionFactory.getSession().commit();
	System.out.println("当前增长ID为: " + vo.getNid());
	MyBatisSessionFactory.close();
	}
	
	@Test
	public void  testEdit() throws Exception {
		News vo = new News();
		vo.setTitle("中国人民共和国");
		vo.setPubdate(new Date());
		vo.setNid(6);
		System.out.println(MyBatisSessionFactory.getSession().update("cn.mldn.mapping.NewsNS.doEdit",vo));
		MyBatisSessionFactory.getSession().commit();
		MyBatisSessionFactory.close();
	}
	
	@Test
	public void testRemove() throws Exception {
		System.out.println(MyBatisSessionFactory.getSession().delete("cn.mldn.mapping.NewsNS.doRemove",3L));
		MyBatisSessionFactory.getSession().commit();
		MyBatisSessionFactory.close();
	}
	
}
