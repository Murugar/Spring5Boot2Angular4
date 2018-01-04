package com.iqmsoft.server.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.iqmsoft.server.entity.Candidate;

import java.util.List;


public interface CandidateRepo extends CrudRepository<Candidate, String>{
    @Query("SELECT c FROM Candidate c")
    List<Candidate> findAllCandidate();

    @Query("SELECT c FROM Candidate c WHERE LOWER(c.fullName) LIKE LOWER(:name)")
    List<Candidate> findByName(@Param("name") String name);
}
