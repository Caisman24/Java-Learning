import java.time.LocalDate;
import java.time.Period;

public class PersonalNumeric {
	private String cnp;

	public PersonalNumeric() {
		this.cnp = "default";
	}

	public PersonalNumeric(String cnp) {
		this.cnp = cnp;
	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public Boolean isValid() {

		if (cnp.length() == 13) {

			int sex = (int) cnp.charAt(0);
			int yearOfBirth = (cnp.charAt(1) - '0') * 10 + (cnp.charAt(2) - '0');
			// int monthOfBirth = (cnp.charAt(3) - '0') * 10 + (cnp.charAt(4) - '0');
			// int dayOfBirth = (cnp.charAt(5) - '0') * 10 + (cnp.charAt(6) - '0');
			int townCode = (cnp.charAt(7) - '0') * 10 + (cnp.charAt(8) - '0');

			if (sex == 3 || sex == 4 || sex == 0 || sex == 9) {
				return false;
			} else {
				if ((sex == 5 && yearOfBirth > 20) || (sex == 6 && yearOfBirth > 20)) {
					return false;
				} else {
					if (cnp.charAt(3) - '0' > 1 || (cnp.charAt(3) - '0' == 0 && cnp.charAt(4) - '0' == 0)
							|| cnp.charAt(3) == 1 && cnp.charAt(4) > 2) {
						return false;
					} else {
						if (dayValidate()) {
							if ((townCode > 0 && townCode < 47) || (townCode > 50 && townCode < 53)) {
								if (figureControl()) {
									System.out.println("\nYour id card is valid!");
									showInfo();
									return true;
								} else
									System.out.println("Wrong number");
							}
						}
					}
				}
			}
		}
		System.out.println("Your id card is not valid!");
		return false;
	}

	public Boolean figureControl() {
		long result = 0;
		final String standardNumber = "279146358279";

		for (int i = 0; i < 12; i++) {
			result += (cnp.charAt(i) - '0') * (standardNumber.charAt(i) - '0');
		}

		result %= 11;
		if (result == 10)
			result = 1;

		if (result == (cnp.charAt(12) - '0')) {
			return true;
		} else
			return false;
	}

	public Boolean leapYear() {
		int year;
		boolean leap = false;
		if (cnp.charAt(0) - '0' == 2 || cnp.charAt(0) - '0' == 1) {
			year = 1900 + (cnp.charAt(1) - '0') * 100 + cnp.charAt(2) - '0';
		} else {
			year = 2000 + (cnp.charAt(1) - '0') * 100 + cnp.charAt(2) - '0';
		}

		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0)
					leap = true;
				else
					leap = false;
			} else
				leap = true;
		} else
			leap = false;

		return leap;
	}

	public Boolean dayValidate() {
		int month = (cnp.charAt(3) - '0') * 10 + (cnp.charAt(4) - '0');
		boolean valide = false;
		switch (month) {
		case 1: { // january
			if (cnp.charAt(5) > 3 || (cnp.charAt(5) == 3 && cnp.charAt(6) > 1)) {
				valide = false;
			} else
				valide = true;
		}
		case 2: {
			if (cnp.charAt(5) > 2 || (cnp.charAt(5) == 2 && cnp.charAt(6) > 8)
					|| (cnp.charAt(5) == 2 && cnp.charAt(6) > 9 && leapYear())) {
				valide = false;
			} else
				valide = true;
		}
		case 3: {
			if (cnp.charAt(5) > 3 || (cnp.charAt(5) == 3 && cnp.charAt(6) > 1)) {
				valide = false;
			} else
				valide = true;
			return true;
		}
		case 4: {
			if (cnp.charAt(5) > 3 || (cnp.charAt(5) == 3 && cnp.charAt(6) > 0)) {
				valide = false;
			} else
				valide = true;
		}
		case 5: {
			if (cnp.charAt(5) > 3 || (cnp.charAt(5) == 3 && cnp.charAt(6) > 1)) {
				valide = false;
			} else
				valide = true;
		}
		case 6: { // june
			if (cnp.charAt(5) > 3 || (cnp.charAt(5) == 3 && cnp.charAt(6) > 0)) {
				valide = false;
			} else
				valide = true;
		}
		case 7: { // july
			if (cnp.charAt(5) > 3 || (cnp.charAt(5) == 3 && cnp.charAt(6) > 1)) {
				valide = false;
			} else
				valide = true;
		}
		case 8: {
			if (cnp.charAt(5) > 3 || (cnp.charAt(5) == 3 && cnp.charAt(6) > 1)) {
				valide = false;
			} else
				valide = true;
		}
		case 9: {
			if (cnp.charAt(5) > 3 || (cnp.charAt(5) == 3 && cnp.charAt(6) > 0)) {
				valide = false;
			} else
				valide = true;
		}
		case 10: {
			if (cnp.charAt(5) > 3 || (cnp.charAt(5) == 3 && cnp.charAt(6) > 1)) {
				valide = false;
			} else
				valide = true;
		}
		case 11: {
			if (cnp.charAt(5) > 3 || (cnp.charAt(5) == 3 && cnp.charAt(6) > 0)) {
				valide = false;
			} else
				valide = true;
		}
		case 12: {
			if (cnp.charAt(5) > 3 || (cnp.charAt(5) == 3 && cnp.charAt(6) > 1)) {
				valide = false;
			} else
				valide = true;
		}
		default:
			System.out.println("Wrong number for month!");
		}
		return valide;
	}

	public void showInfo() {
		if (cnp.charAt(0) == '1' || cnp.charAt(0) == '5' || cnp.charAt(0) == '7') {
			System.out.println("Sex: Male");
		} else
			System.out.println("Sex: Female");

		int monthOfBirth = (cnp.charAt(3) - '0') * 10 + (cnp.charAt(4) - '0');
		int dayOfBirth = (cnp.charAt(5) - '0') * 10 + (cnp.charAt(6) - '0');
		int yearOfBirth;
		if (cnp.charAt(0) == '1' || cnp.charAt(0) == '2') {
			yearOfBirth = 1900 + (cnp.charAt(1) - '0') * 10 + (cnp.charAt(2) - '0');
			System.out.println("Your date of birth is: " + dayOfBirth + "." + monthOfBirth + "." + yearOfBirth);
		} else {
			yearOfBirth = 2000 + (cnp.charAt(1) - '0') * 10 + (cnp.charAt(2) - '0');
			System.out.println("Your date of birth is: " + dayOfBirth + "." + monthOfBirth + "." + yearOfBirth);
		}

		LocalDate now = LocalDate.now();
		LocalDate birthday = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
		Period period = Period.between(birthday, now);
		System.out.println("Your age is: " + period.getYears());

		int townCode = (cnp.charAt(7) - '0') * 10 + (cnp.charAt(8) - '0');
		Towns towns = Towns.values()[townCode - 1];
		System.out.println("You're from: " + towns);
	}
}
