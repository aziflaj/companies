package com.aziflaj.companies.action;

import com.aziflaj.companies.data.dao.RoleDao;
import com.aziflaj.companies.data.model.Role;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.SQLException;
import java.util.List;

public class AddSectorFormAction extends ActionSupport {
    private RoleDao roleDao;
    private List<Role> roles;

    @Override
    public String execute() {
        try {
            roleDao = new RoleDao();
            roles = roleDao.all();
        } catch (SQLException e) {
            e.printStackTrace();
            return "404";
        }
        return SUCCESS;
    }


    public List<Role> getRoles() {
        return roles;
    }
}
