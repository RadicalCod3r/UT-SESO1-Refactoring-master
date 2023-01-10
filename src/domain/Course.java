package domain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Course {
	private String id;
	private String name;
	private int units;
	private List<Course> prerequisites;

	public Course(String id, String name, int units) {
		this.id = id;
		this.name = name;
		this.units = units;
		this.prerequisites = new ArrayList<Course>();
	}

	public Course withPre(Course... pres) {
		this.prerequisites.addAll(Arrays.asList(pres));
		return this;
	}

	public List<Course> getPrerequisites() {
		return this.prerequisites;
	}

	public void addPre(Course c) {
		this.getPrerequisites().add(c);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		sb.append(" {");
		for (Course pre : this.getPrerequisites()) {
			sb.append(pre.getName());
			sb.append(", ");
		}
		sb.append("}");
		return sb.toString();
	}

	public String getName() {
		return this.name;
	}

	public int getUnits() {
		return this.units;
	}

	public String getId() {
		return this.id;
	}

	public boolean equals(Object obj) {
		Course other = (Course)obj;
		return this.id.equals(other.id);
	}
}
