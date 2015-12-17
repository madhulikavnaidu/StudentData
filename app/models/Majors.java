package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

public class Majors extends Model {
	@Id
	public Long major_id;
	public String major_name;
	
	public static Model.Finder<Long, Majors> find = 
		new Finder<Long, Majors>(Long.class, Majors.class);
	
	public static List<Majors> students = new ArrayList<Majors>();
	
	public Majors(Long major_id, String major_name){
		this.major_id = major_id;
		this.major_name = major_name;
	}
	
	public String toString() {
		return String.format("%s-%s", major_id, major_name);
	}
}
