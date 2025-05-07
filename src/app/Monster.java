package app;

public class Monster {
    private String name;
    private int life;

    public Monster(String name, int life){
        this.life = life;
        this.name = name;
    }

    // a single method for applying damage and healing
    public void changeLife(int amount){
        life += amount;
        if (life < 0) life = 0;
    }

    public int getLife(){
        return life;
    }

    public String getName(){
        return name;
    }
}
