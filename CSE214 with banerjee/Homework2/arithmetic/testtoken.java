package applications.arithmetic;

import java.util.Locale;

public class testtoken{
    public static void main(String[] args) {
        System.out.println(nextToken("11.5",0));
    }

    public static String nextToken(String s, int start) {
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

    public static boolean isOperand(String s) {
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
    static class TokenBuilder {

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
