package foodstore.codes.dao;

import java.util.List;

import foodstore.codes.model.AddProduct;
import foodstore.codes.model.Cart;
import foodstore.codes.model.Category;

public interface CartDao {

  void cartsave(Cart cart1);
  List<Cart> cartlist();
AddProduct single_object(int pid);
public void deleteRow(int productId);

}
