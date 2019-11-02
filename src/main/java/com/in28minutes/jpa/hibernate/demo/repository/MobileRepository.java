package com.in28minutes.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.hibernate.demo.entity1.AppleMobile;
import com.in28minutes.jpa.hibernate.demo.entity1.SamsungMobile;

@Repository
@Transactional
public class MobileRepository 
{
	@Autowired
	EntityManager em;
	
	public void insertAppleMobile(AppleMobile app)
	{
		em.persist(app);
	}
	
	public void insertSamsungMobile(SamsungMobile sam)
	{
		em.persist(sam);
	}
	public List<AppleMobile> getAppleMobileList()
	{
		TypedQuery<AppleMobile> query = em.createQuery("select e from AppleMobile e", AppleMobile.class);
		List<AppleMobile> mobilesApple = query.getResultList();
		return mobilesApple;
	}
	
	public List<SamsungMobile> getSamMobileList()
	{
		TypedQuery<SamsungMobile> query = em.createQuery("select e from SamsungMobile e", SamsungMobile.class);
		List<SamsungMobile> mobilessam = query.getResultList();
		return mobilessam;
	}
	
	public synchronized void testMobilesInheritance() throws InterruptedException
	{
		AppleMobile app1=new AppleMobile("Apple", "IOS4", 50000);
		//app1.setId(1000L);
		AppleMobile app2=new AppleMobile("Apple", "IOS5", 60000);
		
		SamsungMobile sam1=new SamsungMobile("SamSung", "JellyBean", 6000);
		SamsungMobile sam2=new SamsungMobile("SamSung", "LolliPop", 9000);
		insertAppleMobile(app1);
		//insertAppleMobile(app2);
		insertSamsungMobile(sam1);
		//insertSamsungMobile(sam2);
	}

}
