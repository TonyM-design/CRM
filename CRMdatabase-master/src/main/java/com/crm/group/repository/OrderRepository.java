package com.crm.group.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crm.group.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
