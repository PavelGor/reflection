package test;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import static main.Reflection.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ReflectionTest {

    private String string = "Masha";
    private Employee employee = new Employee();
    private Developer developer = new Developer();

    @Before
    public void setUp() {
        employee.setName("Pavel");
        employee.setAge(35);
        employee.setGender('M');
        employee.setSalary(3535);
        developer.setFixedBugs(200);
        developer.setAge(12);
        developer.setGender('F');
        developer.setName("Ann");
        developer.setSalary(0.1);
    }

    @Test
    public void getObjectTest() throws InstantiationException, IllegalAccessException {
        assertEquals(string.getClass(), getObject(string.getClass()).getClass());
        assertTrue(getObject(string.getClass()) instanceof String);
    }

    @Test
    public void callMethodsTest() throws InvocationTargetException, IllegalAccessException {
        callMethods(employee);
    }

    @Test
    public void showFinalMethodsTest() {
        showFinalMethods(string);
    }

    @Test
    public void showNotPublicMethodsTest() {
        showNotPublicMethods(String.class);
    }

    @Test
    public void showInterfacesTest() {
        ArrayList<String> stringArrayList = new ArrayList<>();
        showInterfaces(stringArrayList.getClass());
    }

    @Test
    public void replaceValuesTest() throws IllegalAccessException {
        assertEquals(200, developer.getFixedBugs());
        replaceValues(developer);
        assertEquals(0, developer.getFixedBugs());
    }
}