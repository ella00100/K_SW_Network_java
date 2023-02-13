//포켓몬의 자식 클래스 꼬부기 생성
public class Ggoboogi extends Pokemon{
    private String name = "꼬부기";
    public Ggoboogi(String owner, String skills) {
        super(owner, skills);
    }

    @Override
    public void attack(int idx) {
        System.out.println("[꼬북꼬북] " + getOwner() + "의 " + name + "가 "+ getSkills().get(idx) + "공격 시전!");
    }
}
