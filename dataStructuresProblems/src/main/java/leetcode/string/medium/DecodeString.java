package leetcode.string.medium;

import java.util.Stack;

/*
Given an encoded string, return its decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
Note that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc.
Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k.
For example, there will not be input like 3a or 2[4].
Runtime: 72.56% / Memory 58.47% (primeira solucao usando contactenacao de string com +  deu 24/25)
O codigo esta comentado porque demorei das 16:40 as 19:13 para resolver
 */
public class DecodeString {
    public static String decodeString(String s) {

        Stack<String> stack = new Stack();

        for (int i = 0; i < s.length(); i++) {

            // Enquanto nao achar o fim de uma string empilha
            if (s.charAt(i) != ']') {
                stack.push(String.valueOf(s.charAt(i)));
            } else {

                // Enquanto nao achar o inicio da string monta a substring
                StringBuilder substring = new StringBuilder();
                while (!stack.peek().equals("[")) { // peek olha para o primeiro da pilha sem remover
                    substring.insert(0, stack.pop());
                }

                //remove o "["
                stack.pop();

                // Enquanto o primeiro da fila for um numero pega ele
                StringBuilder number = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    number.insert(0, stack.pop());
                }

                // Empilha a string decodificada repetindo conforme a quantidade encontrada antes do [
                stack.push(substring.toString().repeat(Integer.parseInt(number.toString())));
            }
        }

        // percorre a pilha final montando o resultado
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        return result.toString();
    }
}
