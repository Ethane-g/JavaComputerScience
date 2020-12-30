package applications.arithmetic;

import datastructures.sequential.Stack;

/** @author Ethan Garcia
 * This class is used to evaluate postfix expressions with individual operators and operands separated by spaces.
 * This allows us to use the converted infix expression to be processed into an actual answer. Both Nexttoken and
 * isOperand have similar functions to what they did in the ToPostfixConverter,but with slightly different
 * implementation. The evaluator uses a stack to store numbers and do operations.
 */
public class PostfixEvaluator implements Evaluator{
    /**
     * This function uses the other two functions to find tokens and if theyre operands, add them to a stack, otherwise
     * add operate on the given stack. For each time a operator is encountered, we pop the stack 2 times to operate
     * depending on the given operation.
     * @param expressionString the string expression to be evaluated
     * @return
     */
    @Override
    public Double evaluate(String expressionString) {
        Stack<Double> doubleStack = new Stack<>();
        for(int i = 0;i<expressionString.length();i++) {
            if(expressionString.charAt(i)==' ') {
                continue;
            }
            if(isOperand(nextToken(expressionString,i))){
                doubleStack.push(Double.parseDouble(nextToken(expressionString,i)));
                i=i+nextToken(expressionString,i).length()-1;
            }
            else{
                if(!doubleStack.isEmpty()){
                    double first = doubleStack.pop();
                    double second = doubleStack.pop();
                    if(expressionString.charAt(i)==Operator.MULTIPLICATION.getSymbol()){
                        doubleStack.push(first*second);
                    }
                    if(expressionString.charAt(i)==Operator.DIVISION.getSymbol()){
                        doubleStack.push(second/first);
                    }
                    if(expressionString.charAt(i)==Operator.ADDITION.getSymbol()){
                        doubleStack.push(first+second);
                    }
                    if(expressionString.charAt(i)==Operator.SUBTRACTION.getSymbol()){
                        doubleStack.push(second-first);
                    }
                }
            }
        }
        return doubleStack.pop();
    }

    /**
     * Creates a token from the given string starting at the given integer. Given string must have tokens separated by
     * spaces so that parsing occurs correctly. Makes extensive use of the isOperand function.
     * @param s     the given string to be parsed
     * @param start the given index from which to start the parsing
     * @return a token, either a operator or operand, to be analyzed by the evaluator method.
     */
    @Override
    public String nextToken(String s, int start) {
        int counter=start+1;
        TokenBuilder builder = new TokenBuilder();
        builder.append(s.charAt(start));
        if (!isOperand(builder.build())) {
            return builder.build();
        }
        else {
            while (counter != s.length() && s.charAt(counter) != ' ') {
                builder.append(s.charAt(counter));
                counter++;
            }
        }
        return builder.build();
    }

    /**
     * Uses the Brackets and Operator class to check whether or not a string is a operand
     * @param s the given string to be checked
     * @return
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
