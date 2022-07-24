package helloworld;

public class Exe {
	public static void main(String [] args) {
		
		int limit = 1000;
		
		for(int a=1;a<limit;a++) {
			for(int b=1;b<limit;b++) {
				for(int c=1;c<limit;c++) {
					double x = (double)a/(b+c);
					double y = (double)b/(a+c);
					double z = (double)c/(a+b);
					
					double result = x+y+z;
					
					
					
					/*
					 * System.out.println(a); System.out.println(b); System.out.println(c);
					 * System.out.println(result);
					 */
					
					  if(Math.abs(result-4) < 0.000001) {
						  System.out.println(a); 
						  System.out.println(b);
					      System.out.println(c); 
					     }
					 
				}
			}
		}
	}

}
