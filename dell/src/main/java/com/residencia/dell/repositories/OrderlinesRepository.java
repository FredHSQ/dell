package com.residencia.dell.repositories;

import java.util.List;

import com.residencia.dell.entities.Orderlines;
import com.residencia.dell.entities.OrderlinesId;
import com.residencia.dell.entities.Orders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderlinesRepository extends JpaRepository<Orderlines,OrderlinesId>{
 
   List<Orderlines> findByOrders(Orders orders);

}
