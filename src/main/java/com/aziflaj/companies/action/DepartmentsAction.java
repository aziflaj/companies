package com.aziflaj.companies.action;

import com.aziflaj.companies.data.dao.DepartmentDao;
import com.aziflaj.companies.data.model.Company;
import com.aziflaj.companies.data.model.Department;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.StrutsStatics;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class DepartmentsAction extends ActionSupport implements StrutsStatics {
    private static final Logger LOGGER = LogManager.getLogger(DepartmentsAction.class);
    private List<Department> departments;

    @Override
    public String execute() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
                .get(HTTP_REQUEST);
        HttpSession session = request.getSession();
        Company company = (Company) session.getAttribute("company");

        try {
            DepartmentDao departmentDao = new DepartmentDao();
            departments = departmentDao.getByCompany(company);
            return SUCCESS;
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.error(e);
            return ERROR;
        }
    }

    public List<Department> getDepartments() {
        return departments;
    }
}
