package com.residencia.dell.controllers;

import java.util.List;

import javax.validation.Valid;

import com.residencia.dell.entities.Orders;
import com.residencia.dell.services.OrderService;
import com.residencia.dell.vo.NFVO;
import com.residencia.dell.vo.OrdersVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    
    @Autowired
    private OrderService orderService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Orders> findById(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(orderService.findById(id), 
				headers, HttpStatus.OK);
	}

	@GetMapping("/NF/{id}")
	public ResponseEntity<NFVO> criarNF(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();

		return new ResponseEntity<>(orderService.criarNF(id), 
				headers, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<OrdersVO>> findAllVO(
			@RequestParam(required = false) Integer pagina,
			@RequestParam(required = false) Integer qtdRegistros) 
					throws Exception {
		
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(orderService.findAllVO(pagina, 
				qtdRegistros), headers, HttpStatus.OK);
	}
	
	@GetMapping("/count")
	public Long count() {
		return orderService.count();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> save(@Valid @RequestBody OrdersVO order){

		OrdersVO newOrder = orderService.save(order);
		if(null != newOrder)
			return ResponseEntity.ok("Order válido e salvo.");
		else{
			return ResponseEntity.unprocessableEntity().build();
		}
	}
	
	@PutMapping
    public Orders update(@RequestBody Orders order, @PathVariable Integer id){
       return orderService.update(order,id);
    }

	@DeleteMapping
	public void deleteById (@RequestParam Integer id){
		orderService.deleteById(id);
	}
}
