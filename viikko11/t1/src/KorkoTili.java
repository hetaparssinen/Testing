public class KorkoTili extends Tili  
{
      private static double peruskorko = 1.99 ;
      private double korkoPros ;

     public KorkoTili( double alkusaldo, double alkukorko)
	{
	    saldo = alkusaldo ;
	    korkoPros = alkukorko ;
	}

      public KorkoTili( double alkusaldo )
	{
	    saldo = alkusaldo;
	    korkoPros = peruskorko ;
	}

      public KorkoTili( )
	{
	    saldo = 0.0;
	    korkoPros = peruskorko ;
	}
	
      public void kirjaaKorko( )
	{
	    saldo += (saldo * korkoPros / 100) ;
	}
}
