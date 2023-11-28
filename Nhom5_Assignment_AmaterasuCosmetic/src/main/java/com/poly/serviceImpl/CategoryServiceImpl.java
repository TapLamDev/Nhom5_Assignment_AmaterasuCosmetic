package com.poly.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.CategoryDAO;
import com.poly.entity.Category;
import com.poly.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDAO cdao;
	
	
	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return cdao.findAll();
	}

	@Override
	public Category findById(int id) {
		// TODO Auto-generated method stub
		return cdao.findById(id).get();
	}

	@Override
	public List<Category> findByCategoryId(int cid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category create(Category category) {
		// TODO Auto-generated method stub
		return cdao.save(category);
	}

	@Override
	public Category update(Category category) {
		// TODO Auto-generated method stub
		return cdao.save(category);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		cdao.deleteById(id);
	}



	
}
