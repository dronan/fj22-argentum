package br.com.caelum.argentum.modelo;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static junit.framework.Assert.*;

import org.junit.Test;

public class NegociacaoTest {

	@Test
	public void dataDaNegociacaoEhImutavel() {

		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 15);

		Negociacao n = new Negociacao(10, 5, c);

		n.getData().set(Calendar.DAY_OF_MONTH, 20);

		assertEquals(15, n.getData().get(Calendar.DAY_OF_MONTH));
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoCriaNegociacaoComDataNula() {
		new Negociacao(10, 5, null);
	}

	@Test
	public void mesmoMilisegundoEhDoMesmoDia() {
		Calendar agora = Calendar.getInstance();
		Calendar mesmoMomento = (Calendar) agora.clone();

		Negociacao negociacao = new Negociacao(40.0, 100, agora);

		assertTrue(negociacao.isMesmoDia(mesmoMomento));
	}

	@Test
	public void comHorariosDiferentesEhNoMesmoDia() {
		Calendar manha = new GregorianCalendar(2011, 10, 20, 8, 30);
		Calendar tarde = new GregorianCalendar(2011, 10, 20, 15, 30);
		
		Negociacao negociacao = new Negociacao(40.0, 100, manha);
		
		assertTrue(negociacao.isMesmoDia(tarde));
	}

	@Test
	public void mesmoDiaMasMesesDiferentesNaoSaoDoMesmoDia(){
		Calendar mesNove = new GregorianCalendar(2011, 9, 20);
		Calendar mesDez = new GregorianCalendar(2011, 10, 20);
		
		Negociacao negociacao = new Negociacao(40.0, 100, mesNove);
		
		assertFalse(negociacao.isMesmoDia(mesDez));		
	}
	
	@Test
	public void mesmoDiaMasAnosDiferentesNaoSaoDoMesmoDia(){
		Calendar doisMilEDez = new GregorianCalendar(2010, 10, 20);
		Calendar doisMilEOnze = new GregorianCalendar(2011, 10, 20);
		
		Negociacao negociacao = new Negociacao(40.0, 100, doisMilEOnze);
		
		assertFalse(negociacao.isMesmoDia(doisMilEDez));		
	}
	
}
