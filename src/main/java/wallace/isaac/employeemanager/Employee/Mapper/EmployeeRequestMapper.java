package wallace.isaac.employeemanager.Employee.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import wallace.isaac.employeemanager.Employee.DataAccess.Employee;
import wallace.isaac.employeemanager.Employee.DataAccess.EmployeeIdentifier;
import wallace.isaac.employeemanager.Employee.Presentation.Models.EmployeeRequestModel;

@Mapper(componentModel = "spring")
public interface EmployeeRequestMapper {
    @Mapping(target = "id", ignore = true)
    Employee requestModelToEntity(EmployeeRequestModel postRequestModel, EmployeeIdentifier postIdentifier);
}
