package hu.unideb.inf.ptech.controller;

import hu.unideb.inf.ptech.model.Ugyfel;

public class Kalkulator 
{
	
    public Kalkulator() 
    {
	
    }

    public int arSzamitas(Ugyfel ugyfel, double terulet, Integer ev) 
    {
        Double osszeg = 0.0;
        if (ugyfel.getAzon() != null) 
        {
            if (ugyfel.getMegkereses() == 0) 
            {
                osszeg = (int) 150 * terulet;
            } 
            else  
            {
                if (ugyfel.getMegkereses() < 10) 
                {
                    osszeg = terulet * 150 * 0.9;
                }
                else if (ugyfel.getMegkereses() >= 10) 
                {
                    osszeg = 150 * terulet * 0.8;
                }
            }
        }
           
        if (ev == 2) 
        {
            osszeg = osszeg * 0.9;
        } 
        else if (ev == 3) 
        {
            osszeg = osszeg * 0.8;
        }
       return osszeg.intValue();
    }
}
