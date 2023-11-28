package com.example.cassandra.repo;

import java.util.List;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.example.cassandra.entity.Information;

@Repository
public interface InformationRepository extends CassandraRepository<Information, String> {

	@AllowFiltering
	public Information findBySerialNumber(String serialNumber);
	
	
}
