package test.java.no.hvl.dat109.tests;
import static org.junit.Assert.*;

import org.junit.jupiter.api.RepeatedTest;

import no.hvl.dat109.app.*;

public class TerningTest {
	
	@RepeatedTest(value = 50)
	public void testRoll() {
			Terning terning = new Terning();
			int nr = terning.roll();
			assertTrue(nr >= 1 && nr <= 6);
	}
}