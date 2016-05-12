package com.aziflaj.companies.action.sector;

import com.aziflaj.companies.data.dao.EmployeeDao;
import com.aziflaj.companies.data.dao.SectorDao;
import com.aziflaj.companies.data.model.Employee;
import com.aziflaj.companies.data.model.Sector;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.SQLException;
import java.util.List;

public class DeleteSectorAction extends ActionSupport {
    private long sectorId;

    @Override
    public String execute() throws SQLException {
        EmployeeDao employeeDao = new EmployeeDao();
        List<Employee> employees = employeeDao.all();
        SectorDao sectorDao = new SectorDao();
        Sector deletedSector = sectorDao.getById(sectorId);
        Sector sectorless = sectorDao.getByName("sectorless");

        for (Employee e : employees) {
            if (e.getSector().getId() == deletedSector.getId()) {
                e.setSector(sectorless);
                employeeDao.update(e);
            }
        }

        return sectorDao.delete(deletedSector) ? SUCCESS : ERROR;
    }

    public void setSectorId(long sectorId) {
        this.sectorId = sectorId;
    }
}
