package org.contract.api.util.di;

import org.contract.api.exceptions.AutowiredException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
     * @throws AutowiredException
     */
    public static void inject(Object object) throws AutowiredException {
        Field[] fields = object.getClass().getDeclaredFields();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties");
            Properties properties = new Properties();

            properties.load(fileInputStream);

            for (Field field : fields) {
                if (field.getAnnotation(Autowired.class) != null) {

                    Class cls = Class.forName(properties.getProperty(field.getAnnotatedType().toString()));
                    Object implInstance = null;
                    implInstance = cls.getDeclaredConstructor().newInstance();
                    field.setAccessible(true);
                    field.set(object, implInstance);
                }
            }
        }
        catch (IOException | ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new AutowiredException(e);
        }
    }
}
