package wallace.isaac.employeemanager.Employee.Business;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import wallace.isaac.employeemanager.Employee.DataAccess.Employee;
import wallace.isaac.employeemanager.Employee.DataAccess.EmployeeIdentifier;
import wallace.isaac.employeemanager.Employee.DataAccess.EmployeeRepository;
import wallace.isaac.employeemanager.Employee.Mapper.EmployeeRequestMapper;
import wallace.isaac.employeemanager.Employee.Mapper.EmployeeResponseMapper;
import wallace.isaac.employeemanager.Employee.Presentation.Models.EmployeeRequestModel;
import wallace.isaac.employeemanager.Employee.Presentation.Models.EmployeeResponseModel;
import wallace.isaac.employeemanager.Utils.Exceptions.InUseException;
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

    public EmployeeResponseModel addEmployee(EmployeeRequestModel employeeRequestModel) {
        Employee newEmployee = this.employeeRequestMapper.requestModelToEntity(employeeRequestModel, new EmployeeIdentifier());

        return employeeResponseMapper.entityToResponseModel(newEmployee);
    }

    public EmployeeResponseModel editEmployee(String employeeid, EmployeeRequestModel employeeRequestModel) {
        Employee employee = this.employeeRepository.findEmployeeByEmployeeIdentifier_Employeeid(employeeid);

        if (employee == null) {
            throw new InvalidInputException("Unknown employeeid: " + employeeid);
        }

        Employee updatedEmployee = this.employeeRequestMapper.requestModelToEntity(employeeRequestModel, employee.getEmployeeIdentifier());

        this.employeeRepository.save(updatedEmployee);

        return this.employeeResponseMapper.entityToResponseModel(updatedEmployee);
    }

    public void deleteEmployee(String employeeid) {
        Employee employee = this.employeeRepository.findEmployeeByEmployeeIdentifier_Employeeid(employeeid);

        if (employee == null) {
            throw new InvalidInputException("Unknown employeeid: " + employeeid);
        }

        try {
            this.employeeRepository.delete(employee);
        } catch(DataIntegrityViolationException exception) {
            throw new InUseException("Employee is in use by another entity, currently cannot delete.");
        }
    }
}
