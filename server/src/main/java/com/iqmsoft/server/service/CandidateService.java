package com.iqmsoft.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iqmsoft.server.entity.Candidate;
import com.iqmsoft.server.repository.CandidateRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;



@Service("candidateService")
@Transactional
public class CandidateService {
    @Autowired
    private CandidateRepo repo;

    public Candidate insert(Candidate candidate) {
        return repo.save(candidate);
    }

    public Optional<Candidate> findById(String id) {
        return repo.findById(id);
    }

    public List<Candidate> findAll() {
        return repo.findAllCandidate();
    }

    public List<Candidate> findByName(String name) {
        return repo.findByName("%" + name + "%");
    }

    public boolean delete(String id) {
        repo.deleteById(id);
        return true;
    }

}
