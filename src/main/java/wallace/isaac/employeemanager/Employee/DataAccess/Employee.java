package wallace.isaac.employeemanager.Employee.DataAccess;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

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

    public Employee(@NotNull String first_name, @NotNull String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }
}
