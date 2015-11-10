public class TiliTesti   
{
      public static void main(String args[])
	{
	    KorkoTili munTili = new KorkoTili( );

	    munTili.talleta(1250.00);

	    System.out.println ("Nyt saldo " +
		  munTili.getSaldo( ) );

	    munTili.nosta(250.00);

	    System.out.println ("Nyt saldo " +
		  munTili.getSaldo( ) );

	    munTili.kirjaaKorko( );
	    System.out.println ("tilille tulee korko");

	    System.out.println ("Nyt saldo " +
		  munTili.getSaldo( ) );
	}
}

