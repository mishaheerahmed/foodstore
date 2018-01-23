package foodstore.codes.serviceimpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import foodstore.codes.dao.AddProductDao;
import foodstore.codes.model.AddProduct;
import foodstore.codes.model.Category;

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
public List<AddProduct> getProducts() {
	Session session =sessionFactory.openSession();
	 Transaction transaction =  session.beginTransaction();
	List<AddProduct> productList=null;
     try {
     productList= session.createQuery("from AddProduct").list();   
 	    transaction.commit();                 
   }
  catch (Exception e) {
  transaction.rollback();
  e.printStackTrace();
   }
  session.close();
 return productList;
}


public void edit_list(AddProduct adp){
	   Session session =sessionFactory.openSession();
	  // System.out.println("edit session"+session);
 	 Transaction transaction =  session.beginTransaction();
 	List<AddProduct> editlist=null;
    try {
    	 int id=adp.getpid();
    	  // int pid=adp.getpid();
		   // System.out.println("id******"+id);
	        editlist=  session.createQuery("from AddProduct where pid=:pid").setParameter("pid",id).list();
	    System.out.println("editlist *********"+editlist);
	        		     		       
	        editlist.get(0).setpid(adp.getpid());
	        editlist.get(0).setpname(adp.getpname());
	        editlist.get(0).setpdesc(adp.getpdesc());
	        editlist.get(0).setprate(adp.getprate());
	        editlist.get(0).setpbrand(adp.getpbrand());
	        editlist.get(0).setavailability(adp.getavailability());
	        session.saveOrUpdate(editlist.get(0));
	        transaction.commit();
	      }
    catch (Exception e) {
        transaction.rollback();
        e.printStackTrace();
	       }  
      session.close();
 }

@SuppressWarnings("unchecked")
public AddProduct single_object(int pid)
{
   Session session =sessionFactory.openSession();
  // System.out.println("single object session"+session);
   Transaction transaction =  session.beginTransaction();
   List<AddProduct> b4=null;
 	try
     {
 	//String query=.list();
 	//System.out.println(query);
     b4 =  session.createQuery("from AddProduct where pid= :pid").setParameter("pid",pid).list();
    System.out.println("*****"+b4.get(0));
     transaction.commit();
     session.close();
                 
 }        
 catch (Exception e) 
 {
    transaction.rollback();
    e.printStackTrace();
 }
    return b4.get(0);
} 

public void deleteRow(int pid) {  
	   Session session =sessionFactory.openSession();
	   Transaction transaction =  session.beginTransaction();
    List<AddProduct> del=null;
    try{
 	 del=session.createQuery("from AddProduct where pid=:pid").setParameter("pid", pid).list();
       session.delete(del.get(0));
       transaction.commit();
       session.close();
  
    }
catch(Exception e){
   transaction.rollback();
   e.printStackTrace();
}
}
public List<Category> getAllCategories() {
	// TODO Auto-generated method stub
	Session session=sessionFactory.openSession();
	Transaction transaction=session.beginTransaction();
	Query query=session.createQuery("from Category");
	List<Category> categories=query.list();
	return categories;
}
}