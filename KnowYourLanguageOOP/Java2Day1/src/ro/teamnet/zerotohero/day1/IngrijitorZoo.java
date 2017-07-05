package ro.teamnet.zerotohero.day1;

import ro.teamnet.zerotohero.day1.exceptions.AnimalPeCaleDeDisparitieException;

/**
 * Created by Cristian.Barbu on 7/4/2017.
 */
public class IngrijitorZoo implements AnimalZooRar.AngajatZoo {
    int bonus = 0;
    @Override
    public void calculeazaBonusSalarial() {
        this.bonus = valoareBonusPerAnimal*3;
    }

    @Override
    public void lucreaza(Animal animal) {
        System.out.println("Ingrijitorul intra in cusca animalului");
    }

    public void lucreaza(Animal animal, Object mancare) throws AnimalPeCaleDeDisparitieException {
        this.lucreaza(animal);
        animal.seJoaca();
        animal.doarme();
        animal.faceBaie();
        if((animal instanceof AnimalZooRar)&&(mancare == null)){
            throw new AnimalPeCaleDeDisparitieException("Animal pe cale de disparitie");
        }else
            calculeazaBonusSalarial();
    }

    public void showBonus(){
        System.out.println("IngrijitorZoo bonus: " + bonus);
    }
}
