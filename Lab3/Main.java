/**
 * Lab 3: Inheritance, Interfaces, Hash, Design Pattern and Big Number <br />
 * The {@code Main} interface
 */
import java.text.SimpleDateFormat;  
import java.util.Date;
import java.text.ParseException;
public class Main {
	public static void main(String[] args) throws ParseException{
		// Tests
		String stringDate = "07-05-2020";
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
		Date date = formatter.parse(stringDate);
		// Date date = new SimpleDateFormat("dd/MM/yyyy").parse("05/08/2020");
		HwEngineer harold = new HwEngineer("harold", 3000);
		ProjManager pat = new ProjManager("Pat", 6000.00, "New Floor", date);
		Customer carson = new Customer("Carson", 1000);

		System.out.println("Harold " + harold.RaiseSalary());
		System.out.println("Pat " + pat.RaiseSalary());
		System.out.println(carson.PrintInfo());
		System.out.println(pat.PrintInfo());
	} 
}