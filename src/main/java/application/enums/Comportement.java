package application.enums;

public enum Comportement
{
    LETHARGIQUE(0.7,"Lethargique"),
    TCALME(0.8, "Tres calme"),
    CALME(0.9, "Calme"),
    NORMAL(1, "Normal"),
    ACTIF(1.1, "Actif"),
    HYPERACTIF(1.2, "Hyperactif");

    public final double k2;
    public final String comportement;

    Comportement(double k2, String comportement)
    {
        this.k2 = k2;
        this.comportement = comportement;
    }
}
