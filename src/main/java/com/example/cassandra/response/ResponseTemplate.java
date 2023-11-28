package com.example.cassandra.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemplate {

	private Integer status;
	private String message;
	private Object data;
	
	
}
