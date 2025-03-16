package leetcode.kfactor;

public class Main {
    public static void main(String[] args) {

        try {
            FactorFinder factorFinder = new FactorFinder();
            if (args.length == 2) {
                int n = Integer.parseInt(args[0]);
                int k = Integer.parseInt(args[1]);
                System.out.println(String
                        .format("Factor %1 for %2 is: %3", n, k, factorFinder.kthFactor(n,k)));
            } else {
                throw new Exception("Not enough parameters");
            }
        } catch (Exception e) {
            System.out.println(String.format("Error on parameters: %1", e.toString()));
        }
    }
}