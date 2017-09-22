package foodstore.codes.serviceimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import foodstore.codes.dao.RegisterDao;
import foodstore.codes.model.Register;

@Service
public class RegisterImpl implements RegisterDao
{
@Autowired
SessionFactory sessionFactory;
public void adduser(Register r) {
System.out.println("Register DAO");
//System.out.println(r.getId());
System.out.println(r.getUsername());
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

public void edituser(int i) {
}

public void deluser(int i) {

}
public void showuser() {
}


public void getinfo() {
	
	
}

}