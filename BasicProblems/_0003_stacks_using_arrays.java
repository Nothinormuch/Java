import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class _0003_stacks_using_arrays{
    public static void main(String[] args) throws Exception{
        // new _0003_stacks_using_arrays().test_queue_using_array();
        // new _0003_stacks_using_arrays().test_queue_using_stack();
        // new _0003_stacks_using_arrays().test_stack_using_array();
        // new _0003_stacks_using_arrays().test_stack_using_queue();
        // new _0003_stacks_using_arrays().test_deque();
    }
    public void test_deque(){
        Deque<Integer> A = new ArrayDeque<>();
        A.add(0);
        A.add(0);
        A.add(0);
        A.addFirst(1);
        A.add(2);
        IO.print(A);
        A.remove();
        A.removeLast();
        IO.print("\n");
        IO.print(A);
    }
    public void test_queue_using_stack() throws Exception{
        QueueUsingStack<Integer> A = new QueueUsingStack<>();
        A.enque(1);
        A.enque(2);
        A.enque(3);
        A.enque(4);
        A.deque();
        A.print();
    }
    public void test_stack_using_queue() throws Exception{
        StackUsingQueue<Integer> A = new StackUsingQueue<>();
        A.push(1);
        A.push(2);
        A.push(3);
        A.push(4);
        A.pop();
        A.print();
    }
    public void test_queue_using_array() throws Exception{
        Queue<Integer> A = new Queue<>();
        A.enque(1);
        A.enque(2);
        A.enque(3);
        A.enque(4);
        A.deque();
        A.print();
    }
    public void test_stack_using_array() throws Exception{
        Stack<Integer> A = new Stack<>();
        A.push(1);
        A.push(2);
        A.push(3);
        A.push(4);
        A.pop();
        A.print();
    }

    class StackUsingQueue<T> {
        public Queue<T> queue;
        public StackUsingQueue(){
            this.queue = new Queue<>();
        }
        public void push(T obj) throws Exception{
            Queue<T> tmp = new Queue<>();
            while(this.queue.size()>0){
                tmp.enque(this.queue.deque());
            }
            this.queue.enque(obj);
            while(tmp.size()>0){
                this.queue.enque(tmp.deque());
            }
        }

        public T pop() throws Exception{
            if(this.queue.size()==0){
                throw new Exception("Queue Underflow");
            }
            T obj = this.queue.peek();
            this.queue.deque();
            return obj;
        }
        
        public T peek(){
            return this.queue.peek();
        }
        
        public int size(){
            return this.queue.size();
        }
        
        public void print() throws Exception{
            StackUsingQueue<T> tmp = new StackUsingQueue<>();
            IO.print("[");
            while(this.size()>0){
                IO.print(this.peek());
                if(this.size()!=1){
                    IO.print(" ");
                }
                tmp.push(this.pop());
            }
            IO.print("]");
            while(tmp.size()>0){
                this.push(tmp.pop());
            }
            
        }
    }

    class QueueUsingStack<T> {
        public Stack<T> stack;
        public QueueUsingStack(){
            this.stack = new Stack<>();
        }
        public void enque(T obj) throws Exception{
            Stack<T> tmp = new Stack<>();
            while(this.stack.size()>0){
                tmp.push(this.stack.pop());
            }
            this.stack.push(obj);
            while(tmp.size()>0){
                this.stack.push(tmp.pop());
            }
        }

        public T deque() throws Exception{
            if(this.stack.size()==0){
                throw new Exception("Stack Underflow");
            }
            T obj = this.stack.peek();
            this.stack.pop();
            return obj;
        }
        
        public T peek(){
            return this.stack.peek();
        }
        
        public int size(){
            return this.stack.size();
        }
        
        public void print() throws Exception{
            QueueUsingStack<T> tmp = new QueueUsingStack<>();
            IO.print("[");
            while(this.size()>0){
                IO.print(this.peek());
                if(this.size()!=1){
                    IO.print(" ");
                }
                tmp.enque(this.deque());
            }
            IO.print("]");
            while(tmp.size()>0){
                this.enque(tmp.deque());
            }
            
        }
    }

    class Queue<T> {
        public PythonList<T> arr;
        public Queue(){
            this.arr = new PythonList<>();
        }
        
        public void enque(T obj){
            this.arr.append(obj);
        }

        public T deque() throws Exception{
            if(arr.len()==0){
                throw new Exception("Stack Underflow");
            }
            T obj = this.arr.get(0);
            this.arr.pop(0);
            return obj;
        }
        
        public T peek(){
            return this.arr.get(0);
        }
        
        public int size(){
            return this.arr.len();
        }
        
        public void print() throws Exception{
            Queue<T> tmp = new Queue<>();
            IO.print("[");
            while(this.size()>0){
                IO.print(this.peek());
                if(this.size()!=1){
                    IO.print(" ");
                }
                tmp.enque(this.deque());
            }
            IO.print("]");
            while(tmp.size()>0){
                this.enque(tmp.deque());
            }
            
        }
    }

    class Stack<T> {
        public PythonList<T> arr;
        public Stack(){
            this.arr = new PythonList<>();
        }
        
        public void push(T obj){
            this.arr.append(obj);
        }

        public T pop() throws Exception{
            if(arr.len()==0){
                throw new Exception("Stack Underflow");
            }
            T obj = this.arr.get(arr.len()-1);
            this.arr.pop();
            return obj;
        }
        
        public T peek(){
            return this.arr.get(arr.len()-1);
        }
        
        public int size(){
            return this.arr.len();
        }
        
        public void print() throws Exception{
            Stack<T> tmp = new Stack<>();
            IO.print("[");
            while(this.size()>0){
                IO.print(this.peek());
                if(this.size()!=1){
                    IO.print(" ");
                }
                tmp.push(this.pop());
            }
            IO.print("]");
            while(tmp.size()>0){
                this.push(tmp.pop());
            }
            
        }
    }
    class PythonList<T> extends ArrayList<T>{
        public List<T> array;
        public PythonList(){
            this.array = new ArrayList<>();
        }

        public void append(T obj){
            this.array.add(obj);
        }

        public T pop(){
            T obj = this.array.get(this.array.size()-1);
            this.array.remove(this.array.size()-1);
            return obj;
        }
        public T pop(int index){
            T obj = this.array.get(index);
                this.array.remove(index);
            return obj;
        }
        
        public T get(int index){
            return this.array.get(index);
        }
        
        public T set(int index,T obj){
            T prev = this.array.get(index);
            this.array.set(index,obj);
            return prev;
        }
        
        public int len(){
            return this.array.size();
        }
    }
}
