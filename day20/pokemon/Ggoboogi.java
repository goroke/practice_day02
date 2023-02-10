package pokemon;

public class Ggoboogi extends Pokemon {

    public Ggoboogi(String owner, String skills) {
        super(owner, skills);
        this.name = "꼬부기";
        System.out.println(this.name);
    }

    @Override
    public void attack(int idx) {
        System.out.printf("[꼬북꼬북] %s의 %s가 %s 공격 시전!\n", this.owner, this.name, this.skills[idx]);
    }

    public void swim() {
        System.out.printf("%s가 수영을 합니다.", this.name);
    }
}
