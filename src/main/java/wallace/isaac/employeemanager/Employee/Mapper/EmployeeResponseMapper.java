package wallace.isaac.employeemanager.Employee.Mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.hateoas.Link;
import wallace.isaac.employeemanager.Employee.DataAccess.Employee;
import wallace.isaac.employeemanager.Employee.Presentation.EmployeeController;
import wallace.isaac.employeemanager.Employee.Presentation.Models.EmployeeResponseModel;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Mapper(componentModel = "spring")
public interface EmployeeResponseMapper {
    @Mapping(expression = "java(employee.getEmployeeIdentifier().getEmployeeid())", target = "employeeid")

    EmployeeResponseModel entityToResponseModel(Employee employee);
    List<EmployeeResponseModel> entityListToResponseModelList(List<Employee> employees);

    @AfterMapping
    default void addLinks(@MappingTarget EmployeeResponseModel postResponseModel, Employee employee) {
        Link selfLink = linkTo(methodOn(EmployeeController.class).GetEmployee(employee.getEmployeeIdentifier().getEmployeeid())).withSelfRel();
        postResponseModel.add(selfLink);

        Link allLink = linkTo(methodOn(EmployeeController.class).GetEmployees()).withRel("employees");
        postResponseModel.add(allLink);
    }
}
