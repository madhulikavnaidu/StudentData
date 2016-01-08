package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class Students extends Model{
	@Id
	public Long id;
	
	public String name;
	public Long rollno;
	public Long age;
	public Long major_id;
	
	public static Model.Finder<Long, Students> find = 
		new Finder<Long, Students>(Long.class, Students.class);
	
	public static List<Students> students = new ArrayList<Students>();
	
	public Students(String name, Long rollno, Long age, Long major_id){
		this.name = name;
		this.rollno = rollno;
		this.age = age;
		this.major_id = major_id;
	}
	
	public String toString() {
		return String.format("%s-%s", rollno, name, age, major_id);
	}
}
