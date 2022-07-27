import java.util.*;

public class Main {

    private static List<ArrayList<Integer>> list;

    /**
     * Sort the list of Integer using our custom compare and then map it into a list of String
     * then we loop to concatenate into a single string
     * @param list
     * @return the result of a String which concatenate every element of the string list
     */
    private static String getLargestNumber(List<Integer> list){
        list.sort((a,b) -> compare(String.valueOf(a),String.valueOf(b)));
        List<String> list2 = list.stream().map(String::valueOf).toList();
        String largestNumber = "";
        for(String number: list2){
            largestNumber += number;
        }
        return largestNumber;
    }

    /**
     * We get the max number doing the addition of the two String to know if the first String should be first or the second String
     * String a = "9", String b = "50", compareTo will help us to know if the first String is greater than the second one
     * we inversed the compareTo because we want to sort by the greatest to leatest (we could have reversed the list too)
     * @param a
     * @param b
     * @return a Int value negative if ab is greater then ba, 0 if the ab equals ba and a positive value if ba is greater then ab
     */
    private static Integer compare(String a, String b){
        String ab = a+b;
        String ba = b+a;
        return ba.compareTo(ab);
    }

    /**
     * Static block to initialize all the lists
     */
    static {
        list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(50, 2, 1, 9)));
        list.add(new ArrayList<>(Arrays.asList(56, 5, 50)));
        list.add(new ArrayList<>(Arrays.asList(420,42,423)));
    }

    /**
     * We give in output the result of all the lists
     * @param args
     */
    public static void main(String[] args) {
        list.forEach( e -> System.out.println(getLargestNumber(e)));
    }
}
