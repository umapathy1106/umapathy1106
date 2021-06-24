package com.example.project;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface HospitalRepository extends CrudRepository<Hospital, Integer> 
{
	
}