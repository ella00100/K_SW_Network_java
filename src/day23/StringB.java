package day23;

// StringBuilder vs String
// string append
public class StringB {
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