package main.java.no.hvl.dat109.app;

//TODO javadoc
public class Terning {

	public final int MAX = 6;

	public int faceValue;

	public Terning() {
		this.faceValue = 0;
	}

	public int roll() {
		faceValue = (int) (Math.random() * MAX) + 1;

		return faceValue;
	}

	public int getFaceValue() {
		return faceValue;
	}

	public String toString() {
		String result = Integer.toString(faceValue);
		return result;
	}

}
