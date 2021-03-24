package no.hvl.dat107;


public class Main {

	
	public static void main(String[] args) {
		AnsattDAO bedrift = new AnsattDAO();
		
//		BrukerGrenseSnitt meny = new BrukerGrenseSnitt();
//		meny.grenseSnitt();
		
		System.out.println(bedrift.finnAnsatt(2));
		
	}
	
}
