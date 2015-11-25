/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

/**
 *
 * @author Heta
 */
public class TilaustenKäsittely {
    private Hinnoittelija hinnoittelija;

    public void setHinnoittelija(Hinnoittelija hinnoittelija) {
        this.hinnoittelija = hinnoittelija;
    }
    
    public void käsittele(Tilaus tilaus) {
        Asiakas asiakas = tilaus.getAsiakas();
        Tuote tuote = tilaus.getTuote();
        
        hinnoittelija.aloita();
        float prosentti = hinnoittelija.getAlennusProsentti(asiakas, tuote);
        if (tuote.getHinta() >= 100) {
            hinnoittelija.setAlennusProsentti(asiakas, prosentti + 5);
        }

        prosentti = hinnoittelija.getAlennusProsentti(asiakas, tuote);
        float alennusHinta = tuote.getHinta() * (1 - (prosentti / 100));
        asiakas.setSaldo(asiakas.getSaldo() - alennusHinta);
        hinnoittelija.lopeta();
    }
}
