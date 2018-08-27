package latihan.latihan.controller.person;

import latihan.latihan.model.Person;
import latihan.latihan.model.dto.person.ListPersonDto;

import java.util.ArrayList;
import java.util.List;

public class PersonMapper {

    public static List<ListPersonDto> toPersonDao(List<Person> person) {
        List<ListPersonDto> dto = new ArrayList<>();

        for (int i = 0; i < person.size(); i++) {
            ListPersonDto personDto = new ListPersonDto();
            personDto.setPersonName(person.get(i).getPersonName());
            personDto.setPersonAge(person.get(i).getPersonAge());
            personDto.setPersonAddress(person.get(i).getPersonAddress());
            personDto.setPersonPhoneNumber(person.get(i).getPersonPhoneNumber());
            personDto.setPersonBirthday(person.get(i).getPersonBirthday());

            dto.add(personDto);
        }

        return dto;
    }
}
