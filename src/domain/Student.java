package domain;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
	private String id;
	private String name;
	private Map<Term, Map<Course, Double>> transcript;
	private List<CourseSection> currentTerm;

	static class CourseSection {
		Course course;
	    int section;

        public CourseSection(Course course, int section) {
            this.course = course;
            this.section = section;
        }
    }

	public Student(String id, String name) {
		this.id = id;
		this.name = name;
		this.transcript = new HashMap<>();
		this.currentTerm = new ArrayList<>();
	}
	
	public void takeCourse(Course c, int section) {
		this.currentTerm.add(new CourseSection(c, section));
	}

	public Map<Term, Map<Course, Double>> getTranscript() {
		return this.transcript;
	}

	public void addTranscriptRecord(Course course, Term term, double grade) {
	    if (!this.transcript.containsKey(term)) {
	        this.transcript.put(term, new HashMap<>());
		}

	    this.transcript.get(term).put(course, grade);
    }

    public List<CourseSection> getCurrentTerm() {
        return this.currentTerm;
    }

    public String getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}
	
	public String toString() {
		return this.name;
	}
}
