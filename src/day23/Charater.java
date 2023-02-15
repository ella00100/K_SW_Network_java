package day23;

public abstract class Charater {
    protected int hp;
    protected int mp;

    WeaponBehavior weapon;      // Association(Aggregation)

    abstract void info();

    public void setWeapon(WeaponBehavior weapon) {
        this.weapon = weapon;
    }
    public final void perfomWeapon(){
        weapon.useWeapon();
    }
}
