package wildpark.model;

public enum Gender {
	MALE, FEMALE;

	public static Gender getRandomGender() {
		if( new java.util.Random().nextBoolean() )
			return Gender.MALE;
		else
			return Gender.FEMALE;
	}
}