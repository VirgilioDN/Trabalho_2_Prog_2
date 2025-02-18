package app;

import java.util.Random;

public final class Dado {
	
	public Dado() {
		
	}
	
	public int D20() {
		Random r = new Random();
        int D20 = r.nextInt(1, 21);
		return D20;
	}
	
	public int D6() {
		Random r = new Random();
        int D6 = r.nextInt(1, 7);
		return D6;
	}
	
	public int D8() {
		Random r = new Random();
        int D8 = r.nextInt(1, 9);
		return D8;
	}
	
	public int D4() {
		Random r = new Random();
        int D8 = r.nextInt(1, 5);
		return D8;
	}
	
	public int D4_IA() {
		Random r = new Random();
        int D8 = r.nextInt(0, 4);
		return D8;
	}
	
}

