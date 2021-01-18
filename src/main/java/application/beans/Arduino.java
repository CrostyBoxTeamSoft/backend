package application.beans;

import javax.persistence.*;

@Entity
public class Arduino
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String mac;

    @OneToOne(mappedBy = "arduino")
    private User user;

    private String ip;

    @Override
    public String toString()
    {
        return "Arduino{" +
                "id=" + id +
                ", mac='" + mac + '\'' +
                ", user=" + user +
                ", path='" + ip + '\'' +
                '}';
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getMac()
    {
        return mac;
    }

    public void setMac(String mac)
    {
        this.mac = mac;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public String getIp()
    {
        return ip;
    }

    public void setIp(String ip)
    {
        this.ip = ip;
    }
}
