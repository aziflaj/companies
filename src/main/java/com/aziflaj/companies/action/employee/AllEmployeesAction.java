package com.aziflaj.companies.action.employee;

import com.aziflaj.companies.data.dao.EmployeeDao;
import com.aziflaj.companies.data.model.Employee;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.StrutsStatics;

import java.sql.SQLException;
import java.util.List;

public class AllEmployeesAction extends ActionSupport implements StrutsStatics {
    public List<Employee> employees;

    @Override
    public String execute() {
        try {
            EmployeeDao dao = new EmployeeDao();
            employees = dao.all();
            return SUCCESS;
        } catch (SQLException e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
