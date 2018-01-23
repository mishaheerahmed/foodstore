package foodstore.codes.dao;

import org.springframework.stereotype.Service;

import foodstore.codes.model.Register;
import foodstore.codes.model.UserCredential;

@Service
public interface RegisterDao
{
public void adduser(Register regs);
public void getinfo();
public void edituser(int i);
public void deluser(int i);
public void showuser();
UserCredential getuserid(String userid);
}
