package cs.swe645.resources;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataParam;

import jpa.model.SurveyDao;
import jpa.model.Survey;

@Path("/surveys")
public class SurveyResource {
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getServeys() {
		SurveyDao surveyDao = new SurveyDao();
		List<Survey> surveys = surveyDao.getSurveys();
		surveys.forEach(s -> System.out.println(s.getfName()));
		return Response.ok().entity(surveys).build();
	}

	@POST
	@Path("/create")
	@Consumes("application/json")
	public void addSurvey(Survey s) {
		//Adding the student to records
		SurveyDao sr = new SurveyDao();
		sr.saveSurvey(s);
		
	}

}
