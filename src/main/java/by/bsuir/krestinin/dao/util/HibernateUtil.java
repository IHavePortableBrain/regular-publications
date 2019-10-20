package by.bsuir.krestinin.dao.util;

import by.bsuir.krestinin.Application;
import by.bsuir.krestinin.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class HibernateUtil {

    private static final String DATABASE_PROPERTIES_FILENAME = "database.properties";
    private static SessionFactory sessionFactory;

    private HibernateUtil() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            establishConnection();
        }
        return sessionFactory;
    }

    private static void establishConnection() {
        try {
            Configuration configuration = new Configuration();

            Properties settings = loadProperties(DATABASE_PROPERTIES_FILENAME);

            configuration.setProperties(settings);
            configuration.addAnnotatedClass(Author.class);
            configuration.addAnnotatedClass(Calendar.class);
            configuration.addAnnotatedClass(Catalog.class);
            configuration.addAnnotatedClass(Event.class);
            configuration.addAnnotatedClass(Journal.class);
            configuration.addAnnotatedClass(Newspaper.class);
            configuration.addAnnotatedClass(Publication.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        } catch (Exception e) {
            System.err.println("Exception o db loading: ");
            e.printStackTrace();
        }
    }


    private static Properties loadProperties(String fileName) throws IOException {
        Properties props = new Properties();

        ClassLoader classLoader = Application.class.getClassLoader();

        try (InputStream inputStream = classLoader.getResourceAsStream(fileName)) {
            if (inputStream != null) {
                props.load(inputStream);
            }
        }

        return props;
    }
}
