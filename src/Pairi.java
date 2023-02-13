//포켓몬의 자식 클래스 파이리 생성
public class Pairi extends Pokemon {
    private String name = "파이리";
    public Pairi(String owner, String skills) {
        super(owner, skills);
    }

    @Override
    public void attack(int idx) {
        System.out.println("[파읠파읠] " + this.owner + "의 " + name + "가 "+ this.skills.get(idx) + "공격 시전!");
    }
}
