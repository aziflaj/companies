package com.aziflaj.companies.action.employee;

import com.aziflaj.companies.data.dao.EmployeeDao;
import com.aziflaj.companies.data.model.Employee;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.StrutsStatics;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AllEmployeesAction extends ActionSupport implements StrutsStatics {
    public List<Employee> employees;
    public List<Employee> unassigned;

    @Override
    public String execute() {
        try {
            employees = new ArrayList<>();
            unassigned = new ArrayList<>();

            EmployeeDao dao = new EmployeeDao();
            for (Employee e : dao.all()) {
                if (e.getSector().getName().equals("sectorless")) {
                    unassigned.add(e);
                } else {
                    employees.add(e);
                }
            }
            return SUCCESS;
        } catch (SQLException e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Employee> getUnassigned() {
        return unassigned;
    }
}
