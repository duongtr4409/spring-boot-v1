package com.laptrinhjavaweb.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.NewDTO;

@RestController
public class NewAPI {
	
	@PostMapping(value = "/api/new")
	public ResponseEntity<NewDTO> createNew(@RequestBody NewDTO newDTO){
		return ResponseEntity.ok().body(newDTO);
	}
	
	@PutMapping(value = "/api/new")
	public ResponseEntity<NewDTO> updateNew(@RequestBody NewDTO newDTO){
		return ResponseEntity.ok().body(newDTO);
	}
	
	@DeleteMapping(value = "/api/new")
	public ResponseEntity<long[]> deleteNew(@RequestBody long[] ids){
		return ResponseEntity.ok().body(ids);
	}
}
