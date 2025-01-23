package wallace.isaac.employeemanager.Employee.Presentation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wallace.isaac.employeemanager.Employee.Business.EomployeeService;
import wallace.isaac.employeemanager.Employee.Presentation.Models.EmployeeResponseModel;

import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {
    private final EomployeeService employeeService;

    public EmployeeController(EomployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public ResponseEntity<List<EmployeeResponseModel>> GetEmployees() {
        return ResponseEntity.status(HttpStatus.OK).body(this.employeeService.getAllEmployees());
    }

    @GetMapping("{employeeid}")
    public ResponseEntity<EmployeeResponseModel> GetEmployee(@PathVariable String employeeid) {
        return ResponseEntity.status(HttpStatus.OK).body(this.employeeService.getEmployeeById(employeeid));
    }
}
