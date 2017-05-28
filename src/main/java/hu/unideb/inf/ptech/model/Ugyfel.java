package hu.unideb.inf.ptech.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name = "Ugyfel")
public class Ugyfel 
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="ugyfel_sq")
    @SequenceGenerator(name = "ugyfel_sq",sequenceName = "UGYFEL_SEQ",allocationSize = 20)
    @Column(name = "azon", unique = true, nullable = false, precision = 10, scale = 0)
    Integer azon;

    @Column(name = "nev", nullable = false, length = 255)
    String nev;

    
    @Column(name = "lakcim", nullable = true, length = 255)
    String lakcim;

   
    @Column(name = "telefonszam", nullable = true, length = 255)
    String telefonszam;

   
    @Column(name = "email", nullable = true, length = 255)
    String email;

    
    @Column(name = "megkereses", nullable = true, precision = 10, scale = 0)
    Integer megkereses;

    
    
    @Column(name = "SZAZON", nullable = true, precision = 10, scale = 0)
    Integer szazon;

    
    public Ugyfel() 
    {
        super();
    }

    public Ugyfel(Integer azon, String nev, String lakcim, String telefonszam,
            String email, Integer megkereses, Integer szerzodes) 
    {
        super();
        this.azon = azon;
        this.nev = nev;
        this.lakcim = lakcim;
        this.telefonszam = telefonszam;
        this.email = email;
        this.megkereses = megkereses;
        this.szazon = szerzodes;
    }

    public Integer getAzon() 
    {
        return azon;
    }

    
    public void setAzon(Integer azon) 
    {
        this.azon = azon;
    }

   
    public String getNev() 
    {
        return nev;
    }

   
    public void setNev(String nev) 
    {
        this.nev = nev;
    }

    
    public String getLakcim() 
    {
        return lakcim;
    }
    
    public void setLakcim(String lakcim) 
    {
        this.lakcim = lakcim;
    }

    public String getTelefonszam() 
    {
        return telefonszam;
    }

    public void setTelefonszam(String telefonszam) 
    {
        this.telefonszam = telefonszam;
    }

    
    public String getEmail() 
    {
        return email;
    }

    
    public void setEmail(String email) 
    {
        this.email = email;
    }

    
    public Integer getMegkereses() 
    {
        return megkereses;
    }

   
    public void setMegkereses(Integer megkereses)
    {
        this.megkereses = megkereses;
    }

    public Integer getSzazon() 
    {
        return szazon;
    }

    public void setSzazon(Integer szerzodes) 
    {
        this.szazon = szerzodes;
    }

@Override
    public String toString() 
    {
        return "Ugyfel{" + "azon=" + azon + ", nev=" + nev + ", lakcim=" + lakcim + ", telefonszam=" + telefonszam + ", email=" + email + ", megkereses=" + megkereses + ", szazon=" + szazon + '}';
    }
}
