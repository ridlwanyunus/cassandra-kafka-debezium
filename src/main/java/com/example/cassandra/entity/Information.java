package com.example.cassandra.entity;

import java.util.Date;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Information {

	@PrimaryKey
	private String id;
	
	@Column("serial_number")
	private String serialNumber;
	
	@Column("npwp")
	private String npwp;

	@Column("certificate")
	private String certificate;
	
	@Column("creation_date")
	private Date creationDate;
	
}
