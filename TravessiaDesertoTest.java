package Testes;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import app.TravessiaDeserto;

public class TravessiaDesertoTest {
	TravessiaDeserto td;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		td = new TravessiaDeserto();
		td.initGame();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInit() {

		assertEquals(td.getPos(), 0);

	}

	/**
	 * Método testAvancar - só pode avançar se o jogo tiver iniciado, tiver
	 * gasolina , se não tiver gasolina nao avanca
	 */
	@Test
	public void testAvancar() {

		assertTrue(td.getFuel() > 0);
		int a = td.getPos();
		int av = td.getFuel();

		td.avancar();
		assertEquals(a + 1, td.getPos());
		assertEquals(av - 1, td.getFuel());

		while (td.getFuel() > 0) {
			td.descarregar();
		}
		a = td.getPos();
		av = td.getFuel();
		td.avancar();
		assertEquals(td.getPos(), a);
		assertEquals(td.getFuel(), av);

	}

	/**
	 * Método testVoltar- só pode voltar se jogo tiver iniciado, não estiver na
	 * posição zero, se tiver combustível
	 */
	@Test
	public void testVoltar() {

		td.avancar();
		td.avancar();
		assertTrue(td.getPos() > 0);
		assertTrue(td.getFuel() > 0);
		int v = td.getPos();
		int vo = td.getFuel();
		td.voltar();
		assertEquals(v - 1, td.getPos());
		assertEquals(vo - 1, td.getFuel());

		while (td.getFuel() > 0) {
			td.descarregar();
		}
		v = td.getPos();
		vo = td.getFuel();
		td.voltar();
		assertEquals(td.getPos(), v);
		assertEquals(td.getFuel(), vo);

	}

	/**
	 * Método testDescarregar- só pode descarregar se o jogo tiver iniciado, se
	 * ele tiver combustível para descarregar.
	 */
	@Test
	public void testDescarregar() {
		int mapPos = td.getMap(td.getPos());
		int fuel = td.getFuel();

		assertTrue(td.getFuel() > 0);
		td.descarregar();
		assertEquals(td.getFuel(), fuel - 1);
		assertEquals(td.getMap(td.getPos()), mapPos + 1);
		td.avancar();
		td.descarregar();
		assertEquals(td.getFuel(), fuel - 3);
		assertEquals(td.getMap(td.getPos()), mapPos + 1);

		td.voltar();
		td.descarregar();
		assertEquals(td.getFuel(), fuel - 1);
		assertEquals(td.getMap(td.getPos()), mapPos + 2);

		while (td.getFuel() > 0) {
			td.descarregar();
		}

		mapPos = td.getMap(td.getPos());
		fuel = td.getFuel();
		td.descarregar();
		assertEquals(td.getFuel(), fuel);
		assertEquals(td.getMap(td.getPos()), mapPos);

	}

	/**
	 * Método testCarregar – só pode carregar se jogo tiver iniciado, Local onde
	 * estiver , deverá ter combustível para carregar.
	 */
	@Test
	public void testCarregar() {
		td.initGame();
		int mapPos = td.getMap(td.getPos());
		int fuel = td.getFuel();

		assert (td.getMap(mapPos) > 0);
		td.avancar();
		td.descarregar();
		td.carregar();
		assertEquals(td.getFuel(), fuel - 1);
		assertEquals(td.getMap(td.getPos()), mapPos);

		while (td.getFuel() > 0) {
			td.descarregar();
		}

		mapPos = td.getMap(td.getPos());
		fuel = td.getFuel();
		td.carregar();
		assertEquals(td.getMap(td.getPos()), mapPos - 1);
		assertEquals(td.getFuel(), fuel + 1);

	}

	/**
	 * Método testGameOver- só termina se o jogo tiver iniciado, se não tiver
	 * combustível.
	 */
	@Test
	public void testGameOver() {
		td.initGame();
		while (td.getPos() >= 0 && td.getFuel() > 0) {
			td.avancar();
		}
		assertEquals(td.isGameOver(), true);
	}

	public void duploAvancar() {
		td.avancar();
		td.avancar();
	}

	public void duploVoltar() {
		td.voltar();
		td.voltar();
	}

	public void duploCarregar() {
		td.carregar();
		td.carregar();
	}

	public void duploDescarregar() {
		td.descarregar();
		td.descarregar();
	}

	@Test
	public void testGanhaJogo() {
		td.initGame();
		duploAvancar();
		duploDescarregar();
		duploVoltar();

		duploAvancar();
		duploDescarregar();
		duploVoltar();

		duploAvancar();
		duploDescarregar();
		duploVoltar();

		duploAvancar();
		duploDescarregar();
		duploVoltar();

		duploAvancar();
		duploCarregar();
		duploAvancar();
		duploDescarregar();
		duploVoltar();
		duploCarregar();
		duploCarregar();
		duploCarregar();
		duploCarregar();
		duploAvancar();
		duploCarregar();
		duploAvancar();
		duploAvancar();
		duploAvancar();
		duploAvancar();

		assertEquals(td.isWinner(), true);
		assertEquals(td.getEndMessage(), "Voce GANHOU!");

	}
}
