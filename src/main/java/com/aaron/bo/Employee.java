package com.aaron.bo;

public class Employee extends Person{
    private int id;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee(String name,int id){
        super(name);
        this.id = id;
    }
    
    /**
     * 重写equals()方法
     */
    public boolean equals(Object object){
        if(object.getClass() ==  Employee.class){
            Employee e = (Employee) object;
            return super.equals(object) && e.getId() == id;
        }
        return false;
    }
    
    public static void main(String[] args) {
        Employee e1 = new Employee("chenssy", 23);
        Employee e2 = new Employee("chenssy", 24);
        Person p1 = new Person("chenssy");
        
        System.out.println(e1.equals(p1));
        System.out.println(e2.equals(p1));
        System.out.println(e1.equals(e2));
    }
}
