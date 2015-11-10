 public class Tili      
{
        protected double saldo ;

        public Tili( double alkusaldo )
	    { saldo = alkusaldo ; }

        public Tili( )
	    { saldo = 0.0 ; }

        public void talleta( double eurot )
	    { saldo += eurot ; }

        public double nosta( double eurot )
	  {
	     if (saldo >= eurot)
		  { saldo -= eurot; return saldo; }
	     else                 return 0.0;
	  }

        public double getSaldo()
	    { return saldo ; }
}  
