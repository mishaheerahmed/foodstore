package foodstore.codes.serviceimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import foodstore.codes.dao.AddProductDao;
import foodstore.codes.model.AddProduct;

@Service
public class AddProductImpl implements AddProductDao
{
@Autowired
SessionFactory sessionFactory;
public void addproduct(AddProduct r) {
System.out.println("AddProduct DAO");
//System.out.println(r.getId());
System.out.println(r.getpname());
//UserCredential uc=new UserCredential();
//uc.setUsername(r.getUsername());
//uc.setPassword(r.getPassword());
System.out.println("User Credentials");
try
{
Session session= sessionFactory.openSession();
Transaction tx=session.beginTransaction();
//tx.begin();
session.save(r);
//session.save(uc);
tx.commit();
session.flush();
session.close();
} 
catch(Exception e)
{
System.out.println("Error"+e);
} 
}

public void editproduct(int i) {
}

public void delproduct(int i) {

}
public void showproduct() {
}




}