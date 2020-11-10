package jpa.model;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jpa.model.SurveyDao;
import jpa.model.Survey;
public class App {
    public static void main(String[] args) {
    	SurveyDao surveyDao = new SurveyDao();
    	Survey survey = new Survey("Ramesh", "Fadatare", "2020-10-01");
        
    	surveyDao.saveSurvey(survey);
        List <Survey> surveys = surveyDao.getSurveys();
        surveys.forEach(s -> System.out.println(s.getfName()));
        
    }

}
