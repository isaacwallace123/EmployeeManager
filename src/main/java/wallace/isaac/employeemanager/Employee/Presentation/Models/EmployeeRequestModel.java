package wallace.isaac.employeemanager.Employee.Presentation.Models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import org.springframework.hateoas.RepresentationModel;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class EmployeeRequestModel extends RepresentationModel<EmployeeRequestModel> {
    String first_name;
    String last_name;
}
