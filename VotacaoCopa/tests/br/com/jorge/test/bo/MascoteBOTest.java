package br.com.jorge.test.bo;


import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.jorge.bo.MascoteBo;
import br.com.jorge.dao.MascoteDao;
import br.com.jorge.entity.Mascote;
import br.com.jorge.to.MascoteTO;

@RunWith( MockitoJUnitRunner.class)
public class MascoteBOTest extends TestCase {
	
	@Mock
	private MascoteDao mascoteDao;
	@InjectMocks
	private MascoteBo mascoteBo;
	
	/**
	 * Simples test que valida o methodo findAll e a regra de porcentagem.
	 */
	@Test
	public void findAllAndPorcentagemTest() {
		List<Mascote> mascotes = new ArrayList<Mascote>();
		final Mascote mascote1 = new Mascote();
		mascote1.setId(1L);
		mascote1.setVotos(2L);
		final Mascote mascote2 = new Mascote();
		mascote2.setId(2L);
		mascote2.setVotos(8L);
		
		mascotes.add(mascote1);
		mascotes.add(mascote2);
		
		when(mascoteDao.findAll()).thenReturn(mascotes);
		final List<MascoteTO> listaFinal = mascoteBo.listaTudo();
		assertEquals(new Long(20L), listaFinal.get(0).getPercVotos());
		assertEquals(new Long(80L), listaFinal.get(1).getPercVotos());
		
	}

}
