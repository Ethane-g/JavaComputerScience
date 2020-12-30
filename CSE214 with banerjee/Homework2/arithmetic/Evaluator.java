package applications.arithmetic;

/** @author Ethan Garcia
 * This interface provides the blueprints to make a class for evaluating different kinds of expressions depending on
 * implementation. It also contains blueprints for the nexttoken method, which allows for the parsing of a string into
 * a tokens for use in the evaluator method. isOperand uses the brackets and operator enum classes to ascertain whether
 * a string is a operand or not, this is used in both the evaluate and nexttoken functions.
 *
 */
public interface Evaluator {

    /** This method takes in a string and provides the corresponding answer. In this homework it is used to evaluate
     * postfix expressions. Since this makes heavy use of the nextToken function, it is required that the tokens in the
     * expressionString be separated by spaces.
     *
     * @param expressionString the string expression to be evaluated
     * @return a double that is the result of the expression.
     */
    Double evaluate(String expressionString);

    /**
     * This method returns the next valid token starting from the given int of the string provided
     *
     * @param s     the given string to be parsed
     * @param start the given index from which to start the parsing
     * @return the next token starting at the given index in the given string
     */
    String nextToken(String s, int start);

    /**
     * Determines whether or not a string is an operand or not
     *
     * @param s the given string to be checked
     * @return true if the given string is a valid operand, and false otherwise
     */
    boolean isOperand(String s);
    

    /**
     * This class allows for the parsing of a string to a token. Since it is possible for some tokens to be longer than
     * one character, we use token builder to create strings that are full numbers. This allows us to parse strings for
     * use in the evaluator.
     *
     * comments written in the token builder nested class are written by Banerjee as he wrote the class.
     */
    class TokenBuilder {

        /**
         * The {@link StringBuilder} object used internally. This is used because {@link String}s in
         * Java are immutable, while we may want to build a token as we parse from left to right one
         * character at a time.
         */
        private StringBuilder tokenBuilder = new StringBuilder();

        /**
         * @see StringBuilder#append(char)
         */
        public void append(char c) {
            tokenBuilder.append(c);
        }

        /**
         * @return the final string object that represents a single token
         * @see StringBuilder#toString()
         */
        public String build() {
            return tokenBuilder.toString();
        }

    }

}
