package com.harry.spring.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.harry.spring.Dao.EmployeeDAO;
import com.harry.spring.Model.Employee;
import com.harry.spring.Constants.SQLConstants;

public class EmployeeDAOImpl implements EmployeeDAO
{

    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    
    public void saveEmployee(Employee employee)
    {
//        String sql = "insert into Employee values(?,?,?,?)";
    	String sql = SQLConstants.INSERT_RECORD;

        jdbcTemplate.update(sql, new Object[]
        { employee.getId(), employee.getName(), employee.getDept(), employee.getAge() });
    }

    // Getting a particular Employee's ID for Editing the Employee record
    public Employee getEmployeeById(int id)
    {
    	
    	System.out.println("ID in IMPL is:- "+id);
        String sql = SQLConstants.SELECT_RECORD_USING_ID;
        Employee employee = (Employee) jdbcTemplate.queryForObject(sql, new Object[]
        { id }, new RowMapper()
        {
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException
            {
                Employee employee = new Employee();
                employee.setId(rs.getInt(1));
                employee.setName(rs.getString(2));
                employee.setDept(rs.getString(3));
                employee.setAge(rs.getInt(4));
               
                return employee;
            }
        });
        return employee;
    }
    
    

    // Getting all the Employees record for Displaying
    public List<Employee> getAllEmployees()
    {
        String sql = SQLConstants.SELECT_RECORDS;

        List<Employee> employeeList = jdbcTemplate.query(sql, new ResultSetExtractor<List<Employee>>()
        {
            @Override
            public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException
            {
                List<Employee> list = new ArrayList<Employee>();
                while (rs.next())
                {
                    Employee employee = new Employee();
                    employee.setId(rs.getInt(1));
                    employee.setName(rs.getString(2));
                    employee.setDept(rs.getString(3));
                    employee.setAge(rs.getInt(4));
                    
                    list.add(employee);
                }
                return list;
            }

        });
        return employeeList;
    }

    // Updation a particular Employee record
    public void updateEmployee(Employee employee)
    {
        String sql = SQLConstants.UPDATE_RECORDS;
        jdbcTemplate.update(sql, new Object[]
        { employee.getAge(), employee.getDept(), employee.getName(), employee.getId() });
    }

    // Deleting of a particular Employee
    public void deleteEmployee(int id)
    {
        String sql = SQLConstants.DELETE_RECORDS;
        jdbcTemplate.update(sql, new Object[]
        { id });
    }


	
}