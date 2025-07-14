import java.util.*;

public class Duplicate {

    public static boolean is_duplicate() {

        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        String words[] = s.split("\\s+");

        HashMap<String, Integer> map = new HashMap<>();
        for (String str : words) {
            str = str.toLowerCase();
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for (HashMap.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() > 1) {
                return true;
            }
        }
        return false;

    }  // is_duplicate method ends here....

    public static void main(String[] args) {

        boolean result = is_duplicate();
        System.out.println("Do duplicate words exist? " + result);
    
    } // Main-method ends here....

}