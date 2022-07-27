import org.junit.Test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

 public class MainTest {

    private static List<ArrayList<Integer>> list;

    static{
        list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(50, 2, 1, 9)));
        list.add(new ArrayList<>(Arrays.asList(56, 5, 50)));
        list.add(new ArrayList<>(Arrays.asList(420,42,423)));
    }

    private Method getCompare() throws NoSuchMethodException {
        Method method = Main.class.getDeclaredMethod("compare", String.class, String.class);
        method.setAccessible(true);
        return method;
    }

    private Method getLargestNumber() throws NoSuchMethodException {
        Method method = Main.class.getDeclaredMethod("getLargestNumber", List.class);
        method.setAccessible(true);
        return method;
    }

    // 590 < 905 it will return a negative integer but as we want our greatest number to be at beginning of the list when we sort
    // this will help us to inverse the list
    @Test
    public void testIfFirstStringGreaterThanTheOther() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Integer value = (Integer) getCompare().invoke(null, "9","50");
        assertTrue(value<0);
    }

     /**
      * Test the private method to see if the method reach the result expected
      * @throws NoSuchMethodException
      * @throws InvocationTargetException
      * @throws IllegalAccessException
      */
    @Test
    public void testLargestNumber() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String value1 = (String) getLargestNumber().invoke(null, list.get(0));
        String value2 = (String) getLargestNumber().invoke(null, list.get(1));
        String value3 = (String) getLargestNumber().invoke(null, list.get(2));
        assertEquals("95021", value1);
        assertEquals("56550", value2);
        assertEquals("42423420", value3);
    }




}