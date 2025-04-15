package aplication;

public class Monstro {

    private String nome;
    private int vida;

    public Monstro(String nome, int vida){
        this.vida = vida;
        this.nome = nome;
    }

    public void aumentarVida(int num){
        this.vida += num;
    }

    public void diminuirVida(int num){
        this.vida -= num;
        if (vida < 0)
            vida = 0;
    }

    public int getVida(){
        return vida;
    }

    public String getNome(){
        return nome;
    }
}
