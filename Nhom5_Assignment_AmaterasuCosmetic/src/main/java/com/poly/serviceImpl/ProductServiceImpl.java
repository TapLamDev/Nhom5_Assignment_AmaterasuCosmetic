package com.poly.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.ProductDAO;
import com.poly.entity.Category;
import com.poly.entity.Product;
import com.poly.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDAO pdao;
	
	@Override
	public List<Product> findAll(){
		return pdao.findAll();
	}

	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		return pdao.findById(id).get();
	}

//	@Override
//	public List<Product> findByCategoryId(int cid) {
//		// TODO Auto-generated method stub
//		return pdao.findByCategoryId(cid);
//	}

	@Override
	public Product create(Product product) {
		// TODO Auto-generated method stub
		return pdao.save(product);
	}

	@Override
	public Product update(Product product) {
		// TODO Auto-generated method stub
		return pdao.save(product);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		pdao.deleteById(id);
	}

	@Override
	public List<Product> findByCategoryId(int cid) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
