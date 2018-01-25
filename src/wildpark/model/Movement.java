package wildpark.model;

public class Movement {
	byte direction;    // 0-359deg
	float speed;	   // km/h
	int energyUsed; // W

	public Movement( float speed ) {
		this.speed = speed;
		direction = (byte) new java.util.Random().nextInt(360);
	}
}
