package lk.ijse.dep.web.pos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String firstAddress;
    private String lastAddress;
    private String contact;
}
