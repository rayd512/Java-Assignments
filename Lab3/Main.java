public class Main {
	public static void main(String[] args) {
		// HwEngineer harold = new HwEngineer("harold", 3000);
		Customer carson = new Customer("Carson", 1000);
		ProjManager pat = new ProjManager("Pat", 6000.00, null, null);
		System.out.println(carson.PrintInfo());
		System.out.println(pat.PrintInfo());
	} 
}