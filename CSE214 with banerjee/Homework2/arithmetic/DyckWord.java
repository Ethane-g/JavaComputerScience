package applications.arithmetic;

import datastructures.sequential.Stack;

/**
 * @author Ritwik Banerjee
 * the DyckWord class is ultizied to ascertain whether or not an expression is a valid dyckword. An expression is a
 * valid dyck word if the parenthesis are balanced . This helps us to know
 * whether or not a valid mathematical expression is present. Thus, with the isDyckWord method, we can tell if an
 * expression is able to be converted from infix to postfix. The only method written by Ethan Garcia is isDyckword.
 * Note that not all dyck words are valid expressions, but for this homework, a valid dyckword is a valid expression.
 */
public class DyckWord {

    private final String word;

    /**
     * constructor for dyckwords
     * @throws IllegalArgumentException if the expression is not a valid dyck word checked with isDyckWord
     * @param word is the expression to be checked if it is a dyck word
     */
    public DyckWord(String word) {
        if (isDyckWord(word))
            this.word = word;
        else
            throw new IllegalArgumentException(String.format("%s is not a valid Dyck word.", word));
    }

    /**
     * @author Ethan Garcia
     * @param word is the String to be checked if it is a valid dyck word.
     *
     *        A word is a valid dyck word if it has balanced parenthesis. This method checks to see, not only if parenthesis are balanced,
     *        but also if the parenthesis correspond to one another (ie brackets match brackets and parenthesis match parenthesis.
     *        This method uses a stack to keep track of left brackets, if a right bracket is encountered, the stack is popped
     *        and checked for correspondence with the encountered bracket. If not, then false is returned. The string is iterated through
     *        and if the stack is empty then true is returned
     *
     * @returns a boolean value of true or false depending on the strings validity as a dyck word.
     */
    private static boolean isDyckWord(String word) {
        Stack<Character> leftbrackets = new Stack<>();
        for (int i = 0; i < word.length(); i++) {
            if (Brackets.isLeftBracket(word.charAt(i))) {
                leftbrackets.push(word.charAt(i));
            }else if (Brackets.isRightBracket(word.charAt(i))) {
                if(leftbrackets.isEmpty()){
                    return false;
                }
                else if(!Brackets.correspond(leftbrackets.peek(),word.charAt(i))){
                    return false;
                }
                else if(Brackets.correspond(leftbrackets.peek(),word.charAt(i))){
                    leftbrackets.pop();
                }
            }
        }
        if(leftbrackets.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     *
     * @return returns the string of the dyckword.
     */
    public String getWord() {
        return word;
    }

}
