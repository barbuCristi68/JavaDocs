package ro.teamnet.zerotohero.day1;

/**
 * Created by Cristian.Barbu on 7/4/2017.
 */
public class VeterinarZoo implements AnimalZooRar.AngajatZoo {
    int bonus = 0;
    @Override
    public void calculeazaBonusSalarial() {
        bonus = valoareBonusPerAnimal*2;
    }

    @Override
    public void lucreaza(Animal animal) {
        System.out.println("Veterinarul are grija de animal");
        if(animal instanceof AnimalZooFeroce)
            animal.faceBaie();
        else
            calculeazaBonusSalarial();
    }

    public void showBonus(){
        System.out.println("VeterinarZoo Bonus:" + bonus);
    }
}
