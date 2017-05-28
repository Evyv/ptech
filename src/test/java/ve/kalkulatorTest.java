package ve;

import static org.junit.Assert.*;


import hu.unideb.inf.ptech.model.Szerzodes;
import hu.unideb.inf.ptech.model.Ugyfel;

import org.junit.Test;

import hu.unideb.inf.ptech.controller.Kalkulator;

public class kalkulatorTest {

	Kalkulator kalkulator;
	Ugyfel ugyfel;
	Szerzodes szerzodes;
	
        @Test
        public void arszamitasTestRegiUgyfelVoltMegkeresesKevesebbMint10() 
        {
            kalkulator = new Kalkulator();
            
            //1év 1 megkeresesés
            ugyfel = new Ugyfel(1, "Béla", "Kerekerdő közepe", "123456789", "bela@kerekedo.hu", 1, 0);
            assertTrue(1350 == kalkulator.arSzamitas(ugyfel, 10, 1));
            
            //1év 6 megkeresesés
            ugyfel = new Ugyfel(1, "Béla", "Kerekerdő közepe", "123456789", "bela@kerekedo.hu", 6, 0);            
            assertTrue(1350 == kalkulator.arSzamitas(ugyfel, 10, 1));
            //1év 9 megkeresesés
            ugyfel = new Ugyfel(1, "Béla", "Kerekerdő közepe", "123456789", "bela@kerekedo.hu", 9, 0);            
            assertTrue(1350 == kalkulator.arSzamitas(ugyfel, 10, 1));
            
            //2év 1 megkeresesés
            ugyfel = new Ugyfel(1, "Béla", "Kerekerdő közepe", "123456789", "bela@kerekedo.hu", 1, 0);            
            assertTrue(1215 == kalkulator.arSzamitas(ugyfel, 10, 2));
            
            //2év 6 megkeresesés
            ugyfel = new Ugyfel(1, "Béla", "Kerekerdő közepe", "123456789", "bela@kerekedo.hu", 6, 0);            
            assertTrue(1215 == kalkulator.arSzamitas(ugyfel, 10, 2));
            
            //2év 9 megkeresesés
            ugyfel = new Ugyfel(1, "Béla", "Kerekerdő közepe", "123456789", "bela@kerekedo.hu", 9, 0);            
            assertTrue(1215 == kalkulator.arSzamitas(ugyfel, 10, 2));
            
            //3év 1 megkeresesés
            ugyfel = new Ugyfel(1, "Béla", "Kerekerdő közepe", "123456789", "bela@kerekedo.hu", 1, 0);            
            assertTrue(1080 == kalkulator.arSzamitas(ugyfel, 10, 3));

            //3év 6 megkeresesés
            ugyfel = new Ugyfel(1, "Béla", "Kerekerdő közepe", "123456789", "bela@kerekedo.hu", 6, 0);            
            assertTrue(1080 == kalkulator.arSzamitas(ugyfel, 10, 3));
            
            //3év 9 megkeresesés
            ugyfel = new Ugyfel(1, "Béla", "Kerekerdő közepe", "123456789", "bela@kerekedo.hu", 9, 0);            
            assertTrue(1080 == kalkulator.arSzamitas(ugyfel, 10, 3));
        }
	@Test
        public void arszamitasTestRegiUgyfelVoltMegkeresesTobbMint9() {
            kalkulator = new Kalkulator();
            
            //1év 1 megkeresesés
            ugyfel = new Ugyfel(1, "Béla", "Kerekerdő közepe", "123456789", "bela@kerekedo.hu", 10, 0);
            assertTrue(1200 == kalkulator.arSzamitas(ugyfel, 10, 1));
            
            //1év 6 megkeresesés
            ugyfel = new Ugyfel(1, "Béla", "Kerekerdő közepe", "123456789", "bela@kerekedo.hu", 20, 0);            
            assertTrue(1200 == kalkulator.arSzamitas(ugyfel, 10, 1));
            //1év 9 megkeresesés
            ugyfel = new Ugyfel(1, "Béla", "Kerekerdő közepe", "123456789", "bela@kerekedo.hu", 29, 0);            
            assertTrue(1200 == kalkulator.arSzamitas(ugyfel, 10, 1));
            
            //2év 1 megkeresesés
            ugyfel = new Ugyfel(1, "Béla", "Kerekerdő közepe", "123456789", "bela@kerekedo.hu", 10, 0);            
            assertTrue(1080 == kalkulator.arSzamitas(ugyfel, 10, 2));
            
            //2év 6 megkeresesés
            ugyfel = new Ugyfel(1, "Béla", "Kerekerdő közepe", "123456789", "bela@kerekedo.hu", 20, 0);            
            assertTrue(1080 == kalkulator.arSzamitas(ugyfel, 10, 2));
            
            //2év 9 megkeresesés
            ugyfel = new Ugyfel(1, "Béla", "Kerekerdő közepe", "123456789", "bela@kerekedo.hu", 29, 0);            
            assertTrue(1080 == kalkulator.arSzamitas(ugyfel, 10, 2));
            
            //3év 1 megkeresesés
            ugyfel = new Ugyfel(1, "Béla", "Kerekerdő közepe", "123456789", "bela@kerekedo.hu", 10, 0);            
            assertTrue(960 == kalkulator.arSzamitas(ugyfel, 10, 3));

            //3év 6 megkeresesés
            ugyfel = new Ugyfel(1, "Béla", "Kerekerdő közepe", "123456789", "bela@kerekedo.hu", 20, 0);            
            assertTrue(960 == kalkulator.arSzamitas(ugyfel, 10, 3));
            
            //3év 9 megkeresesés
            ugyfel = new Ugyfel(1, "Béla", "Kerekerdő közepe", "123456789", "bela@kerekedo.hu", 29, 0);            
            assertTrue(960 == kalkulator.arSzamitas(ugyfel, 10, 3));
        }
        
        @Test
	public void arszamitasTestUjUgyfel() {
		kalkulator = new Kalkulator();
		ugyfel = new Ugyfel (1,"Béla","Kerekerdő közepe","123456789","bela@kerekedo.hu",0,0);
    		// 1év
                assertTrue(1500 == kalkulator.arSzamitas(ugyfel, 10, 1));
		//2év
		assertTrue(1350 == kalkulator.arSzamitas(ugyfel, 10, 2));
		//3év
		assertTrue(1200 == kalkulator.arSzamitas(ugyfel, 10, 3));
		
	}
}
