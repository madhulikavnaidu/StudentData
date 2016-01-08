package controllers;

import java.util.List;

import models.Students;
import models.Majors;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.forms.newmajorform;
import views.html.forms.listmajor;

public class MajorData extends Controller{
	
	public final static Form<Majors> majorForm = Form.form(Majors.class);
	
	public static Result index(){
		return redirect(routes.MajorData.listmajor());
	}
	
	public static Result listmajor(){
		List<Majors> majors = Majors.find.all();
		return ok(listmajor.render(majors));
	}
	
	public static Result newmajorform(){
		return ok(newmajorform.render(majorForm));
	}
	
	public static Result details(){
		
		Form<Majors>filledForm = majorForm.bindFromRequest();
		Majors majors =  filledForm.get();
		return ok(newmajorform.render(filledForm));
	}
	
	public static Result save(){
		Form<Majors> boundForm = majorForm.bindFromRequest();
		Majors majors =  boundForm.get();
		majors.save();
		return redirect(routes.MajorData.listmajor());
	}
	
	public static Result removemajor(Long eid)
	{
		Majors majors=  Majors.find.byId(eid);
		majors.delete();
		return redirect(routes.MajorData.listmajor());
	}
	
	public static Result edit(Long eid){
		final Majors majors =  Majors.find.byId(eid);
		Form<Majors>filledForm = majorForm.fill(majors);
		return ok(newmajorform.render(filledForm));
		
	}
}

