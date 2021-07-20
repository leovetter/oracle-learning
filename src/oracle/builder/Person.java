package oracle.builder;

public class Person implements Comparable<Person> {

	private Integer id;
	private String name;
	private Integer age;
	private String email;
	private String location;
	
	public Person(Builder builder) { 
        this.id = builder.id; 
        this.name = builder.name; 
        this.age = builder.age; 
        this.email = builder.email;
        this.location = builder.location;
    } 
	
	public static Builder builder() {
		return new Builder();
	}
	
	// Static class Builder 
    public static class Builder { 
    
    	private Integer id;
    	private String name;
    	private Integer age;
    	private String email;
    	private String location;
  
        private Builder() {} 
  
        // Setter methods 
        public Builder setId(int i) { 
            this.id = i; 
            return this; 
        } 
        
        public Builder setName(String name) { 
            this.name = name; 
            return this; 
        } 
        
        public Builder setAge(Integer age) { 
            this.age = age; 
            return this; 
        } 
        
        public Builder setEmail(String email) { 
            this.email = email; 
            return this;
        } 
        
        public Builder setLocation(String location) { 
            this.location = location; 
            return this;
        } 
        
        // build method to deal with outer class 
        // to return outer instance 
        public Person build() 
        { 
            return new Person(this); 
        }
    }
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public String getEmail() {
		return email;
	}

	public String getLocation() {
		return location;
	}

	public void printPerson() {
		System.out.println("Person [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", location=" + location
				+ "]");
	}

	@Override
	public int compareTo(Person p) {
		
		int result = this.name.compareTo(p.getName());
		
		if(result > 0) return 1;
		if(result < 0) return -1;
		return 0;		
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", location=" + location
				+ "]";
	}
}
