import java.util.*;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class part
{
	public static void main(String args[])throws Exception
	{
		Configuration cfg=new Configuration();
		SessionFactory sf=cfg.configure().buildSessionFactory();
		Session ss=sf.openSession();
		mypojo pojo=new mypojo();
		mypojo1 pojo1=new mypojo1();
		Transaction tx=ss.beginTransaction();
		Query q=ss.createQuery("from mypojo");
		
		q.setFirstResult(0);  
		q.setMaxResults(10);  
		List list=q.list();//will return the records from 0 to 10th number
		System.out.println(list);
		
		List stud=q.list();
		Iterator it=stud.iterator();
		while(it.hasNext())
		{
			pojo=(mypojo)it.next();
			System.out.println(pojo.getRollno());
			System.out.println(pojo.getName());
			System.out.println(pojo.getAddress());
		}
		
		
		Query q1=ss.createQuery("from mypojo1");
		List stud1=q1.list();
		Iterator it1=stud1.iterator();
		while(it1.hasNext())
		{
			pojo1=(mypojo1)it1.next();
			System.out.println(pojo1.getPhoneno());
			System.out.println(pojo1.getEmail());
			System.out.println(pojo1.getPassword());
		}
		
		Query q2=ss.createQuery("update mypojo set name=:n where rollno=:i"); 
		//we use pojo class name not the table name
		q2.setParameter("n","Nitish");  
		q2.setParameter("i","101");  
		  
		int status=q2.executeUpdate();  
		System.out.println(status);  
		
		
		Query q3=ss.createQuery("delete from mypojo where rollno='101' ");  
		//specifying class name (mypojo) not tablename  
		int status1=q3.executeUpdate();
		System.out.println(status1);  
		tx.commit();  
		
		Query q4=ss.createQuery("select count(rollno) from mypojo");  
		System.out.println(q4);
		
	}
}



/*
 * create table details1(phoneno varchar2(30),email varchar2(30),password
 * varchar2(30));
 * 
 * insert into details1 values('99887766','sandip@gmail.com','1234')
 * 
 * create table details(rollno varchar2(30),name varchar2(30),address
 * varchar2(30));
 * 
 * insert into details values('101','sandip','bangalore')
 */