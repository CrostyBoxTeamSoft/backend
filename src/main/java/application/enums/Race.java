package application.enums;

public enum Race
{
    NORD(0.8),
    PETIT(0.9),
    NORMAL(1),
    GRAND(1.1);

    public final double k1;

    Race(double k1)
    {
        this.k1 = k1;
    }
}
