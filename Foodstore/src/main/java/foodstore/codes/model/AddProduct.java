package foodstore.codes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity

public class AddProduct {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	int pid;
	@Column
	String pname;

@Column
String pbrand;


@Column
String prate;

@Column
String availability;

@Column
String pdesc;

@Transient
MultipartFile pimage;

public MultipartFile getPimage() {
	return pimage;
}
public void setPimage(MultipartFile pimage) {
	this.pimage = pimage;
}

@ManyToOne(targetEntity = Category.class)
@JoinColumn(name="id")
private Category category;

public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category = category;

}

public String getpname() {
	return pname;
}
public void setpname(String pname) {
	this.pname = pname;
}

public int getpid(){
	return pid;
}
public void setpid(int pid){
this.pid= pid;
}

public String getpbrand() {
	return pbrand;
}

public void setpbrand(String pbrand) {
	this.pbrand = pbrand;
}
public String getprate() {
	return prate;
}
public void setprate(String prate) {
	this.prate = prate;
}

public String getavailability() {
	return availability;
}
public void setavailability(String availability) {
	this.availability = availability;
}

public String getpdesc() {
	return pdesc;
}
public void setpdesc(String pdesc) {
	this.pdesc = pdesc;
}

}
