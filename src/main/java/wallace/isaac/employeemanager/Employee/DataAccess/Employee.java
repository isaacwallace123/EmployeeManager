package wallace.isaac.employeemanager.Employee.DataAccess;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private EmployeeIdentifier employeeIdentifier;

    private String first_name;
    private String last_name;

    private Date dob;

    private String email;
    private String title;
    private Double salary;

    public Employee(String first_name, String last_name, Date dob, String email, String title, Double salary) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.dob = dob;
        this.email = email;
        this.title = title;
        this.salary = salary;
    }
}
