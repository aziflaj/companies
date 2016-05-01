package com.aziflaj.companies.action;

import com.aziflaj.companies.data.dao.DepartmentDao;
import com.aziflaj.companies.data.dao.SectorDao;
import com.aziflaj.companies.data.model.Sector;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.SQLException;
import java.util.List;

public class SectorAction extends ActionSupport {
    private Long departmentId;
    private List<Sector> sectors;

    @Override
    public String execute() {
        try {
            DepartmentDao departmentDao = new DepartmentDao();
            SectorDao sectorDao = new SectorDao();
            sectors = sectorDao.getByDepartment(departmentDao.getById(departmentId));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public List<Sector> getSectors() {
        return sectors;
    }

}
