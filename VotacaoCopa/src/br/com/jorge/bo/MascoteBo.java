package br.com.jorge.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import br.com.caelum.vraptor.ioc.Component;
import br.com.jorge.dao.MascoteDao;
import br.com.jorge.entity.Mascote;
import br.com.jorge.exceptions.BussinessException;
import br.com.jorge.to.MascoteTO;


@Component
public class MascoteBo{
	
	private MascoteDao mascoteDao;
	
	
	public MascoteBo(MascoteDao dao) {
		this.mascoteDao = dao;
	}
	
	public void save(Mascote mascote){
		this.mascoteDao.save(mascote);
	}
	
	/**
	 * Metodo que acrescenta um voto ao mascote.
	 * TODO: atualmente está salvando usando como referencia o nome do mascote, o melhor seria usar o id.
	 * @param nomeMascote
	 * @throws BussinessException 
	 */
	public void vota(String nomeMascote) throws BussinessException{
		List<Mascote> mascoteList = this.mascoteDao.findByNome(nomeMascote);
		if (CollectionUtils.isEmpty(mascoteList)){
			throw new BussinessException("Mais de um mascote encontrado na base com o mesmo nome");
		}
		Mascote mascote = mascoteList.get(0);
		mascote.setVotos( mascote.getVotos() + 1);
		
		mascoteDao.save(mascote);
	}
	
	public List<MascoteTO> listaTudo(){
		final List<Mascote> mascotes = this.mascoteDao.findAll();
		final List<MascoteTO> mascoteTOs = new ArrayList<MascoteTO>();
		
		//Cria uma lista de MascoteTO recebedo uma lista de Mascote
		if(CollectionUtils.isNotEmpty(mascotes)){
			Long totalDeVotos = 0L;
			for (Mascote mascote : mascotes) {
				totalDeVotos = totalDeVotos + mascote.getVotos();				
			}
			
			if (totalDeVotos == 0L) {
				totalDeVotos = 1L;
			}
			for (Mascote mascote : mascotes) {
				long percVotos = Math.round(mascote.getVotos() * 100.0/totalDeVotos);
				mascoteTOs.add(new MascoteTO(mascote.getNome(), mascote.getVotos(), percVotos));
				
			}
		}
		
		return mascoteTOs;
	}
	
}
