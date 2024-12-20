package com.rigo.rigo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rigo.rigo.entities.Corpusfrmr;

public interface CorpusfrmrRepos extends JpaRepository<Corpusfrmr, Integer> {
//	@Query(value = "SELECT c FROM Corpusfrmr c WHERE c.idcorpusfrmr.formecritfr=?1 ORDER BY c.idcorpusfrmr.formecritfr")
	Corpusfrmr findByFormecritfr(String formecritfr);
}
