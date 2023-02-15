package day23;

public class StringBuilder {
        public static void main(String[] args) {
            String s = new String("hello");
            long start = System.nanoTime();
            for(int i = 1; i<100000; i++)
                s = s + "~~";
            long end = System.nanoTime();
            System.out.println(end - start);

            StringBuilder sb = new StringBuilder("hello");
            start = System.nanoTime();
            for(int i = 1; i<100000; i++)
                sb = sb.append("~~");
            end = System.nanoTime();
            System.out.println(end - start);
        }
    }