package JavaConcurrency;

public class ReorderingExample {

    public static class DataHolder {
        private int x;
        private int y;

        public int actor1() {
            x = 1;
            return y;
        }

        public int actor2() {
            y = 1;
            return x;
        }
    }
}
