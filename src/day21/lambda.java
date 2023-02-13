package day21;

interface Positive {
    int pos(int x);
}

interface Prints{
    void print();
}

public class lambda {
    public static void main(String[] args){
        Positive po;
        Prints pr;

        po = (int n) -> {return n+1;};
        po = (n) -> {return n+1;};
        po = n -> {return n+1;};
        po = (int n) -> n+1;
        po = n->n+1;

        pr = () -> {
            System.out.println("Hi");
        };
        pr.print();
       // pr = () -> System.out.println("Hello");
       // pr.print();

    }
}
