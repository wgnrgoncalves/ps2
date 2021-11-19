package br.com.fiap.microservicos.PS2.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import br.com.fiap.microservicos.PS2.dto.SdgDto;
import br.com.fiap.microservicos.PS2.model.Sdg;
import br.com.fiap.microservicos.PS2.service.SdgService;

@RestController
public class SdgController {

	@Autowired
	private SdgService service;
	
	@PostMapping("/api/v1/sdg")
	public ResponseEntity<Sdg> salvaSdg(@RequestBody @Valid SdgDto sdgDto){
		
		Sdg sdg = new Sdg();
		BeanUtils.copyProperties(sdgDto, sdg);
		
		sdg = service.salva(sdg);
		
		return new ResponseEntity<Sdg>(sdg, HttpStatus.OK);
		
	}
	
	@GetMapping("/api/v1/sdg")
	public List<Sdg> List(){		
		//return service.listSdg();
	//}
		return null;
	}
}
