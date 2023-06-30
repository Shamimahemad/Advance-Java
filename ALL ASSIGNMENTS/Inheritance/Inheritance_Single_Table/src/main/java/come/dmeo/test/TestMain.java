package come.dmeo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Employee;
import com.demo.beans.Person;
import com.demo.beans.Student;

public class TestMain {

	public static void main(String[] args) {
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		Person e=new Employee(1,"Shamim","IT","manager");
		Person s=new Student(2,"ganseh","PGDAC",80);
		sess.save(e);
		sess.save(s);
		tr.commit();
		sess.close();
		sf.close();
	}

}
