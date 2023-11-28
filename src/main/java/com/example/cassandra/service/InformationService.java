package com.example.cassandra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cassandra.entity.Information;
import com.example.cassandra.repo.InformationRepository;

@Service
public class InformationService {

	@Autowired
	private InformationRepository repo;
	
	public List<Information> findAll(){
		return repo.findAll();
	}
	
	public Optional<Information> findById(String id) {
		return repo.findById(id);
	}
	
	public Information findBySerialNumber(String serialNumber){
		return repo.findBySerialNumber(serialNumber);
	}
	
	public void saveAll(List<Information> informations) {
		repo.saveAll(informations);
	}
	
	public void save(Information information) {
		repo.save(information);
	}
	
	public Optional<Information> deleteById(String id) {
		
		Optional<Information> information = repo.findById(id);
		if(information.isPresent()) {
			repo.deleteById(id);
		}	
		return information;
	}
	
}
