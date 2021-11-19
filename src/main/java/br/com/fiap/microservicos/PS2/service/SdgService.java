package br.com.fiap.microservicos.PS2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.microservicos.PS2.model.Sdg;
import br.com.fiap.microservicos.PS2.repository.SdgRepository;

@Service
public class SdgService {
	@Autowired
	private SdgRepository sdgRepository;
	
	public Sdg salva(Sdg sdg) {
		return sdgRepository.save(sdg);
	}
	
	public Sdg edit(Sdg sdg) {
		return sdgRepository.save(sdg);
	}
	
	public Sdg getById(String id) {
		return sdgRepository.findById(id).orElse(null);
	}
	
	
	public void delete(String id) {
		sdgRepository.deleteById(id);;
	}
	
	public List<Sdg> lista(){
		return sdgRepository.findAll();
	}

}
