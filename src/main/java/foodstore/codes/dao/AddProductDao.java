package foodstore.codes.dao;

import org.springframework.stereotype.Service;

import foodstore.codes.model.AddProduct;

@Service
public interface AddProductDao
{
public void addproduct(AddProduct regs);
public void editproduct(int i);
public void delproduct(int i);
public void showproduct();
}