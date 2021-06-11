package com.residencia.dell.controllers;

import java.util.List;

import com.residencia.dell.entities.Orderlines;
import com.residencia.dell.entities.OrderlinesId;
import com.residencia.dell.services.OrderLinesService;
import com.residencia.dell.vo.OrderLinesVO;

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
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/orderlines")
public class OrderLinesController {
    
    @Autowired
    private OrderLinesService orderLinesService;
	
	@GetMapping("/byId")
	public ResponseEntity<Orderlines> findById(@RequestBody OrderlinesId id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(orderLinesService.findById(id), 
				headers, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<OrderLinesVO>> findAllVO(
			@RequestParam(required = false) Integer pagina,
			@RequestParam(required = false) Integer qtdRegistros) 
					throws Exception {
		
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(orderLinesService.findAllVO(pagina, 
				qtdRegistros), headers, HttpStatus.OK);
	}
	
	@GetMapping("/count")
	public Long count() {
		return orderLinesService.count();
	}

	@PostMapping
	public ResponseEntity<Orderlines> save(@RequestBody Orderlines orderLines){
		//return OrderLineservice.save(orderLines);
		HttpHeaders headers = new HttpHeaders();
		Orderlines newOrderLines = orderLinesService.save(orderLines);
		if(null != newOrderLines)
			return new ResponseEntity<>(newOrderLines, headers, HttpStatus.OK);
		else
			return new ResponseEntity<>(newOrderLines, headers, HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping
    public Orderlines update(@RequestBody Orderlines orderLines, @PathVariable String id){
       return orderLinesService.update(orderLines);
    }

	@DeleteMapping
	public void deleteById (@RequestBody OrderlinesId id){
		orderLinesService.deleteById(id);
	}

}
