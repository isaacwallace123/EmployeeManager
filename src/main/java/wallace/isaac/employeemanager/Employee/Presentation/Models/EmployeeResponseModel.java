package wallace.isaac.employeemanager.Employee.Presentation.Models;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
public class EmployeeResponseModel extends RepresentationModel<EmployeeResponseModel> {
    private String employeeid;

    private String first_name;
    private String last_name;
}
