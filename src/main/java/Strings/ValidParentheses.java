package Strings;

import java.util.LinkedList;

public class ValidParentheses {

    boolean isValid (String parentheses) {
        /*
        if even number of parentheses - always false
         */
        if (parentheses.length() == 0 || parentheses.length() % 2 != 0) return false;

        LinkedList<Character> characterList = new LinkedList<>();

        /*
        use LinkedList as a Stack
         */
        for (char c:parentheses.toCharArray()) {
            if(c == '(' || c == '{' || c == '['){
                characterList.addFirst(c);
            } else if (c == ')' && characterList.size()!=0 && characterList.getFirst() == '(') {
                characterList.removeFirst();
            } else if (c == '}' && characterList.size()!=0 && characterList.getFirst() == '{') {
                characterList.removeFirst();
            } else if (c == ']' && characterList.size()!=0 && characterList.getFirst() == '[') {
                characterList.removeFirst();
            }
        }
        return characterList.size()==0;
        /*
        this algorithm has O(n) complexity and could be improved if we stop to check all string
        while first closing parentheses does not match with last opened
         */
    }
}
