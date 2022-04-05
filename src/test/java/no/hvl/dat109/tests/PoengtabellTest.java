package test.java.no.hvl.dat109.tests;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import no.hvl.dat109.app.*;

public class PoengtabellTest {
	private Terning[] terninger = new Terning[5];
	
	@BeforeEach
	public Terning[] lagTerninger() {
		Terning[] terninger = new Terning[5];
		for(int i = 0; i < 5; i++) {
			Terning terning = new Terning();
			terning.roll();
			terninger[i] = terning;
		}
		return terninger;
	}
	
	@Test
	public void testEnere() {
		Terning[] terninger = lagTerninger();
		int score = Poengtabell.poeng(1, terninger);
		assertTrue(score >= 0 && score <= 5);
	}
	
	@Test
	public void testToere() {
		Terning[] terninger = lagTerninger();
		int score = Poengtabell.poeng(2, terninger);
		assertTrue(score >= 0 && score <= 10);
	}
	
	@Test
	public void testTreere() {
		Terning[] terninger = lagTerninger();
		int score = Poengtabell.poeng(3, terninger);
		assertTrue(score >= 0 && score <= 15);
	}
	
	@Test
	public void testFirere() {
		Terning[] terninger = lagTerninger();
		int score = Poengtabell.poeng(4, terninger);
		assertTrue(score >= 0 && score <= 20);
	}
	
	@Test
	public void testFemere() {
		Terning[] terninger = lagTerninger();
		int score = Poengtabell.poeng(5, terninger);
		assertTrue(score >= 0 && score <= 25);
	}
	
	@Test
	public void testSeksere() {
		Terning[] terninger = lagTerninger();
		int score = Poengtabell.poeng(6, terninger);
		assertTrue(score >= 0 && score <= 30);
	}
	
	@Test
	public void testEttPar() {
		Terning[] terninger = lagTerninger();
		int score = Poengtabell.poeng(7, terninger);
		assertTrue(score >= 0 && score <= 12);
	}
	
	@Test
	public void testToPar() {
		Terning[] terninger = lagTerninger();
		int score = Poengtabell.poeng(8, terninger);
		assertTrue(score >= 0 && score <= 24);
	}
	
	@Test
	public void testTreLike() {
		Terning[] terninger = lagTerninger();
		int score = Poengtabell.poeng(9, terninger);
		assertTrue(score >= 0 && score <= 18);
	}
	
	@Test
	public void testFireLike() {
		Terning[] terninger = lagTerninger();
		int score = Poengtabell.poeng(10, terninger);
		assertTrue(score >= 0 && score <= 10);
	}
	
	@Test
	public void testHus() {
		Terning[] terninger = lagTerninger();
		int score = Poengtabell.poeng(11, terninger);
		assertTrue(score >= 0 && score <= 28);
	}
	
	@Test
	public void testLitenStraight() {
		Terning[] terninger = lagTerninger();
		int score = Poengtabell.poeng(12, terninger);
		assertTrue(score == 0 || score == 15);
	}
	
	@Test
	public void testStorStraight() {
		Terning[] terninger = lagTerninger();
		int score = Poengtabell.poeng(13, terninger);
		assertTrue(score == 0 || score == 20);
	}
	
	@Test
	public void testYatzy() {
		Terning[] terninger = lagTerninger();
		int score = Poengtabell.poeng(14, terninger);
		assertTrue(score == 0 || score == 50);
	}
	
	@Test
	public void testSjanse() {
		Terning[] terninger = lagTerninger();
		int score = Poengtabell.poeng(15, terninger);
		assertTrue(score >= 0 && score <= 30);
	}
}