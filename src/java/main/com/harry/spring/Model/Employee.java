package com.harry.spring.Model;



public class Employee 
{
    

    private Integer id;
    private String name;
    private Integer age;
    private String dept;
    public Employee()
    {
        super();
    }
    public Employee(Integer id, String name, Integer age, String dept)
    {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.dept = dept;
    }
    public Integer getId()
    {
        return id;
    }
    public void setId(Integer id)
    {
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public Integer getAge()
    {
        return age;
    }
    public void setAge(Integer age)
    {
        this.age = age;
    }
    public String getDept()
    {
        return dept;
    }
    public void setDept(String dept)
    {
        this.dept = dept;
    }
    
   
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (age == null)
        {
            if (other.age != null)
                return false;
        } else if (!age.equals(other.age))
            return false;
        if (dept == null)
        {
            if (other.dept != null)
                return false;
        } else if (!dept.equals(other.dept))
            return false;
        if (id == null)
        {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null)
        {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
    @Override
    public String toString()
    {
        return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", dept=" + dept + "]";
    }
}