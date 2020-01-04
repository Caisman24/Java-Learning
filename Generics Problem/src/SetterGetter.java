public class SetterGetter<T extends Human> {

	String getName(T object) {
		return object.name;
	}

	int getAge(T object) {
		return object.age;
	}

	void setName(T object, String nameTemp) {
		object.name = nameTemp;
	}

	void setAge(T object, int ageTemp) {
		object.age = ageTemp;
	}
	
}