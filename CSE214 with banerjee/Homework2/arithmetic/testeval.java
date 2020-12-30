package applications.arithmetic;

public class testeval {
    public static void main(String[] args) {
        String a = "1234 123";
        System.out.println(nextToken(a,0));
    }
    public static String nextToken(String s, int start) {
        int counter=1;
        Evaluator.TokenBuilder builder = new Evaluator.TokenBuilder();
        builder.append(s.charAt(start));
        if (!isOperand(builder.build())) {
            return builder.build();
        }
        while(counter!=s.length()&&s.charAt(counter)!=' ') {
            builder.append(s.charAt(counter));
            counter++;
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
}
