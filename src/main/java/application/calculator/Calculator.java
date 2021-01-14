package application.calculator;

import application.beans.Animal;

/**
 * Class Calculator
 * Permet de calculer la ration journaliere ideale d'un animal
 */
public class  Calculator
{
    /**
     * Calcul la ration journliere ideal d'un animal. Resultat en gramme
     * @param animal
     * @see Animal
     */
    public static void rationJournaliere(Animal animal)
    {
        double rationJournaliere = besoinEnergetique(animal)/animal.getKcalCroquettes();
        animal.setRation(rationJournaliere);
    }

    /**
     * Calcul le besoin energetique journalier d'un animal. Resultat en kcal
     * @param animal
     * @return
     * @see Animal
     */
    private static double besoinEnergetique(Animal animal)
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
