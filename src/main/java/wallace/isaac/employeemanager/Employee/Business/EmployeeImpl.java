package wallace.isaac.employeemanager.Employee.Business;

import org.springframework.stereotype.Service;
import wallace.isaac.employeemanager.Employee.DataAccess.Employee;
import wallace.isaac.employeemanager.Employee.DataAccess.EmployeeRepository;
import wallace.isaac.employeemanager.Employee.Mapper.EmployeeRequestMapper;
import wallace.isaac.employeemanager.Employee.Mapper.EmployeeResponseMapper;
import wallace.isaac.employeemanager.Employee.Presentation.Models.EmployeeRequestModel;
import wallace.isaac.employeemanager.Employee.Presentation.Models.EmployeeResponseModel;
import wallace.isaac.employeemanager.Utils.Exceptions.InvalidInputException;

import java.util.List;

@Service
public class EmployeeImpl implements EomployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeResponseMapper employeeResponseMapper;
    private final EmployeeRequestMapper employeeRequestMapper;

    public EmployeeImpl(EmployeeRepository employeeRepository, EmployeeResponseMapper employeeResponseMapper, EmployeeRequestMapper employeeRequestMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeResponseMapper = employeeResponseMapper;
        this.employeeRequestMapper = employeeRequestMapper;
    }

    public List<EmployeeResponseModel> getAllEmployees() {
        return this.employeeResponseMapper.entityListToResponseModelList(this.employeeRepository.findAll());
    }

    public EmployeeResponseModel getEmployeeById(String employeeid) {
        Employee employee = this.employeeRepository.findEmployeeByEmployeeIdentifier_Employeeid(employeeid);

        if (employee == null) {
            throw new InvalidInputException("Unknown userId: " + employeeid);
        }

        return this.employeeResponseMapper.entityToResponseModel(employee);
    }
}
