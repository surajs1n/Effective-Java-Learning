public class StartHere {
    public static void main(String []args) {
        Stack stack = new Stack();
        stack.push("String 1");
        stack.push("String 2");
        stack.push("String 3");
        stack.push("String 4");
        stack.push("String 5");

        stack.printStackState();

        stack.pop();
        stack.pop();

        stack.printStackState();
    }
}
