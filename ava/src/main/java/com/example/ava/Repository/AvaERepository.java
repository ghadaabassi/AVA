package com.example.ava.Repository;

import com.example.ava.Model.AvaE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AvaERepository extends JpaRepository<AvaE, Long> {

   @Query("SELECT ae FROM AvaE ae WHERE ae.client.email = :clientEmail")
   List<AvaE> findByClientEmail(@Param("clientEmail") String clientEmail);
}
