package com.online.config;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.online.model.Cart;
import com.online.model.Category;
import com.online.model.OrderDetail;
import com.online.model.Product;
import com.online.model.Supplier;
import com.online.model.UserDetail;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.online")
public class DBconfig {
	//Creating the dataSource Bean
		@Bean(name="dataSource")
		public DataSource getH2DataSource()
		{
			DriverManagerDataSource dataSource=new DriverManagerDataSource();
			dataSource.setDriverClassName("org.h2.Driver");
			dataSource.setUrl("jdbc:h2:tcp://localhost/~/S190126");
			dataSource.setUsername("cdtje");
			dataSource.setPassword("cdtje");
			
			System.out.println("==========Data Source Object is Created==============");
			return dataSource;
		}
		
		//Creating a SessionFactory Bean 
		
		@Bean(name="sessionFactory")
		public SessionFactory getSessionFactory()
		{
			Properties hibernateProperties=new Properties();
			hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
			hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
			
			LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(this.getH2DataSource());
			factory.addProperties(hibernateProperties);
			
			factory.addAnnotatedClass(Category.class);
			factory.addAnnotatedClass(Product.class);
			factory.addAnnotatedClass(Supplier.class);
			factory.addAnnotatedClass(UserDetail.class);
			factory.addAnnotatedClass(Cart.class);
			factory.addAnnotatedClass(OrderDetail.class);
			
			SessionFactory sessionFactory=factory.buildSessionFactory();
			System.out.println("==============SessionFactory Object Created=============");
			return sessionFactory;
		}
		
		//Creating a HibernateTransactionManager Bean
		
		@Bean(name="txManager")
		public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
		{
			System.out.println("=====Hibernate Tranaction Manager Object Created=======");
			return new HibernateTransactionManager(sessionFactory);
		}

	}


