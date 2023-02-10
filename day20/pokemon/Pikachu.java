package pokemon;

public class Pikachu extends Pokemon {

    public Pikachu(String owner, String skills) {
        super(owner, skills);
        this.name = "피카츄";
        System.out.println(this.name);
    }

    @Override
    public void attack(int idx) {
        System.out.printf("[삐까삐까] %s의 %s가 %s 공격 시전!\n", this.owner, this.name, this.skills[idx]);
    }
}
