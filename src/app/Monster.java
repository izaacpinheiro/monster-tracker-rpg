package app;

public class Monster {
    private String name;
    private int life;

    public Monster(String name, int life){
        this.life = life;
        this.name = name;
    }

    public void increaseLife(int num){
        this.life += num;
    }

    public void decreaselife(int num){
        this.life -= num;
        if (life < 0)
            life = 0;
    }

    public int getlife(){
        return life;
    }

    public String getname(){
        return name;
    }
}
