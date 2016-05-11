package com.aziflaj.companies.action.sector;

import com.aziflaj.companies.data.dao.DepartmentDao;
import com.aziflaj.companies.data.dao.EmployeeDao;
import com.aziflaj.companies.data.dao.OfficeDao;
import com.aziflaj.companies.data.dao.SectorDao;
import com.aziflaj.companies.data.model.Employee;
import com.aziflaj.companies.data.model.Sector;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.StrutsStatics;

import java.sql.SQLException;

public class CreateSectorAction extends ActionSupport implements StrutsStatics {
    private String sectorName;
    private long managerId;
    private long departmentId;
    private long[] employeeIds;

    @Override
    public String execute() {
        try {
            SectorDao sectorDao = new SectorDao();
            DepartmentDao departmentDao = new DepartmentDao();
            EmployeeDao employeeDao = new EmployeeDao();

            Sector sector = new Sector(-1,
                    sectorName,
                    (new OfficeDao()).all().get(0),
                    departmentDao.getById(departmentId));

            sector = sectorDao.insert(sector);
            System.out.println("Sector inserted w/ id " + sector.getId());

            Employee manager = employeeDao.getById(managerId);
            manager.setSector(sector);
            if (employeeDao.update(manager)) {
                System.out.println("updated manager");
            }

            for (long id : employeeIds) {
                Employee employee = employeeDao.getById(id);
                employee.setSector(sector);
                employeeDao.update(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return ERROR;
        }

        return SUCCESS;
    }

    @Override
    public void validate() {
        if (managerId < 0) {
            addFieldError("managerId", "Zgjidh nje menaxher");
            System.out.println("Zgjidh nje menaxher");
        }

        if (sectorName == null || StringUtils.isEmpty(sectorName)) {
            addFieldError("sectorName", "Mos harro emrin e sektorit");
            System.out.println("Mos harro emrin e sektorit");
        }

        if (employeeIds.length < 4) {
            addFieldError("employeeIds", "Te pakten 4 punonjes");
        }
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public void setManagerId(long managerId) {
        this.managerId = managerId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public void setEmployeeIds(long[] employeeIds) {
        this.employeeIds = employeeIds;
    }
}
