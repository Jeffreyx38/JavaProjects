import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class main {


    /**
     * This method converts an array of strings to a list of infix tokens
     * @param line
     * @return a list of infix tokens
     *
     */
    public static List<Token> infix(String line) {

        //initialize list for infix tokens
        List<Token> infix = new ArrayList<>();

        //initialize to convert input to tokens
        Token token;

        //splits into str of tokens
        String[] split = line.split("\\s+");

        //loop through all str tokens
        for (int i = 0; i < split.length; i++) {

            //each token is coverted to optype
            opType ot = opType.convertToOpType(split[i]);

            //converts to tokens
            //
            if (ot == null) {
                token = new Operand(Integer.valueOf(split[i]));
            } else {
                token = new Operator(ot);
            }
            //add all tokens to list
            infix.add(token);
        }


        return infix;

    }

    /**
     *  this method converts a list of infix tokens to a list list of postfix tokens
     * @param infix
     * @return list of postfix tokens
     */
    public static List<Token> infix2postfix(List<Token> infix) {

        //initialize list for postfix tokens
        List<Token> postfix = new ArrayList<>();

        Stack<Token> stack = new Stack<>();

        //loop over all infix tokens
        for (Token token : infix){

            //add token to postfix list if operand
            if (token.isOperand()){
                postfix.add(token);
            }
            //if not operand
            else{

                //cast token to operator to use helpful methods
                Operator op = (Operator)token;

                // token = "("
                if (op.getVal().equals(opType.LPAR)){
                    stack.push(op);
                }
                //else if token = ")"
                else if(op.getVal().equals(opType.RPAR)){

                    //pop until "(" is encountered
                    while (!stack.isEmpty() && !stack.peek().toString().equals("(")){
                        postfix.add(stack.pop());
                    }
                    stack.pop();
                }else{
                    // pop operators while operators have equal or higher precedence than the current token
                    while(!stack.isEmpty() && op.getPrec(op.getVal().operation) <= op.getPrec(stack.peek().toString())) {
                        postfix.add(stack.pop());
                    }
                    //Push current token (operator) onto the stack.
                    stack.push(op);
                }
            }
        }
        while(!stack.isEmpty()){
            postfix.add(stack.pop());
        }

        return postfix;

    }//end infixtopost ()

    /**
     * This methods calculates the given token
     * @param tk - token
     * @param y
     * @param x
     * @return y (operator) x
     */
    public static Integer calculator(String tk, int y, int x){
        switch (tk){
            case "*":
                return y * x;

            case "/":
                return y / x;

            case "%":
                return y % x;

            case "+":
                return y + x;

            case "-":
                return y - x;
        }

        return null;
    }//end calculator()

    /**
     *
     * @param postfix
     * @return
     */
    public static Integer evalPostfix(List<Token> postfix){

        //initialize stack
        Stack<Token> stack = new Stack<>();

        //iterate postfix

        for (Token token : postfix) {
            //If it is an operand, push it on the stack.
            if(token.isOperand()){
                stack.push(token);

            }
            //if it is an operator, then
            else if(token.isOperator()){
                // x and y values to calulate
                int x = Integer.parseInt(stack.pop().toString());
                int y = Integer.parseInt(stack.pop().toString());

                int result = calculator(token.toString(), y, x);

                //covert results back to tokens
                opType ot = opType.convertToOpType(String.valueOf(result));

                if (ot == null) {
                    token = new Operand(Integer.valueOf(String.valueOf(result)));
                } else {
                    token = new Operator(ot);
                }

                //push back
                stack.push(token);

            }
        }
        //return total
        int total = Integer.parseInt(stack.pop().toString());

        return total;
    }//end evalPostfix

    /**
     * converts postfixs to strings
     * @param token
     * @return string of tokens
     */

    public static String postfix2String(List<Token> token){

        String result = "";
        for (Token i: token){
            result += i.toString() + " ";
        }

        return result + " = ";
    }//end postfixString

    /**
     * In the main file we read from file and store in a list
     * We iterate through this list and covert to infix list of tokens
     * Then use infix list of tokens to covert to postfix list of tokens
     * Finally, use this list of tokens to evaluate
     * @param args
     */

    public static void main(String args[]){


        //try and catch for file exception
        try {

            //list to store once we read from file
            //buffer to read using while loop
            List<String> input = new ArrayList<>();
            BufferedReader bufReader = new BufferedReader(new FileReader("input.infix"));
            String line = bufReader.readLine();
            while(line != null){
                input.add(line);
                line = bufReader.readLine();
            }

            //iterate all lines of the input
            for (int i=0; i < input.size() ; i++){

                //pass each line of input to str
                String str = input.get(i);

                //infix method to covert to infix and return list
                //infix2postfix method to covert to infix to postfix and return list
                //evalPostFix to evaluate the postfix
                List<Token> list=infix(str);
                List<Token> postfix=infix2postfix(list);
                Integer evaluation=evalPostfix(postfix);

                //Print results
                String s=postfix2String(postfix);
                System.out.printf("%s %d",s,evaluation);
                System.out.println();


            }//end forloop

        } catch (IOException e) {
            System.out.println(e);
        }


    }//end main()
}//end test()

