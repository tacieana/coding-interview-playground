package leetcode.hashtables.easy;

import java.util.Hashtable;

/*
Runtime 6ms - 29.51% / Memory 44.54MB - 69.99%
*/
public class RomanToInt {

    public static void main(String args[]) {
        RomanToInt romanToInt = new RomanToInt();
        int valor = romanToInt.romanToInt("MCMXCIV");
        System.out.println(valor);
    }

    public int romanToInt(String s) {

        Hashtable basicRomans = new Hashtable<Character, Integer>();
        basicRomans.put('I', 1);
        basicRomans.put('V', 5);
        basicRomans.put('X', 10);
        basicRomans.put('L', 50);
        basicRomans.put('C', 100);
        basicRomans.put('D', 500);
        basicRomans.put('M', 1000);

        int integerValue = 0;
        for (int i = 0; i < s.length()-1; i++) {
            int currentNumber = (int)basicRomans.get(s.charAt(i));
            int nextNumber = (int)basicRomans.get(s.charAt(i+1));

            if (currentNumber < nextNumber) {
                integerValue -= currentNumber;
            } else {
                integerValue += currentNumber;
            }
        }

        return integerValue + (int)basicRomans.get(s.charAt(s.length()-1));
    }

}
