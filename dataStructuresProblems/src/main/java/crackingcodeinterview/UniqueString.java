package crackingcodeinterview;

import java.util.HashMap;

/*Is Unique: Implement an algorithm to determine if a string has all unique characters.
What if you cannot use additional data structures?
 */
public class UniqueString {

    public static void main(String[] args) {

        System.out.println("Must be true: " + hashMapSolution("abcderfgkotl"));
        System.out.println("Must be false: " + hashMapSolution("taciana"));
        System.out.println("Must be false: " + hashMapSolution("dasdasd"));
        System.out.println("Must be true: " + hashMapSolution("qweErtyuioplkjhgfdsazxcvbnm"));
    }

    private static boolean solution(String string) {

        for (int i = 0; i < string.length(); i++) {
            if (i+1 < string.length() && string.indexOf(string.charAt(i)+"", i+1) != -1) {
                return false;
            }
        }
        return true;
    }

    private static boolean hashMapSolution(String string) {

        HashMap<String, Boolean> hashMap = new HashMap<>();

        for (int i = 0; i < string.length(); i++) {
            String actualChar = string.charAt(i)+"";
            if (hashMap.containsKey(actualChar)) {
                return false;
            }

            hashMap.put(actualChar, true);

        }

        return true;
    }
}
