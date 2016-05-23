package com.aziflaj.companies.action.employee;

import com.aziflaj.companies.data.dao.EmployeeDao;
import com.aziflaj.companies.data.dao.RoleDao;
import com.aziflaj.companies.data.dao.SectorDao;
import com.aziflaj.companies.data.model.Company;
import com.aziflaj.companies.data.model.Employee;
import com.aziflaj.companies.data.model.Role;
import com.aziflaj.companies.data.model.Sector;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.StrutsStatics;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class UpdateEmployeeFormAction extends ActionSupport implements StrutsStatics {
    private long employeeId;
    private String fullName;
    private String socialSecurityNumber;
    private String email;

    private List<Sector> sectors;
    private List<Role> roles;
    private long sectorId, roleId;

    @Override
    public String execute() throws SQLException {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
                .get(HTTP_REQUEST);
        HttpSession session = request.getSession();
        Company company = (Company) session.getAttribute("company");

        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee = employeeDao.getById(employeeId);
        fullName = employee.getFullName();
        socialSecurityNumber = employee.getSocialSecurityNumber();
        email = employee.getEmail();

        sectors = (new SectorDao()).getByCompany(company);
        roles = (new RoleDao()).all();


        sectorId = employee.getSector().getName().equals("sectorless") ? -1 : employee.getSector().getId();
        roleId = employee.getRole().getId();
        return SUCCESS;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public String getEmail() {
        return email;
    }

    public List<Sector> getSectors() {
        return sectors;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public long getSectorId() {
        return sectorId;
    }

    public long getRoleId() {
        return roleId;
    }
}
