package com.example.ava.Repository;

import com.example.ava.Model.Ava;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AvaRepository extends JpaRepository<Ava, Long> {

    @Query("SELECT a FROM Ava a WHERE a.client.id = :clientId")
    List<Ava> findByClientId(@Param("clientId") Long clientId);
}
