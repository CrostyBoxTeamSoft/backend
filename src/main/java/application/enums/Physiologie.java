package application.enums;

/**
 * Represente le coefficient lie a la physiologie permettant de calculer les rations journalieres
 */
public enum Physiologie
{
    /*  CHAT    */
    CROISSANCECHAT10(250),
    CROISSANCECHAT20(130),
    CROISSANCECHAT30(100),
    CROISSANCECHAT40(80),

    ADULTECHAT(70),
    GESTATIONCHAT(100),
    LACTATIONCHAT(250),
    CASTRECHAT(45),

    AGECHAT(60),

    /*  CHIEN   */
    PRESEVRAGECHIEN(3),
    POSTSEVRAGECHIEN(2),
    CROISSANCECHIEN50(1.75),
    CROISSANCECHIEN70(1.5),
    CROISSANCECHIEN80(1.35),
    CROISSANCECHIEN100(1.2),

    ADULTECHIEN(1),

    GESTATIONCHIEN5(1.1),
    GESTATIONCHIEN6(1.2),
    GESTATIONCHIEN7(1.3),
    GESTATIONCHIEN8(1.4),
    GESTATIONCHIEN9(1.5),

    LACTATIONCHIEN(3),

    AGECHIEN(0.85),
    CASTRECHIEN(0.8);


    /**
     * Coefficient lie a la physiologie pour le calcul de ration
     */
    public final double stade;

    /**
     * Constructeur
     * @param stade
     */
    Physiologie(double stade)
    {
        this.stade = stade;
    }
}
