package latihan.latihan.controller.person;


import latihan.latihan.model.Person;
import latihan.latihan.model.dto.person.ListPersonDto;
import latihan.latihan.service.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/v1/")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping(path="person")
    public ResponseEntity getAllPerson() {
        List<Person> person = personService.findAll();
        List<ListPersonDto> data = PersonMapper.toPersonDao(person);

        Map<String, Object> response = new HashMap<>();
        response.put("total", data.size());
        response.put("count", data.size());
        response.put("data", data);

        return ResponseEntity.ok().body(response);
    }

}
