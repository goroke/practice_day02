package pokemon;

public class Pairi extends Pokemon {

    public Pairi(String owner, String skills) {
        super(owner, skills);
        this.name = "파이리";
        System.out.println(this.name);
    }

    @Override
    public void attack(int idx) {
        System.out.printf("[파읠파읠] %s의 %s가 %s 공격(불) 시전!\n", this.owner, this.name, this.skills[idx]);
    }
}
