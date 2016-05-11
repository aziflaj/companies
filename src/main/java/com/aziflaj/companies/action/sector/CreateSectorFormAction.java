package com.aziflaj.companies.action.sector;

import com.aziflaj.companies.data.dao.EmployeeDao;
import com.aziflaj.companies.data.dao.RoleDao;
import com.aziflaj.companies.data.dao.SectorDao;
import com.aziflaj.companies.data.model.Employee;
import com.aziflaj.companies.data.model.Role;
import com.aziflaj.companies.data.model.Sector;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.StrutsStatics;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CreateSectorFormAction extends ActionSupport implements StrutsStatics {
    private long departmentId;
    private List<Employee> managers;
    private List<Employee> employees;

    @Override
    public String execute() {
        try {
            EmployeeDao employeeDao = new EmployeeDao();

            RoleDao roleDao = new RoleDao();
            Role managerRole = roleDao.getByName("Manager");
            SectorDao sectorDao = new SectorDao();
            Sector sectorless = sectorDao.getByName("sectorless");
            System.out.println(sectorless.getName() + " fetched");

            managers = new ArrayList<>();
            employees = new ArrayList<>();
            for (Employee e : employeeDao.all()) {
                if (e.getSector().getId() == sectorless.getId()) {
                    if (e.getRole().getId() == managerRole.getId()) {
                        managers.add(e);
                    } else {
                        employees.add(e);
                    }
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
