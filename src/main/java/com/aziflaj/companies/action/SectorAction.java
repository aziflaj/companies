package com.aziflaj.companies.action;

import com.aziflaj.companies.data.dao.DepartmentDao;
import com.aziflaj.companies.data.dao.SectorDao;
import com.aziflaj.companies.data.model.Company;
import com.aziflaj.companies.data.model.Department;
import com.aziflaj.companies.data.model.Sector;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.StrutsStatics;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class SectorAction extends ActionSupport implements StrutsStatics {
    private Long departmentId;
    private List<Sector> sectors;

    @Override
    public String execute() {
        try {
            HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
                    .get(HTTP_REQUEST);
            HttpSession session = request.getSession();
            Company company = (Company) session.getAttribute("company");

            DepartmentDao departmentDao = new DepartmentDao();
            Department department = departmentDao.getById(departmentId);

            if (company.getId() == department.getCompany().getId()) {
                SectorDao sectorDao = new SectorDao();
                sectors = sectorDao.getByDepartment(department);
            } else {
                return "404";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return ERROR;
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
