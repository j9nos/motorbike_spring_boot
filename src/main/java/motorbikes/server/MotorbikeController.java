package motorbikes.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
public class MotorbikeController {

    @Autowired
    private MotorbikeRepo motorbikeRepo;

    @RequestMapping(path = "/motorbikes", method = RequestMethod.GET)
    public List<Motorbike> getMotorbikes() {
        return motorbikeRepo.findAll();
    }

    @RequestMapping(path = "/motorbike/add", method = RequestMethod.POST, consumes = {
            MediaType.APPLICATION_FORM_URLENCODED_VALUE })
    public Motorbike addMotorbike(@RequestParam Map<String, String> body) {
        return motorbikeRepo.save(new Motorbike(body.get("brand"), body.get("type"), body.get("fuel"),
                Integer.parseInt(body.get("maxspeed"))));
    }

    @RequestMapping(path = "/motorbike/edit/{id}", method = RequestMethod.PUT, consumes = {
            MediaType.APPLICATION_FORM_URLENCODED_VALUE })
    public Motorbike editMotorbike(@PathVariable int id, @RequestParam Map<String, String> body) {
        Motorbike motorbikeToEdit = motorbikeRepo.findById(id).get();
        motorbikeToEdit.setBrand(body.get("brand"));
        motorbikeToEdit.setType(body.get("type"));
        motorbikeToEdit.setFuel(body.get("fuel"));
        motorbikeToEdit.setMaxspeed(Integer.parseInt(body.get("maxspeed")));
        return motorbikeRepo.save(motorbikeToEdit);
    }

    @RequestMapping(path = "/motorbike/delete/{id}", method = RequestMethod.DELETE)
    public void deleteMotorbike(@PathVariable int id) {
        motorbikeRepo.delete(motorbikeRepo.findById(id).get());
    }

}
