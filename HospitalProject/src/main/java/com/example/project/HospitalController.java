package com.example.project;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/")
public class HospitalController {

@Autowired
private HospitalService hospitalService;

@GetMapping(value="/hospitals/{id}")
@ResponseBody
public Hospital getHospital(@PathVariable("id") int id) throws Exception 
{
   return this.hospitalService.getHospital(id); 
}

@GetMapping("/hospitals/")
@ResponseBody
public List<Hospital> getAllHospitals() throws Exception 
{
  return this.hospitalService.getAllHospitals();
}

@PostMapping(value="/hospitals/")
public ResponseEntity<String> addHospital(@RequestBody Hospital hospital) 
{
	this.hospitalService.addHospital(hospital);
	return ResponseEntity.ok().body("Hospital Added Successfully");
}

@PutMapping(value="/hospitals/{id}")
public ResponseEntity<String> updateHospital(@RequestBody Hospital hospital)
{
	this.hospitalService.updateHospital(hospital);
	return ResponseEntity.ok().body("Hospital Updated Successfully");
}

@DeleteMapping(value="/hospitals/")
public ResponseEntity<String> deleteHospital(@RequestBody Hospital hospital) 
{
	this.hospitalService.deleteHospital(hospital);
	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
}
}
