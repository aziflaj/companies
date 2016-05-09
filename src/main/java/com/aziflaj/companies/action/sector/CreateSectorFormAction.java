package com.aziflaj.companies.action.sector;

import com.aziflaj.companies.data.dao.EmployeeDao;
import com.aziflaj.companies.data.dao.RoleDao;
import com.aziflaj.companies.data.model.Company;
import com.aziflaj.companies.data.model.Employee;
import com.aziflaj.companies.data.model.Role;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.StrutsStatics;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CreateSectorFormAction extends ActionSupport implements StrutsStatics {
    private long departmentId;
    private List<Employee> managers;

    @Override
    public String execute() {
        HttpServletRequest request =
                (HttpServletRequest) ActionContext.getContext().get(HTTP_REQUEST);

        HttpSession session = request.getSession();
        Company company = (Company) session.getAttribute("company");

        try {
            RoleDao roleDao = new RoleDao();
            EmployeeDao employeeDao = new EmployeeDao();
            Role managerRole = roleDao.getByName("manager");
            managers = new ArrayList<>();

            for (Employee e : employeeDao.getByCompany(company)) {
                if (e.getRole().getId() == managerRole.getId()) {
                    managers.add(e);
                }
            }

            return SUCCESS;
        } catch (SQLException e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public List<Employee> getManagers() {
        return managers;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }
}
