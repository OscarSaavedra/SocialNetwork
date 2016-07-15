package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ParejaRepository extends JpaRepository<Pareja,Long> {

    @Query("SELECT pareja FROM Pareja pareja WHERE pareja.p1=:persona OR pareja.p2=:persona")
    Pareja getPareja(@Param("persona") Persona persona);
}
