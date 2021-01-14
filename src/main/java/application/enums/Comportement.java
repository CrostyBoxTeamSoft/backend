package application.enums;

/**
 * Class representant les differents comportements des animaux
 */
public enum Comportement
{
    LETHARGIQUE(0.7,"Lethargique"),
    TCALME(0.8, "Tres calme"),
    CALME(0.9, "Calme"),
    NORMAL(1, "Normal"),
    ACTIF(1.1, "Actif"),
    HYPERACTIF(1.2, "Hyperactif");

    /**
     * Coefficient de comportement, utilise pour le calcul de ration
     */
    public final double k2;

    /**
     * Nom du comportement
     */
    public final String comportement;

    /**
     * Constructeur
     * @param k2
     * Coefficient de comportement
     * @param comportement
     * Nom du comportement
     */
    Comportement(double k2, String comportement)
    {
        this.k2 = k2;
        this.comportement = comportement;
    }
}
