package com.crm.group.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crm.group.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
