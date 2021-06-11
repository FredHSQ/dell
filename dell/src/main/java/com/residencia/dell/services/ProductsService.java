package com.residencia.dell.services;

import java.util.ArrayList;
import java.util.List;

import com.residencia.dell.entities.Products;
import com.residencia.dell.repositories.ProductsRepository;
import com.residencia.dell.vo.ProductsVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {
    
    @Autowired
    public ProductsRepository productsRepository;

    public Products findById(Integer id){
        return productsRepository.findById(id).get();
    }

    public List<ProductsVO> findAllVO(Integer pagina, Integer qtdRegistros) throws Exception {
		Pageable page = null;
		List<Products> listProducts = null;
		List<Products> listProductsComPaginacao = null;
		List<ProductsVO> listProductsVO = new ArrayList<>();

		try {
			if (null != pagina && null != qtdRegistros) {

				page = PageRequest.of(pagina, qtdRegistros);
				listProductsComPaginacao = productsRepository.findAll(page).getContent();

				for (Products lProducts : listProductsComPaginacao) {
					listProductsVO.add(convertEntidadeParaVO(lProducts));
				}

			} else {
				listProducts = productsRepository.findAll();

				for (Products lProducts : listProducts) {
					listProductsVO.add(convertEntidadeParaVO(lProducts));
				}

			}
		} catch (Exception e) {
			throw new Exception("Não foi possível recuperar a lista de pedidos ::" + e.getMessage());
		}

		return listProductsVO;
	}

    private ProductsVO convertEntidadeParaVO(Products products) {
		ProductsVO productsVO = new ProductsVO();

		productsVO.setActor(products.getActor());
		productsVO.setCategory(products.getCategory());
		productsVO.setCommon_prod_id(products.getCommon_prod_id());
		productsVO.setPrice(products.getPrice());
		productsVO.setProdId(products.getProdId());
        productsVO.setSpecial(products.getSpecial());
        productsVO.setTitle(products.getTitle());

		return productsVO;
	}

    public Long count() {
        return productsRepository.count();
    }

    public Products save(Products products) {
        Products novoProducts = productsRepository.save(products);
            return novoProducts;
    }

    public Products update(Products products, Integer id){
        products.setProdId(id);
        return productsRepository.save(products);
    }

    public void deleteById(Integer id) {  
        productsRepository.deleteById(id); 
    }
}
