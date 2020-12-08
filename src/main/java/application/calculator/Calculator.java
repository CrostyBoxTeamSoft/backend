package application.calculator;

import application.beans.Animal;

public class Calculator
{
    /*
    public static double rationJournaliere(Animal animal)
    {

    }
    */

    /*  Calcul des besoins énergétiques journaliers. Résultat en kcal   */
    private double besoinEnergetique(Animal animal)
    {
        switch (animal.getEspece())
        {
            case CHAT:
                return animal.getPoids()*animal.getComportement().k2*animal.getPhysiologique().stade;

            case CHIEN:
                return 156*Math.pow(animal.getPoids(), 0.67)*animal.getPhysiologique().stade*animal.getComportement().k2*animal.getK1().k1;

            default:
                return -1;
        }
    }
}
