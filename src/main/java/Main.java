import configuration.Connection;
import dao.TextsDao;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Main {

    /**
     * @param args
     * @throws InvocationTargetException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws SecurityException
     * @throws NoSuchMethodException
     */
    public static void main(String[] args) throws ClassNotFoundException, MalformedURLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchMethodException, SecurityException {
        Connection connection = new Connection("to jest connection Url");

        // dynamicznie zaciągac z parametrów z iv.xml
        String classPath = TextsDao.getText("projectPath");

        File customElementsDir = new File(classPath);
        URL[] urls = null;
        try {
            URL url = customElementsDir.toURI().toURL();
            urls = new URL[]{url};

            URLClassLoader ucl = new URLClassLoader(urls);
            Class c = ucl.loadClass(TextsDao.getText("className"));

            // wywolac konstruktor z parametrem "externalConnection"
            /*
			 *   //Class[] argTypes = {String.class};
			 *  c.newInstance();
			*/

            Class[] argTypes = {Connection.class};
            Constructor[] tt = c.getConstructors();
            Constructor constructor = c.getConstructor(argTypes);
            Object[] arguments = {connection};
            Object instance = constructor.newInstance(arguments);


            for (Method m : c.getMethods()) {
                if (m.getName().equalsIgnoreCase("methodB")) {
                    System.out.println("begin: " + m.getName());

                    // dynamicznie zczytywa zapisane w testUni.xml parametry i podawac
                    m.invoke(instance, 1, 2);

                    System.out.println("end: " + m.getName());
                }

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}