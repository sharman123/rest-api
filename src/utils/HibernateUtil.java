package utils;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
        	Configuration configuration = new Configuration()
        			.configure("hibernate.cfg.xml");
        	SessionFactory sessionFactory = configuration.buildSessionFactory();
 //       	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
  //      	applySettings(configuration.getProperties());
  //      	SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());

//            SessionFactory sessionFactory = new Configuration()
 //                   .configure("hibernate.cfg.xml")
 //                   .buildSessionFactory();

            return sessionFactory;

        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }

}