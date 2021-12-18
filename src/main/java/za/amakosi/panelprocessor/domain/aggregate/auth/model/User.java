package za.amakosi.panelprocessor.domain.aggregate.auth.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class User {
    private String id;
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private boolean enabled;
    private String contactNumber;
    private Date creationDate;
}
