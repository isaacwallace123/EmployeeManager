package wallace.isaac.employeemanager.Employee.Presentation;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wallace.isaac.employeemanager.Employee.Business.EomployeeService;
import wallace.isaac.employeemanager.Employee.Presentation.Models.EmployeeRequestModel;
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

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponseModel> AddUser(@RequestBody EmployeeRequestModel employeeRequestModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.employeeService.addEmployee(employeeRequestModel));
    }
}
