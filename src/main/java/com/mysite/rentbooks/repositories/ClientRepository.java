package com.mysite.rentbooks.repositories;

import com.mysite.rentbooks.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    @Query("select c from Client c where c.card = :card")
    Client findByCard(@Param("card") String card);
}
