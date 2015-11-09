/**
 * Created by allancaine on 2015-11-09.
 */
public class TestStack {

    public static void main(String[] args){
        MyStack<Integer> stack = new MyStack<>();


        stack.push(3);
        stack.push(8);
        stack.push(11);
        stack.push(2);

        while (!stack.isEmpty()){
            Integer integer = stack.pop();
            System.out.println(" result " + integer);
        }

    }
}
