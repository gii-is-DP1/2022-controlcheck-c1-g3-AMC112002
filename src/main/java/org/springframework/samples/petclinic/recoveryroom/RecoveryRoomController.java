package org.springframework.samples.petclinic.recoveryroom;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recoveryroom")
public class RecoveryRoomController {
	
	 private static final String VIEW_RECOVERYROOMS_CREATE_FORM = "recoveryroom/createOrUpdateRecoveryRoomForm";
	    private static final String WELCOME = "welcome";
	    private RecoveryRoomService rrservice;
	    
	    @Autowired
	    public RecoveryRoomController(RecoveryRoomService service) {
	    	this.rrservice = service;
	    }
	    
	    @GetMapping("/create") 	
	    public String initRecoveryRoom(ModelMap map) {
	    	map.addAttribute("recoveryroom", new RecoveryRoom());
	    	map.addAttribute("types", rrservice.getAllRecoveryRoomTypes());
	    	return VIEW_RECOVERYROOMS_CREATE_FORM;
	    }
	    
	    @PostMapping(path = "/create")
	    public String createRecoveryRoom(@Valid RecoveryRoom recoveryroom, BindingResult br, ModelMap map){
	        if(!br.hasErrors()){
	        	rrservice.save(recoveryroom);
	            map.addAttribute("message", "Recovery Room succesfully save");
	            return WELCOME;
	        } else {
	            map.addAttribute("recovery room", recoveryroom);
	            map.addAttribute("types", rrservice.getAllRecoveryRoomTypes());
	        }
	        return VIEW_RECOVERYROOMS_CREATE_FORM;
	    }
    
}
