package com.rigo.rigo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rigo.rigo.entities.Corpusfrmr;
import com.rigo.rigo.repositories.CorpusfrmrRepos;
import com.rigo.rigo.services.CorpusfrmrService;

@Service 
public class CorpusfrmrImpl implements CorpusfrmrService {
	
	@Autowired
	CorpusfrmrRepos repos; 
	
	@Override
	public Corpusfrmr create(Corpusfrmr corpusfrmrr) {
		return repos.save(corpusfrmrr);
	}

	@Override
	public Corpusfrmr update(Corpusfrmr corpusfrmrr) {
		return repos.save(corpusfrmrr);
	}

	@Override
	public Optional<Corpusfrmr> find(Integer idcorpusfrmr) {
		return repos.findById(idcorpusfrmr);
	}

	@Override
	public void deleted(Integer idcorpusfrmr) {
		repos.deleteById(idcorpusfrmr);
		
	}

	@Override
	public List<Corpusfrmr> findAll() {
		return repos.findAll();
	}

	public String findByFormecritfr(String corpusfrmr){
        return repos.findByFormecritfr(corpusfrmr).getFormecritfr();
    }
}
