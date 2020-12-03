package application.beans;


public class InscriptionParameters
{
    private String pseudo, mdp, confirmer, email;

    public String getPseudo()
    {
        System.out.println("Pseudo "+pseudo);
        return pseudo;
    }

    public void setPseudo(String pseudo)
    {
        this.pseudo = pseudo;
    }

    public String getMdp()
    {
        System.out.println("MDP "+mdp);
        return mdp;
    }

    public void setMdp(String mdp)
    {
        this.mdp = mdp;
    }

    public String getConfirmer()
    {
        System.out.println("Confirmer "+confirmer);
        return confirmer;
    }

    public void setConfirmer(String confirmer)
    {
        this.confirmer = confirmer;
    }

    public String getEmail()
    {
        System.out.println("Email "+email);
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public InscriptionParameters()
    {
    }

    public InscriptionParameters(String pseudo, String mdp, String confirmer, String email)
    {
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.confirmer = confirmer;
        this.email = email;
    }
}
