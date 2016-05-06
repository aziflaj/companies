package com.aziflaj.companies.action.employee;

import com.aziflaj.companies.data.dao.EmployeeDao;
import com.aziflaj.companies.data.model.Company;
import com.aziflaj.companies.data.model.Employee;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.StrutsStatics;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class AllEmployeesAction extends ActionSupport implements StrutsStatics {
    public List<Employee> employees;

    @Override
    public String execute() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
                .get(HTTP_REQUEST);
        HttpSession session = request.getSession();
        Company company = (Company) session.getAttribute("company");

        try {
            EmployeeDao dao = new EmployeeDao();
            employees = dao.getByCompany(company);
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
