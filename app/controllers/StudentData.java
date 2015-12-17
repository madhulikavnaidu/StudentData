package controllers;

import java.util.List;

import models.Students;
import models.Majors;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.forms.list;
import views.html.forms.newform;

public class StudentData extends Controller{
	
	public final static Form<Students> studentForm = Form.form(Students.class);
	
//	public static Result index(){
//		return redirect(routes.StudentData.list());
//	}
	
	public static Result list(){
		List<Students> students = studentForm.find.all();
		return ok(list.render(students));
	}
	
	public static Result newform(){
		return ok(newform.render(studentForm));
	}
	
	public static Result save(){
		Form<Students> boundForm = studentForm.bindFromRequest();
		Students students =  boundForm.get();
		students.save();
		return redirect(routes.StudentData.list());
	}
	
	public static Result removestudent(Long eid)
	{
		Students students =  Students.find.byId(eid);
		students.delete();
		return redirect(routes.StudentData.list());
	}
	
	public static Result edit(Long eid){
		final Students students =  Students.find.byId(eid);
		Form<Students>filledForm = studentForm.fill(students);
		return ok(newform.render(filledForm));
		
	}
}
