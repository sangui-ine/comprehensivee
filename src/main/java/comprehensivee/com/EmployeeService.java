package comprehensivee.com;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import comprehensivee.com.exceptionhandler.EmployeeAlreadyExit;

@Service
public class EmployeeService  {
	@Autowired
	private repo repository;
	public Employee addEmployee(Employee e)throws EmployeeAlreadyExit{
		Employee existingEmp =repository.findById(e.getId()).orElse(null);
		if(existingEmp!= null) {
			throw new EmployeeAlreadyExit("Employee already exit in database");
		}
		else {
			return repository.save(e);
		}
	}
	public List<Employee> getAllEmployee() {
		return repository.findAll();
	}
	public Employee getById(int id)throws UserNotFoundException{
		Employee emp= repository.findById(id).orElse(null);
		if(emp!=null) {
			return emp;
		}
		else {
			throw new UserNotFoundException("user not found with id");
	}	

	}
	
	public String deleteEmployee(int id) {
		repository.deleteById(id);
		return "Employee with employee id " + id + " has been deleted.";
	}

	public Employee editEmployee(Employee e) {
		Employee existingEmployee = repository.findById(e.getId()).orElse(null);
		existingEmployee.setName(e.getName());
		existingEmployee.setSalary(e.getSalary());
		return repository.save(existingEmployee);
	}
	
	public Employee editEmployeeBySalary(int id, int salary) {
		Employee emp = repository.findById(id).orElse(null);
		emp.setSalary(salary);
		return repository.save(emp);	
	
}

	public List<Employee> getAllEmployeesInDescendingOrderBySalary() {
		List<Employee>list=repository.findAll().stream().sorted(Comparator.comparing(Employee::getSalary)
				.reversed()).collect(Collectors.toList());
		list.forEach(emp ->System.out.println("Id:"+emp.getId()+"Name:"+emp.getName()+
				"salary:"+emp.getSalary()+"Designation:"+emp.getDesignation()));
		return list;
	}
	
	
	
	
}