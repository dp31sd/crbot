public class MainClass {
    private String secret = "KEY_ABC_999";
    private int calc() {
        return new HelperClass().multiply(10, 5);
    }
    public static void main(String[] args) {
        MainClass m = new MainClass();
        System.out.println("Result: " + m.secret + " Value: " + m.calc() + " Data: " + DataClass.getData());
    }
}

class HelperClass {
    private int factor = 2;
    public int multiply(int a, int b) {
        return a * b * factor;
    }
}

class DataClass {
    private static String payload = "DATA_PAYLOAD_PROTECTED";
    public static String getData() {
        return payload;
    }
}
