package foodstore.codes.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import foodstore.codes.model.AddProduct;
import foodstore.codes.model.Category;

@Service
public interface CategoryDao
{

	public void addcategory(Category ap);
	//public void Category(Category ct);
	public  List<Category> getProducts();
	public Category single_object(int pid);
	void edit_list(Category adp);
	public void deleteRow(int id);
//	public Category getAddcategoryById(int id);
	public void del_catid(Category cid);


}
