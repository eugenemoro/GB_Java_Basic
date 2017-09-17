public class Cat extends Animal {
	public Cat(String name) {
		super(name);
		setJumpHeight(Math.random() + 1);
		setRunDistance(Math.random()*100 + 100);
		setSwimDistance(0);
	}

	@Override
	public boolean swim(double distance) {
		return false;
	}
}
