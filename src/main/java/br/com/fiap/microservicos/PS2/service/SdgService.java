package br.com.fiap.microservicos.PS2.service;

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

}
