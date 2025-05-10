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

    public void setLife(int life){
        this.life = life;
    }

    public int getLife(){
        return life;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public Monster copy(){
        return new Monster(this.name, this.life);
    }
}
