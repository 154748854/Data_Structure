package demo2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {
    public static void func() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
            Class<?> c1 = Class.forName("demo2.TestEnum");


        Constructor<?> constructor = c1.getDeclaredConstructor(String.class,int.class,int.class,String.class);
        constructor.setAccessible(true);

        TestEnum testEnum = (TestEnum) constructor.newInstance(6,"棕色");

        System.out.println(testEnum);
    }
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException{
        func();

    }
}
