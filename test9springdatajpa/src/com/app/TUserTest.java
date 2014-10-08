package com.app;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.TUser;
import com.repository.TUserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TUserTest extends AbstractJUnit4SpringContextTests{
	@Autowired
	private TUserRepository tUserRepository;
	
	
	
	@Test
	@Transactional
	public void saveTest(){
		TUser tu=new TUser("name", "pass");
		TUser t=tUserRepository.save(tu);
		System.out.println(t);
	}
	
	@Test
	public void findAll(){
		 List<TUser> list=tUserRepository.findAll();
		 for (TUser tUser : list) {
			System.out.println(tUser);
		}
	}
	
	@Test
	@Transactional
	public void delete(){
		tUserRepository.delete(Long.valueOf(1));
	}

}
