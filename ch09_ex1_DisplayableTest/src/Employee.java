public class Employee implements DepartmentConstants, Displayable {

	private int department;
	private String firstName;
	private String lastName;

	public Employee(int department, String lastName, String firstName) {
		this.department = department;
		this.lastName = lastName;
		this.firstName = firstName;
	}

	@Override
	public String toString() {
		String dept = "Unknown";
		if (department == Admin) {
			dept = "Administration ";
		} else if (department == Editorial) {
			dept = "Editorial";
		} else if (department == Marketing) {
			dept = "Marketing";

		}
		return firstName + " " + lastName + " (" + dept + ")";

	}
}