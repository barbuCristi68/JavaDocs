package ro.teamnet.zerotohero.day1;

/**
 * Created by Cristian.Barbu on 7/4/2017.
 */
public abstract class Animal {
    private String nume;
    private String numeleTariiDeOrigine;
    abstract void mananca(Object obj);
    abstract void seJoaca();
    abstract void faceBaie();
    public void doarme(){
        System.out.println("Animalul doarme!");
    }

    public Animal(){
        System.out.println("Animal nou!");
    }

}
