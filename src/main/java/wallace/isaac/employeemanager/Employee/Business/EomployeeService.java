package wallace.isaac.employeemanager.Employee.Business;

import wallace.isaac.employeemanager.Employee.Presentation.Models.EmployeeResponseModel;

import java.util.List;

public interface EomployeeService {
    public List<EmployeeResponseModel> getAllEmployees();
    public EmployeeResponseModel getEmployeeById(String employeeid);
}
