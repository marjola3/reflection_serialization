package dao;


import com.sun.istack.internal.NotNull;

import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * User: Mariola
 * Date: 25.10.13
 */
public class TextsDao {
    @Deprecated
    public static String getTextDeprecated(String key){
        Properties properties = new Properties();
        String text = null;
        try {
            properties.load(TextsDao.class.getClassLoader().getResourceAsStream("texts.properties"));
            text = properties.getProperty(key);
        } catch (IOException e) {
            return text;
        }
        return text;
    }

    public static String getText( String key){
        ResourceBundle rb = ResourceBundle.getBundle("texts");
        return rb.getString(key);
    }
}
