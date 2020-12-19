package org.contract.api.util.di;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/**
 * @author Maxim Suhochev
 */
public class AutoInject {

    /**
     * Searches for fields marked with the @Autowired annotation
     * initializes these fields with class instances
     * They are specified in the config.properties file
     * @param object - class with annotations
     * @throws IllegalAccessException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void inject(Object object) throws IllegalAccessException, IOException, ClassNotFoundException {
        Field[] fields = object.getClass().getDeclaredFields();

        FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties");
        Properties properties = new Properties();

        properties.load(fileInputStream);

        for (Field field : fields) {
            if (field.getAnnotation(Autowired.class) != null) {

                Class cls = Class.forName(properties.getProperty(field.getAnnotatedType().toString()));
                Object implInstance = null;
                try {
                    implInstance = cls.getDeclaredConstructor().newInstance();
                } catch (InstantiationException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }

                field.setAccessible(true);
                field.set(object, implInstance);
            }
        }
    }
}
