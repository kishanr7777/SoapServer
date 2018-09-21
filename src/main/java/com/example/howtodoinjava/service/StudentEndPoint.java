package com.example.howtodoinjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.howtodoinjava.xml.school.StudentDetailsRequest;
import com.howtodoinjava.xml.school.StudentDetailsResponse;

@Endpoint
public class StudentEndPoint {
	private static final String NAMESPACE_URI = "http://www.howtodoinjava.com/xml/school";
	private StudentRepository studentRepository;
	
	@Autowired
	public StudentEndPoint(StudentRepository studentRepository) {
		// TODO Auto-generated constructor stub
		this.studentRepository = studentRepository;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI,localPart = "StudentDetailsRequest")
	@ResponsePayload
	public StudentDetailsResponse getStudent(@RequestPayload StudentDetailsRequest studentDetailsRequest){
		StudentDetailsResponse studentDetailsResponse = new StudentDetailsResponse();
		studentDetailsResponse.setStudent(studentRepository.findStudent(studentDetailsRequest.getName()));
		return studentDetailsResponse;
	}

}
