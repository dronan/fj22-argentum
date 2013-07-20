package br.com.caelum.argentum.reader;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.Test;

import br.com.caelum.argentum.modelo.Negociacao;

public class LeitorXMLTest {

	@Test
	public void carregaXMLComUmaNegociacaoEmListaUnitaria() {

		String xmlDeTeste = "<list>"+
							"	<negociacao>"+
							"		<preco>43.5</preco>"+
							"		<quantidade>1000</quantidade>"+
							"		<data>"+
							"			<time>1322244555666777</time>"+
							"		</data>"+
							"	</negociacao>"+
							"</list>";
		
		LeitorXML leitor = new LeitorXML();
		
		InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());

		List<Negociacao> negociacoes = leitor.carrega(xml);
		
		//System.out.println(negociacoes.size() +" - "+negociacoes.get(0).getPreco());
		
		assertTrue(negociacoes.size() == 1);
		assertEquals(43.5, negociacoes.get(0).getPreco(),0.000001);
		assertEquals(1000, negociacoes.get(0).getQuantidade(),0.000001);
		
	}

}
