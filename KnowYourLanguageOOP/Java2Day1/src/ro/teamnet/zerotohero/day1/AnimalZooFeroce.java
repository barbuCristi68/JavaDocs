package ro.teamnet.zerotohero.day1;

import ro.teamnet.zerotohero.day1.exceptions.AnimalManancaOmException;

/**
 * Created by Cristian.Barbu on 7/4/2017.
 */
public class AnimalZooFeroce extends Animal {

    @Override
    public void doarme(){
        super.doarme();

        System.out.println("AnimalFeroce vaneaza");
    }

    @Override
    void mananca(Object obj) {
        if ((obj instanceof AnimalZooRar.AngajatZoo)||(obj instanceof Animal))
            throw new AnimalManancaOmException("Animal mananca om");
        else
            System.out.println("Inside mananca");
    }

    @Override
    void seJoaca() {
        System.out.println("Inside seJoaca");
    }

    @Override
    void faceBaie() {
        System.out.println("Inside faceBaie");
    }
}
