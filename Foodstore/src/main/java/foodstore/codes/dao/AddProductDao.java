package foodstore.codes.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import foodstore.codes.model.AddProduct;
import foodstore.codes.model.Category;

@Service
public interface AddProductDao
{

public void addproduct(AddProduct regs);

public void editproduct(int i);

public void delproduct(int i);

public void showproduct();

public List<AddProduct> getProducts();

public AddProduct single_object(int pid);

public void edit_list(AddProduct adp);
public void deleteRow(int adp);
public List<Category> getAllCategories();

}