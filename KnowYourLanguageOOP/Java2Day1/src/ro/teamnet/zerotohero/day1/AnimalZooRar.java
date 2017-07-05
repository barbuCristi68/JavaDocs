package ro.teamnet.zerotohero.day1;

import ro.teamnet.zerotohero.day1.exceptions.AnimalManancaOmException;

/**
 * Created by Cristian.Barbu on 7/4/2017.
 */
public class AnimalZooRar extends Animal {

    private String nume;
    private String numeleTariiDeOrigine;

    public AnimalZooRar(){
        setNume("");
        setNumeleTariiDeOrigine("");
    }

    public AnimalZooRar(String nume){
        setNume(nume);
        setNumeleTariiDeOrigine("");
    }

    public AnimalZooRar(String nume, String numeleTariiDeOrigine){
        setNume(nume);
        setNumeleTariiDeOrigine(numeleTariiDeOrigine);
    }

    @Override
    void mananca(Object obj) throws AnimalManancaOmException{
        if((obj instanceof AngajatZoo)||(obj instanceof Animal)) {
            throw new AnimalManancaOmException("Animalul Mananca Om");
        }
        else System.out.println("AnimalZooRar mananca");
    }

    @Override
    void seJoaca() {
        System.out.println("AnimalulZooRar se joaca");
        super.doarme();
    }

    @Override
    void faceBaie() {
        System.out.println("AnimalulZooRar face baie");
    }

    public String getNume() {
        return nume;
    }

    public String getNumeleTariiDeOrigine() {
        return numeleTariiDeOrigine;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setNumeleTariiDeOrigine(String numeleTariiDeOrigine) {
        this.numeleTariiDeOrigine = numeleTariiDeOrigine;
    }

    /**
     * Created by Cristian.Barbu on 7/4/2017.
     */
    public static interface AngajatZoo {
        Integer bonus = 0 ;
        Integer valoareBonusPerAnimal = 50;
        void calculeazaBonusSalarial();
        void lucreaza(Animal animal);
    }
}
