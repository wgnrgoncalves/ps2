package br.com.fiap.microservicos.PS2.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.microservicos.PS2.dto.SdgDto;
import br.com.fiap.microservicos.PS2.model.Sdg;
import br.com.fiap.microservicos.PS2.service.SdgService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "SdgController")
public class SdgController {

	@Autowired
	private SdgService service;

	@ApiOperation(value = "GetAll")
	@GetMapping("/api/v1/sdg")
	public List<Sdg> Lista() {

		return service.lista();
	}

	@ApiOperation(value = "GetByAno")
	@GetMapping("/api/v1/sdg/byAno/{ano}")
	public List<Sdg> ListaPorAno(@PathVariable String ano) {

		List<Sdg> r = new ArrayList<Sdg>();
		List<Sdg> p = service.lista();
		if (p != null) {
			for (Sdg sdg : p) {

				if (sdg.getDate().equals(ano)) {
					r.add(sdg);
				}
			}
		}

		return r;
	}

	@ApiOperation(value = "GetById")
	@GetMapping("/api/v1/sdg/{id}")
	public ResponseEntity<Sdg> getById(@PathVariable String id) {

		return service.getById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());

	}

	@ApiOperation(value = "Save")
	@PostMapping("/api/v1/sdg")
	public ResponseEntity<Sdg> salvaSdg(@RequestBody @Valid SdgDto sdgDto) {

		Sdg sdg = new Sdg();
		BeanUtils.copyProperties(sdgDto, sdg);

		sdg = service.salva(sdg);

		return new ResponseEntity<Sdg>(sdg, HttpStatus.OK);

	}

	@ApiOperation(value = "Edit")
	@PutMapping("/api/v1/sdg/{id}")
	public ResponseEntity<Sdg> salvaSdg(@PathVariable("id") String id, @RequestBody @Valid SdgDto sdgDto) {

		return service.getById(id).map(record -> {
			record.setTitle(sdgDto.getTitle());
			record.setFinished(sdgDto.isFinished());
			record.setCountry(sdgDto.getCountry());
			record.setDate(sdgDto.getDate());
			record.setWaterPh(sdgDto.getWaterPh());

			Sdg sdg = service.salva(record);
			return ResponseEntity.ok().body(sdg);
		}).orElse(ResponseEntity.notFound().build());

	}

	@DeleteMapping("/api/v1/sdg/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		return service.getById(id).map(record -> {
			service.delete(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
