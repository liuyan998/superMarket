package utils;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyComponentPathImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.junit.Test;

public class HibernateUtils 
{
		private static Configuration configuration =null;
		private static SessionFactory sessionFactory = null;
		
		static
		{
			try {
				StandardServiceRegistry standardRegistry =
						new StandardServiceRegistryBuilder()
						.configure()
						.build();
				Metadata metadata = new MetadataSources(standardRegistry)
						.getMetadataBuilder()
						.applyImplicitNamingStrategy(ImplicitNamingStrategyComponentPathImpl.INSTANCE)
						.build();
				sessionFactory = metadata.getSessionFactoryBuilder().build();
			} catch (HibernateException e) {
				e.printStackTrace();
			}
			
		}
		@Test
		public void test() {
			try {
				Session sess = HibernateUtils.getCurrentSession();
				Transaction transaction = sess.beginTransaction();
				sess.doWork(new Work() {

					@Override
					public void execute(Connection arg0) throws SQLException {
						System.out.println(arg0);
					}
					
				});
				transaction.commit();
			} catch (HibernateException e) {
				e.printStackTrace();
			}
		}
		
		// 从连接池获取的
		public static Session openSession()
		{
			return sessionFactory.openSession();
		}
		
		// 从当前线程(threadLoacl)中获取绑定的session 
		// 好处: 在多层之间调用方法获取的都是同一个session
		public static Session getCurrentSession()
		{
			/*特点: 1 默认是关闭的 需要配置开启
				   2 会自动给你关闭连接*/
			Session session = sessionFactory.getCurrentSession();
			return session;
		}
		
		public static SessionFactory getSessionFactory() {
			return sessionFactory;
		}
}
