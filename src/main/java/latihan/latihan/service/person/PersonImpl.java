package latihan.latihan.service.person;

import latihan.latihan.model.Person;
import latihan.latihan.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }
}
