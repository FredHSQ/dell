package com.residencia.dell.services;

import java.util.ArrayList;
import java.util.List;

import com.residencia.dell.entities.Orderlines;
import com.residencia.dell.entities.OrderlinesId;
import com.residencia.dell.repositories.OrderlinesRepository;
import com.residencia.dell.vo.OrderLinesVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderLinesService {

    @Autowired
    public OrderlinesRepository orderLinesRepository;

    public Orderlines findById(OrderlinesId id){
        return orderLinesRepository.findById(id).get();
    }

    public List<OrderLinesVO> findAllVO(Integer pagina, Integer qtdRegistros) throws Exception {
		Pageable page = null;
		List<Orderlines> listOrderLines = null;
		List<Orderlines> listOrderLinesComPaginacao = null;
		List<OrderLinesVO> listOrderLinesVO = new ArrayList<>();

		try {
			if (null != pagina && null != qtdRegistros) {

				page = PageRequest.of(pagina, qtdRegistros);
				listOrderLinesComPaginacao = orderLinesRepository.findAll(page).getContent();

				for (Orderlines lOrderLines : listOrderLinesComPaginacao) {
					listOrderLinesVO.add(convertEntidadeParaVO(lOrderLines));
				}

			} else {
				listOrderLines = orderLinesRepository.findAll();

				for (Orderlines lOrderLines : listOrderLines) {
					listOrderLinesVO.add(convertEntidadeParaVO(lOrderLines));
				}

			}
		} catch (Exception e) {
			throw new Exception("Não foi possível recuperar a lista de pedidos ::" + e.getMessage());
		}

		return listOrderLinesVO;
	}

    private OrderLinesVO convertEntidadeParaVO(Orderlines orderLines) {
		OrderLinesVO orderLinesVO = new OrderLinesVO();

		orderLinesVO.setOrderdDate(orderLines.getOrderdDate());
		orderLinesVO.setProdId(orderLines.getProdId());
        orderLinesVO.setQuantity(orderLines.getQuantity());

		return orderLinesVO;
	}

    public Long count() {
        return orderLinesRepository.count();
    }

    public Orderlines save(Orderlines orderLines) {
        Orderlines novoOrderLines = orderLinesRepository.save(orderLines);
            return novoOrderLines;
    }

    public Orderlines update(Orderlines orderLines){
        // orderLines.setOrderLineIdOrderId(id);
        return orderLinesRepository.save(orderLines);
    }

    public void deleteById(OrderlinesId id) {  
        orderLinesRepository.deleteById(id); 
    }
}
