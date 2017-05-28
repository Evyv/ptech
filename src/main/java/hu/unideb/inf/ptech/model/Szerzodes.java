package hu.unideb.inf.ptech.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Szerzodes")
public class Szerzodes 
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "szerzodes_sq")
    @SequenceGenerator(name = "szerzodes_sq", sequenceName = "SZERZODES_SEQ", allocationSize = 20)
    @Column(name = "azon", unique = true, nullable = false, precision = 10, scale = 0)
    Integer azon;

   
    @Column(name = "kezdoDatum", nullable = true)
    Timestamp kezdoDatum;

    
    @Column(name = "vegDatum",  nullable = true)
    Timestamp vegDatum;

    
    @Column(name = "ugyfelAzon",  nullable = false, precision = 10, scale = 0)
    Integer ugyfelAzon;

    
    @Column(name = "terulet",  nullable = false, precision = 10, scale = 0)
    Integer terulet;

    
    @Column(name = "ar",  nullable = false, precision = 10, scale = 0)
    Integer ar;

    
    public Szerzodes() 
    {
        super();
    }

    public Szerzodes(Integer azon, Timestamp kezdoDatum, Integer ugyfelAzon,
            Integer szerzodesIdotart, Integer terulet, Integer ar) 
    {
        super();
        kezdoDatum.setNanos(0);

        this.azon = azon;
        this.kezdoDatum = kezdoDatum;
        this.ugyfelAzon = ugyfelAzon;
        this.vegDatum = new Timestamp(kezdoDatum.getTime());
        vegDatum.setYear(vegDatum.getYear() + szerzodesIdotart);
        this.terulet = terulet;
        this.ar = ar;

    }
    
    
    public Szerzodes(Timestamp kezdoDatum, Integer ugyfelAzon,
            Integer szerzodesIdotart, Integer terulet, Integer ar) 
    {
        super();
        kezdoDatum.setNanos(0);
        this.kezdoDatum = kezdoDatum;
        this.ugyfelAzon = ugyfelAzon;
        this.vegDatum = new Timestamp(kezdoDatum.getTime());
        vegDatum.setYear(vegDatum.getYear() + szerzodesIdotart);
        this.terulet = terulet;
        this.ar = ar;

    }

    
    public Integer getAzon() 
    {
        return azon;
    }

    
    public void setAzon(Integer azon) 
    {
        this.azon = azon;
    }

    
    public Timestamp getKezdoDatum() 
    {
        return kezdoDatum;
    }

    public void setKezdoDatum(Timestamp kezdoDatum) 
    {
        this.kezdoDatum = kezdoDatum;
    }

    
    public Timestamp getVegDatum() 
    {
        return vegDatum;
    }

    
    public void setVegDatum(Timestamp vegDatum) 
    {
        this.vegDatum = vegDatum;
    }

    
    public Integer getUgyfelAzon() 
    {
        return ugyfelAzon;
    }

    
    public void setUgyfelAzon(Integer ugyfelAzon) 
    {
        this.ugyfelAzon = ugyfelAzon;
    }


    public Integer getTerulet() 
    {
        return terulet;
    }

   
    public void setTerulet(Integer terulet) 
    {
        this.terulet = terulet;
    }

    
    public Integer getAr() 
    {
        return ar;
    }

    
    public void setAr(Integer ar) 
    {
        this.ar = ar;
    }

    @Override
    public String toString() 
    {
        return "Szerzodes{" + "azon=" + azon + ", kezdoDatum=" + kezdoDatum + ", vegDatum=" + vegDatum + ", ugyfelAzon=" + ugyfelAzon + ", terulet=" + terulet + ", ar=" + ar + '}';
    }
}
