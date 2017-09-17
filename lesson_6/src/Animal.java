public abstract class Animal {
	private String name;
	private double jumpHeight;
	private double runDistance;
	private double swimDistance;

	public Animal (String name){
		setName(name);
	}

	public boolean run (double distance) {
		return ((distance <= runDistance) ? true : false);
	}

	public boolean swim (double distance) {
		return ((distance <= swimDistance) ? true : false);
	}

	public boolean jump (double height) {
		return ((height <= jumpHeight) ? true : false);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getJumpHeight() {
		return jumpHeight;
	}

	public void setJumpHeight(double jumpHeight) {
		this.jumpHeight = jumpHeight;
	}

	public double getRunDistance() {
		return runDistance;
	}

	public void setRunDistance(double runDistance) {
		this.runDistance = runDistance;
	}

	public double getSwimDistance() {
		return swimDistance;
	}

	public void setSwimDistance(double swimDistance) {
		this.swimDistance = swimDistance;
	}
}
