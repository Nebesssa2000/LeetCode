public class StackOverflowErrorMethod {
    public void stackOverflowErrorMethod() {
        stackOverflowErrorMethod();
    }

    public static void main(String[] args) {
        StackOverflowErrorMethod soe = new StackOverflowErrorMethod();
        soe.stackOverflowErrorMethod();
    }
}
