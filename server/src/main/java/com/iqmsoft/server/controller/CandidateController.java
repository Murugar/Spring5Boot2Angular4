package com.iqmsoft.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.iqmsoft.server.dto.SearchData;
import com.iqmsoft.server.entity.Candidate;
import com.iqmsoft.server.service.CandidateService;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/api/candidate")
public class CandidateController {
    @Autowired
    private CandidateService service;

    @RequestMapping(method = RequestMethod.POST)
    public Candidate insert(@RequestBody Candidate candidate) {
        return service.insert(candidate);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Optional<Candidate> findById(@PathVariable String id) {
        return service.findById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public boolean deleteById(@PathVariable String id) {
        return service.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Candidate> findAll() {
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/search")
    public List<Candidate> findByName(@RequestBody SearchData searchData) {
        return service.findByName(searchData.getSearchKey());
    }
}
