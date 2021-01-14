package application.enums;

/**
 * Represente le coefficient de race, uniquement pour les chiens. Utilise pour le calcul de ration
 */
public enum Race
{
    NORD(0.8),
    PETIT(0.9),
    NORMAL(1),
    GRAND(1.1);

    /**
     * Coefficient de race
     */
    public final double k1;

    /**
     * Constructeur
     * @param k1
     * Coefficient de race
     */
    Race(double k1)
    {
        this.k1 = k1;
    }
}
