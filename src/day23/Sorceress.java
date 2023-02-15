package day23;

public class Sorceress extends Charater{
    public Sorceress(){
        hp = 300;
        mp = 1000;
    }

    @Override
    void info(){
        System.out.println("체력 : " + hp + "\n지능 : " + mp);
    }
}