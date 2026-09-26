import java.util.Stack;
import java.util.Scanner;
public class _0004_infix_to_postfix{
    public static void main(String[] args){// //+++
        Scanner sc = new Scanner(System.in);
        IO.print("Enter the Expression: ");
        String exp = sc.nextLine();
        IO.print(new _0004_infix_to_postfix().infix_to_prefix(exp));
        IO.print("\n");
        IO.print(new _0004_infix_to_postfix().infix_to_postfix(exp));
        IO.print("\n");
    }// //---
    public String infix_to_prefix(String exp){// //+++
        Stack<Character> ops = new Stack<>();
        String tmp ="";
        for(char ch: exp.toCharArray()){
            tmp = switch(ch){
                case '(' -> ')';
                case ')' -> '(';
                default -> ch;
            }+tmp;
        }
        exp = tmp;
        String prefix="";
        boolean para_flag = false;
        for(char ch: exp.toCharArray()){
            switch(ch){
                case '+':
                case '-':
                case '/':
                case '*':
                case '^':
                case '(':
                case ')':
                    if(ch != ')' && ch == '(' || ops.size()==0 || ch!= '^' && priority(ops.peek())<=priority(ch) || ch == '^' && priority(ops.peek())<priority(ch)){
                        // IO.print(ops);
                        // IO.print("\n");
                        ops.push(ch);
                    }
                    else{
                        if(ch == ')'){
                            para_flag = true;
                        }
                        while(ops.size()>0 && ops.peek()!='(' && ch != '^' && priority(ops.peek())>priority(ch) || ch == '^' && priority(ops.peek())>=priority(ch)){
                            prefix+=ops.pop();
                        }
                        if(ops.size()>0 && ops.peek()=='(' && para_flag){
                            ops.pop();
                        }
                        else{
                            ops.push(ch);
                            para_flag = false;
                        }
                    }
                    break;
                case ' ':
                    break;
                default:
                    prefix+=ch;
                    break;
            }
        }
        while(ops.size()>0){
            if(ops.peek()!='('){
                prefix+=ops.pop();
            }
        }
        tmp = "";
        for(char ch: prefix.toCharArray()){
            tmp = ch + tmp;
        }
        prefix = tmp;
        return prefix;
    }// //---
    public String infix_to_postfix(String exp){// //+++
        Stack<Character> ops = new Stack<>();
        String postfix="";
        boolean para_flag = false;
        for(char ch: exp.toCharArray()){
            switch(ch){
                case '+':
                case '-':
                case '/':
                case '*':
                case '^':
                case '(':
                case ')':
                    if(ch != ')' && ch == '(' || ops.size()==0 || ch!= '^' && priority(ops.peek())<priority(ch) || ch == '^' && priority(ops.peek())<=priority(ch)){
                        ops.push(ch);
                    }
                    else{
                        if(ch == ')'){
                            para_flag = true;
                        }
                        while(ops.size()>0 && ops.peek()!='(' && ch != '^' && priority(ops.peek())>=priority(ch) || ch == '^' && priority(ops.peek())>priority(ch)){
                            postfix+=ops.pop();
                        }
                        if(ops.size()>0 && ops.peek()=='(' && para_flag){
                            ops.pop();
                        }
                        else{
                            ops.push(ch);
                            para_flag = false;
                        }
                    }
                    break;
                case ' ':
                    break;
                default:
                    postfix+=ch;
                    break;
            }
        }
        while(ops.size()>0){
            if(ops.peek()!='('){
                postfix+=ops.pop();
            }
        }
        return postfix;
    }// //---
    public int priority(char ch){// //+++
        return switch (ch){
            case '^' -> 3;
            case '*','/' -> 2;
            case '+','-' -> 1;
            case '(' -> 0;
            default -> -1;
        };
    }// //---
}
