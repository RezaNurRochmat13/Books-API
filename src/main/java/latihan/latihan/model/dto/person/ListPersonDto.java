package latihan.latihan.model.dto.person;


import lombok.Data;

import java.util.Date;

@Data
public class ListPersonDto {

    private String personName;
    private String personAge;
    private String personAddress;
    private String personPhoneNumber;
    private Date personBirthday;
}
