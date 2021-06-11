package com.residencia.dell.services;

import java.util.ArrayList;
import java.util.List;


import com.residencia.dell.entities.Orderlines;
import com.residencia.dell.entities.Orders;
import com.residencia.dell.repositories.CustomersRepository;
import com.residencia.dell.repositories.OrderlinesRepository;
import com.residencia.dell.repositories.OrdersRepository;
import com.residencia.dell.repositories.ProductsRepository;
import com.residencia.dell.vo.ItemOrderLinesVO;
import com.residencia.dell.vo.NFVO;
import com.residencia.dell.vo.OrderLinesVO;
import com.residencia.dell.vo.OrdersVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired
	public OrderlinesRepository orderLinesRepository;

	@Autowired
	public OrdersRepository orderRepository;

	@Autowired
	public ProductsRepository productsRepository;

	@Autowired
	public CustomersRepository customersRepository;

	public Orders findById(Integer id) {
		return orderRepository.findById(id).get();
	}

	public List<OrdersVO> findAllVO(Integer pagina, Integer qtdRegistros) throws Exception {
		Pageable page = null;
		List<Orders> listOrders = null;
		List<Orders> listOrdersComPaginacao = null;
		List<OrdersVO> listOrdersVO = new ArrayList<>();

		try {
			if (null != pagina && null != qtdRegistros) {

				page = PageRequest.of(pagina, qtdRegistros);
				listOrdersComPaginacao = orderRepository.findAll(page).getContent();

				for (Orders lOrders : listOrdersComPaginacao) {
					listOrdersVO.add(convertEntidadeParaVO(lOrders));
				}

			} else {
				listOrders = orderRepository.findAll();

				for (Orders lOrders : listOrders) {
					listOrdersVO.add(convertEntidadeParaVO(lOrders));
				}

			}
		} catch (Exception e) {
			throw new Exception("Não foi possível recuperar a lista de pedidos ::" + e.getMessage());
		}

		return listOrdersVO;
	}

	private OrdersVO convertEntidadeParaVO(Orders orders) {
		OrdersVO ordersVO = new OrdersVO();

		ordersVO.setNetAmount(orders.getNetAmount());
		ordersVO.setOrderDate(orders.getOrderDate());
		ordersVO.setCustomers(orders.getCustomers().getCustomerId());
		ordersVO.setTax(orders.getTax());
		ordersVO.setTotalAmount(orders.getTotalAmount());
		ordersVO.setOrderid(orders.getOrderid());

		return ordersVO;
	}

	public NFVO criarNF(Integer id) {

		NFVO nfVO = new NFVO();

		Orders orders = orderRepository.getById(id);

		if (orders != null) {

			List<ItemOrderLinesVO> listOrderLineProdQtd = new ArrayList<>();

			nfVO.setNetAmount(orders.getNetAmount());
			nfVO.setTotalAmount(orders.getTotalAmount());
			nfVO.setOrderDate(orders.getOrderDate());
			nfVO.setOrderId(orders.getOrderid());

			nfVO.setFirstName(orders.getCustomers().getFirstName());
			nfVO.setFirstName(orders.getCustomers().getLastName());

			List<Orderlines> listOrderLines = orderLinesRepository.findByOrders(orders);

			if (listOrderLines != null) {
				for (Orderlines lOrderLines : listOrderLines) {
					ItemOrderLinesVO orderLinesVO = new ItemOrderLinesVO();

					orderLinesVO.setProdId(lOrderLines.getProdId());
					orderLinesVO.setQuantity(lOrderLines.getProdId());

					if (productsRepository.findById(lOrderLines.getProdId()).get() != null)
						orderLinesVO.setTitle(productsRepository.findById(lOrderLines.getProdId()).get().getTitle());
					else
						orderLinesVO.setTitle(null);

					listOrderLineProdQtd.add(orderLinesVO);
				}
			} else {
				ItemOrderLinesVO orderLinesVO = null;
				listOrderLineProdQtd.add(orderLinesVO);
			}

			nfVO.setListItemOrderLinesVO(listOrderLineProdQtd);
		}
		else{
			nfVO=null;
		}
		return nfVO;

	}

	public OrdersVO save (OrdersVO orderVO){

		Orders newOrder = new Orders();
		Integer id = null;
		newOrder.setOrderid( (null == id) ? orderVO.getOrderid() : id);
        newOrder.setCustomers(customersRepository.findById(orderVO.getCustomers()).get());
        newOrder.setOrderDate(orderVO.getOrderDate());
        newOrder.setNetAmount(orderVO.getNetAmount());
        newOrder.setTax(orderVO.getTax());
        newOrder.setTotalAmount(orderVO.getTotalAmount());

		Orders order = orderRepository.save(newOrder);

		Integer i=1;
        for (OrderLinesVO orderlinesVO : orderVO.getListOrderLinesVO()){

            Orderlines orderlines = new Orderlines(i, order.getOrderid(), productsRepository.getById(orderlinesVO.getProdId()).getProdId(),orderlinesVO.getQuantity(), order.getOrderDate());
			
			orderLinesRepository.save(orderlines);
			i++;

        }

        return  convertEntidadeParaVO(newOrder);
    }

	public Long count() {
		return orderRepository.count();
	}

	public Orders update(Orders order, Integer id) { // throws OrdersException{
		// if(null == id){
		// throw new OrdersException("Não foi informado um ID válido");
		// }else{
		order.setOrderid(id);
		return orderRepository.save(order);
		// }

	}

	public void deleteById(Integer id) {
		orderRepository.deleteById(id);
	}
}
