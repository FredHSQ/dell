package com.residencia.dell.controllers;

import java.util.List;

import com.residencia.dell.entities.Products;
import com.residencia.dell.services.ProductsService;
import com.residencia.dell.vo.ProductsVO;

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
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Products> findById(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(productsService.findById(id), 
				headers, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<ProductsVO>> findAllVO(
			@RequestParam(required = false) Integer pagina,
			@RequestParam(required = false) Integer qtdRegistros) 
					throws Exception {
		
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(productsService.findAllVO(pagina, 
				qtdRegistros), headers, HttpStatus.OK);
	}
	
	@GetMapping("/count")
	public Long count() {
		return productsService.count();
	}

	@PostMapping
	public ResponseEntity<Products> save(@RequestBody Products products){
		//return Productservice.save(products);
		HttpHeaders headers = new HttpHeaders();
		Products newProducts = productsService.save(products);
		if(null != newProducts)
			return new ResponseEntity<>(newProducts, headers, HttpStatus.OK);
		else
			return new ResponseEntity<>(newProducts, headers, HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping
    public Products update(@RequestBody Products products, @PathVariable Integer id){
       return productsService.update(products,id);
    }

	@DeleteMapping
	public void deleteById (@RequestParam Integer id){
		productsService.deleteById(id);
	}
}
