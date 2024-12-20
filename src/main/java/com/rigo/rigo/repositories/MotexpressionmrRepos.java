/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rigo.rigo.repositories;

import com.rigo.rigo.entities.Motexpressionmr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *						ORDER BY m.idmefr.formeecrite
 * @author HP
 */
public interface MotexpressionmrRepos extends JpaRepository<Motexpressionmr, Integer> {

    @Query(value = "SELECT m FROM Motexpressionmr m WHERE m.idmefr.formeecrite=?1 ORDER BY m.idmefr.formeecrite")
    Motexpressionmr findByMotexpressionfr(String formeecrite);

}
