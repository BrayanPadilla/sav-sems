package sep.gob.mx.sems.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sep.gob.mx.sems.Model.National_tours;
import sep.gob.mx.sems.Model.Sav_omvi;
import sep.gob.mx.sems.Model.Users;
import sep.gob.mx.sems.Service.National_toursService;

@Controller
public class Nationals_ToursController {
	
	private static final Logger logger = Logger
			.getLogger(Sav_omvi.class);

	Nationals_ToursController() {
		System.out.println("Nationals_Tours Controller()");
	}
	
	@Autowired
	private National_toursService natToursService;
	
	@RequestMapping(value = "/tours")
	public ModelAndView listUsers(ModelAndView model, HttpServletRequest request) throws IOException {

		List<National_tours> listaNational_tours = new ArrayList<National_tours>();
		
		try {
			listaNational_tours = natToursService.listNationaltours();
		} catch (Exception e) {
			System.out.println("Error en controller: "+e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("-------------------------------------------------");
		model.addObject("listaNationalsTours", listaNational_tours);
		model.setViewName("tours");
		return model;
	}

}
