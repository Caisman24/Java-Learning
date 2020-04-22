import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter your id number: ");
		String cnp = scanner.next();
		PersonalNumeric object = new PersonalNumeric(cnp);
		object.isValid();
	}

}
