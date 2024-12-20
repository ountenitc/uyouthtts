package com.rigo.rigo.services;

import java.util.List;
import java.util.Optional;

import com.rigo.rigo.entities.Corpusfrmr;

public interface CorpusfrmrService {
	
	public Corpusfrmr create(Corpusfrmr corpusfrmrr);

    public Corpusfrmr update(Corpusfrmr corpusfrmrr);

    public Optional<Corpusfrmr> find(Integer idcorpusfrmr);

    public void deleted(Integer idcorpusfrmr);

    public List<Corpusfrmr> findAll();
}
