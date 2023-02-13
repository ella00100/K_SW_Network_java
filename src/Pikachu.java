//포케몬의 자식 클래스 피카츄 생성
public class Pikachu extends Pokemon {
    private String name = "피카츄";
    public Pikachu(String owner, String skills) {
        super(owner, skills);
    }

    @Override
    public void attack(int idx) {
        System.out.println("[삐까삐까] " + getOwner() + "의 " + name + "가 "+ getSkills().get(idx) + "공격 시전!");
    }
}
