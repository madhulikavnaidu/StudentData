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
	
	public static Result index(){
		return redirect(routes.StudentData.list());
	}
	
	public static Result list(){
		List<Students> forms = Students.find.all();
		return ok(list.render(forms));
	}
	
	public static Result newform(){
		return ok(newform.render(studentForm));
	}
	
	public static Result details(Long id){
		final Students students  = Students.find.byId(id);
		//students.delete();
		Form<Students>filledForm = studentForm.fill(students);
//		Students students =  filledForm.get();
		return ok(newform.render(filledForm));
	}
	
	public static Result save(){
		Form<Students> boundForm = studentForm.bindFromRequest();
		Students students =  boundForm.get();
		if(students.id == null){
			students.save();
		}else{
			students.update();
		}
		return redirect(routes.StudentData.list());
	}
	
	public static Result removestudent(Long id)
	{
		Students students =  Students.find.byId(id);
		students.delete();
		return redirect(routes.StudentData.list());
	}
	
	public static Result edit(Long eid){
		final Students students =  Students.find.byId(eid);
		Form<Students>filledForm = studentForm.fill(students);
		return ok(newform.render(filledForm));
		
	}
}
