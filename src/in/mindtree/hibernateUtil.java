package in.mindtree;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class hibernateUtil {

	private static final SessionFactory sessionFactory=buildSessionFactory();
	
	public static SessionFactory buildSessionFactory(){
		Configuration con=new Configuration();
		con.configure("hibernate.cfg.xml");
		
		ServiceRegistry sr=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		
		return con.buildSessionFactory(sr);
		
		
		
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
		
		
		
	}
}
