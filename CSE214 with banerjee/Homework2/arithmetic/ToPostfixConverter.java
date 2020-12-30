package applications.arithmetic;

import datastructures.sequential.Stack;

/**
 * @author of implementation is Ethan Garcia. Interface written by Banerjee.
 * ToPostFixConverter allows us to convert infix to postfix. This, in turn, will allow us to evaluate said expression
 * This class implements the Converter interface written by Banerjee. The main methods here are ToPostfixConverter,
 * nextToken,and isOperand. Next token retrieves the next valid token in a string starting at the int specified. This
 * function allows us to retrieve our operators and digits for placement in our postfix expression. isOperand uses the
 * Brackets class and Operations class to identify Operators to determine whether a given string is an operator or not.
 * To PostfixConverter is the function that actually converts the expression. All classes use the Stack data structure
 * defined in the datastructures.sequential package. This class also uses the tokenbuilder nested class to create the
 * strings used by the next token method.
 *
 */
public class ToPostfixConverter implements Converter{
    /**Takes the expression and parses it using the nexttoken function. Everytime there is an operand, it is pushed onto
     * a character stack. When an operator is encountered we pop the stack 2 times and do the encountered operation.
     * This algorithm takes into account parenthesis and will adjusts the string accordingly to output a correct postfix
     * String.
     *
     * @param expression  the given arithmetic expression of type Arithmeticexpression.
     * @return A postfix expression string
     */
    @Override
    public String convert(ArithmeticExpression expression) {
        String toPrint = "";
        Stack<Character> tokenholder = new Stack<Character>();
        String bruh = expression.getExpression();
        for(int i=0;i < bruh.length();i++){
            /*if(!tokenholder.isEmpty()) {
                System.out.println(tokenholder.peek());
            }*/
            String tempadd = nextToken(bruh,i);
            if(isOperand(tempadd)) {
                toPrint = toPrint + tempadd + " ";
                i = i+tempadd.length()-1;
            }
            else{
                char tempchar = tempadd.charAt(0);
                Operator incoming = Operator.of(bruh.charAt(i));
                if(tokenholder.isEmpty()){
                    tokenholder.push(tempchar);
                }
                else if(!tokenholder.isEmpty()&&(!isOperand(tempadd)||Brackets.isLeftBracket(tempadd))){
                    if(Brackets.isLeftBracket(incoming.getSymbol())){
                        tokenholder.push(bruh.charAt(i));
                        continue;
                    }
                    if(incoming.getRank()>=Operator.of(tokenholder.peek()).getRank()&&!Brackets.isRightBracket(bruh.charAt(i))){
                        while (!tokenholder.isEmpty() && (incoming.getRank() >= Operator.of(tokenholder.peek()).getRank())) {
                            toPrint = toPrint + tokenholder.pop() + " ";
                        }
                        tokenholder.push(bruh.charAt(i));
                    }
                    else{
                            tokenholder.push(incoming.getSymbol());
                    }
                }
                if(!tokenholder.isEmpty()&&(Brackets.isRightBracket(bruh.charAt(i)))){
                    if(tokenholder.peek() == Operator.RIGHT_PARENTHESIS.getSymbol()){
                        tokenholder.pop();
                    }
                    while(Operator.of(tokenholder.peek()).getSymbol()!=Operator.LEFT_PARENTHESIS.getSymbol()){
                        toPrint = toPrint + tokenholder.pop() + " ";
                    }
                    tokenholder.pop();
                }
            }
        }
        while(!tokenholder.isEmpty()){
            toPrint = toPrint + tokenholder.pop()+" ";
        }
        return toPrint;
    }

    /**
     * Nexttoken builds strings starting at at the given int value. If the first character of the string is a operator,
     * it is immediately returned. Otherwise, the tokebuilder nested class is used to build a digit number until an
     * operator is encountered
     * @param s     the given string
     * @param start the given index
     * @return The next valid token, which is either a number or a operator
     */
    @Override
    public String nextToken(String s, int start) {
        TokenBuilder builder = new TokenBuilder();
        builder.append(s.charAt(start));
        if (!isOperand(builder.build())) {
            return builder.build();
        }
        for (int i = start+1; i < s.length(); i++) {
            if(isOperand(s.substring(i))){
                builder.append(s.charAt(i));
            }
            else{
                return builder.build();
            }
        }
        return builder.build();
    }

    /**
     * Checks if the given string is a operand or not. Used extensively by other methods in this class.
     * @param s the given string
     * @return a boolean value based on if the given string is a operand or not.
     */
    @Override
    public boolean isOperand(String s) {
        for(int i=0;i<s.length();i++){
            if(Operator.isOperator(s.charAt(i))||Brackets.isRightBracket(s.charAt(i))||Brackets.isLeftBracket(s.charAt(i))){
                return false;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
