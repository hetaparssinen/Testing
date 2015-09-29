package laskin;

public class Laskin {

    private static double tulos;  // Muuttuja tulokselle
    
    public void nollaa() {     // Nollaa tuloksen
        tulos = 0;
    }

    public double annaTulos() {
        return tulos;
    }
    
    public void lisaa(double n) {
        tulos = tulos + n;
    }

    public void vahenna(double n) {
        tulos = tulos - n;     
    }

    public void kerro(double n) {
        tulos = tulos * n;
    }

    public void jaa(double n) {
        if ( n == 0 ) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        tulos = tulos / n;
    }

    public void nelio(double n) {
        tulos = n * n;
    }

    public void neliojuuri(double n) {
        if ( n < 0 ) {
            throw new IllegalArgumentException("Cannot be negative.");
        }
        tulos = Math.sqrt(n);
    }
    
    public void virtaON() {
        tulos = 0;
    }

    public void virtaOFF() {
        tulos = 0;
    }

}
