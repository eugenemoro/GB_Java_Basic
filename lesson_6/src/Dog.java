public class Dog extends Animal {
	public Dog(String name) {
		super(name);
		setJumpHeight(Math.random()*0.5);
		setRunDistance(Math.random()*200 + 300);
		setSwimDistance(Math.random()*5 + 10);
	}
}
