package day23;

public class day23 {
    public static void main(String [] args){
        Sorceress s1 = new Sorceress();  // 캐릭터 객체 생성
        Barbarian b1 = new Barbarian();
        s1.info();

        Bow windForce = new Bow();       // 화살 객체 생성
        Axe berserwkerAxe = new Axe();

        s1.setWeapon(windForce);
        s1.perfomWeapon();

        b1.setWeapon(berserwkerAxe);
        b1.perfomWeapon();

        s1.setWeapon(new Axe());
        s1.perfomWeapon();
    }
}
