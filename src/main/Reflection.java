package main;

import java.lang.reflect.*;

public class Reflection {

    public static Object getObject(Class klass) throws IllegalAccessException, InstantiationException {
        return klass.newInstance();
    }

    public static void callMethods(Object object) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = object.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.getParameters().length == 0) {
                method.invoke(object);
            }
        }
    }

    public static void showFinalMethods(Object object) {
        Method[] methods = object.getClass().getMethods();
        for (Method method : methods) {
            if (Modifier.isFinal(method.getModifiers())) {
                System.out.println(method);
            }
        }
    }

    public static void showNotPublicMethods(Class klass) {
        Method[] methods = klass.getDeclaredMethods();
        for (Method method : methods) {
            if (!Modifier.isPublic(method.getModifiers())) {
                System.out.println(method);
            }
        }
    }

    public static void showInterfaces(Class klass) {
        Class[] interfaces = klass.getInterfaces();
        System.out.println("Interfaces of class : ");
        for (Class anInterface : interfaces) {
            System.out.println(anInterface.getName());
        }
        System.out.println("SuperClasses of class : ");
        while (klass != Object.class) {
            Class superClass = klass.getSuperclass();
            System.out.println(superClass);
            klass = superClass;
        }
    }

    public static void replaceValues(Object object) throws IllegalAccessException {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (Modifier.isPrivate(field.getModifiers())) {
                field.setAccessible(true);

                if (field.getType() == char.class) {
                    field.set(object, '\u0000');
                } else if (field.getType() == boolean.class) {
                    field.set(object, false);
                } else if (field.getType() == int.class
                        || field.getType() == short.class
                        || field.getType() == long.class
                        || field.getType() == byte.class
                        || field.getType() == long.class
                        || field.getType() == double.class
                        || field.getType() == float.class) {
                    field.set(object, 0);
                } else {
                    field.set(object, null);
                }

                field.setAccessible(false);
            }
        }
    }

}
