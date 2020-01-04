import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Set<Child> kids = addKid();
		show(kids);

		Set<Adult> adults = addAdults();
		show(adults);

		Set<Retired> retired = addRetired();
		show(retired);
	}

	private static Set<Child> addKid() {
		try {
			System.out.print("Enter the number of kids: ");
			int number = scanner.nextInt();
			if (number == 0) {
				return null;
			}

			SetterGetter object = new SetterGetter();
			Set<Child> kids = new HashSet<>();

			System.out.println("Enter name and age: ");
			String name;
			int age;
			for (int i = 0; i < number; i++) {
				System.out.print("\nKid[" + (i + 1) + "]\nName: ");
				name = scanner.next();
				System.out.print("Age: ");
				age = scanner.nextInt();

				Child aux = new Child();
				object.setAge(aux, age);
				object.setName(aux, name);
				kids.add(aux);
			}
			return kids;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static Set<Adult> addAdults() {
		try {
			System.out.print("\nEnter the number of adults: ");
			int number = scanner.nextInt();
			if (number == 0) {
				return null;
			}

			SetterGetter object = new SetterGetter();
			Set<Adult> adults = new HashSet<>();

			System.out.println("Enter name and age: ");
			String name;
			int age;
			for (int i = 0; i < number; i++) {
				System.out.print("\nAdult[" + (i + 1) + "]\nName: ");
				name = scanner.next();
				System.out.print("Age: ");
				age = scanner.nextInt();

				Adult aux = new Adult();
				object.setAge(aux, age);
				object.setName(aux, name);
				adults.add(aux);
			}
			return adults;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static Set<Retired> addRetired() {
		try {
			System.out.print("\nEnter the number of retirees: ");
			int number = scanner.nextInt();
			if (number == 0) {
				return null;
			}

			SetterGetter object = new SetterGetter();
			Set<Retired> retired = new HashSet<>();

			System.out.println("Enter name and age: ");
			String name;
			int age;
			for (int i = 0; i < number; i++) {
				System.out.print("\nRetired[" + (i + 1) + "]\nName: ");
				name = scanner.next();
				System.out.print("Age: ");
				age = scanner.nextInt();

				Retired aux = new Retired();
				object.setAge(aux, age);
				object.setName(aux, name);
				retired.add(aux);
			}
			return retired;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static void show(Set<? extends Human> set) {
		
		if (set instanceof Child) System.out.println("Kids that are in database:"); //hashset
		else if (set instanceof Adult) System.out.println("Adults that are in database:");
		else if (set instanceof Retired) System.out.println("Retirees that are in database:");

		try {
			if (set.size() == 0)
				throw new Exception("This is null");
			SetterGetter object = new SetterGetter();

			for (Human instanceOfSet : set) {
				System.out.println("\nName: " + object.getName(instanceOfSet));
				System.out.println("Age: " + object.getAge(instanceOfSet));
			}

		} catch (Exception ex) {
			System.out.println("\nSomething went wrong!");
		}
	}

}
