package com.aziflaj.companies.action.employee;

import com.aziflaj.companies.data.dao.RoleDao;
import com.aziflaj.companies.data.dao.SectorDao;
import com.aziflaj.companies.data.model.Company;
import com.aziflaj.companies.data.model.Role;
import com.aziflaj.companies.data.model.Sector;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.StrutsStatics;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class CreateEmployeeFormAction extends ActionSupport implements StrutsStatics {
    private List<Role> roles;
    private List<Sector> sectors;

    @Override
    public String execute() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
                .get(HTTP_REQUEST);
        HttpSession session = request.getSession();
        Company company = (Company) session.getAttribute("company");

        try {
            RoleDao roleDao = new RoleDao();
            roles = roleDao.all();

            SectorDao sectorDao = new SectorDao();
            sectors = sectorDao.getByCompany(company);
        } catch (SQLException e) {
            e.printStackTrace();
            return "404";
        }
        return SUCCESS;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public List<Sector> getSectors() {
        return sectors;
    }
}
