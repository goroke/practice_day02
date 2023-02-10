package pokemon;

public class Pokemon {
    // 상속 관련 문제 생기면 protected 로 바꿀 것
    private static int count = 0;
    protected String name;
    protected String owner = "";
    protected String skills[];

    public Pokemon(String owner, String skills){
        this.owner = owner;
        this.skills = skills.split("/");
        Pokemon.count++;
    }

    public static int getCount(){
        return Pokemon.count;
    }

    public String getOwner(){ return this.owner; }
    public void setOwner(String owner){ this.owner = owner; }

    public String[] getSkills(){
        return this.skills;
    }

    public void info() {
        System.out.printf("%s의 포켓몬이 사용 가능한 스킬\n", this.owner);
        for(int i=0; i < skills.length; ++i) {
            System.out.printf("%d : %s\n", i + 1, this.skills[i]);
        }
    }

    public void attack(int idx){
        System.out.printf("%s 공격 시전!", this.skills[idx]);
    }
}
