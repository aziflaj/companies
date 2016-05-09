package com.aziflaj.companies.action.employee;

import com.aziflaj.companies.data.dao.EmployeeDao;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.SQLException;

public class DeleteEmployeeAction extends ActionSupport {
    private long employeeId;

    @Override
    public String execute() {
        try {
            EmployeeDao employeeDao = new EmployeeDao();
            if (employeeDao.delete(employeeDao.getById(employeeId))) {
                return SUCCESS;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ERROR;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }
}
