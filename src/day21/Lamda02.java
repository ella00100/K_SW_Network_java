package day21;

interface Calc{
    double calculate(double d);
}
interface Gets{
    char get(String s, int i);
}

public class Lamda02 {
    public static void main(String [] args){
        Calc c;
        Gets g;
      //  c = d -> Math.abs(d);
      //  c = Math::abs;
      //  System.out.println(c.calculate(-9.9));

      //  g = (a,b) -> a.charAt(b);
        g = String::charAt;
        System.out.println(g.get("hello", 4));
    }

}
