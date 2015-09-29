/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Heta
 */
// Luokan nimen loppu pitää olla Test
public class LaskinTest {

    // Fixture ("vakiokaluste"): kaikki testit käyttävät samaa laskinta,
    // joka nollataan ennen kutakin testiä.
    private static Laskin laskin = new Laskin();

    @Before
    public void clearCalculator() {
        laskin.nollaa();
    }

    // Testimetodin nimi voi olla mitä tahansa, edessä annotaatio @Test    
    @Test
    public void testLisaa() {
        laskin.lisaa(1);
        laskin.lisaa(1);
        assertEquals("1 + 1 ", 2, laskin.annaTulos(), 0.0001);
    }
    
    @Test
    public void testLisaaDouble() {
        laskin.lisaa(1.5);
        laskin.lisaa(1.3);
        assertEquals("1.5 + 1.3 ", 2.8, laskin.annaTulos(), 0.0001);
    }

    @Test
    public void testVahenna() {
        laskin.lisaa(10);
        laskin.vahenna(2);
        assertEquals("10 - 2 ", 8, laskin.annaTulos(), 0.0001);
    }
    
    @Test
    public void testVahennaDouble() {
        laskin.lisaa(10.5);
        laskin.vahenna(2.1);
        assertEquals("10.5 - 2.1 ", 8.4, laskin.annaTulos(), 0.0001);
    }

    @Test
    public void testJaa() {
        laskin.lisaa(8);
        laskin.jaa(2);
        assertEquals("8 / 2 ", 4, laskin.annaTulos(), 0.0001);
    }
    
    @Test
    public void testJaaDouble() {
        laskin.lisaa(1.5);
        laskin.jaa(0.2);
        assertEquals("1.5 / 0.2 ", 7.5, laskin.annaTulos(), 0.0001);
    }

    // Nollalla jaon pitäisi heittää poikkeus
    @Test(expected = ArithmeticException.class)
    public void testJaaNollalla() {
        laskin.jaa(0);
    }
    
    @Test
    public void testKerro() {
        laskin.lisaa(10);
        laskin.kerro(10);
        assertEquals("10 * 10 ", 100, laskin.annaTulos(), 0.0001);
    }
    
    @Test
    public void testKerroDouble() {
        laskin.lisaa(1.5);
        laskin.kerro(2.5);
        assertEquals("1.5 * 2.5 ", 3.75, laskin.annaTulos(), 0.0001);
    }
}
