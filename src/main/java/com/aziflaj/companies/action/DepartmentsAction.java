package com.aziflaj.companies.action;

import com.aziflaj.companies.db.DbConnector;
import com.aziflaj.companies.db.model.Company;
import com.aziflaj.companies.db.model.Department;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.StrutsStatics;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        String departmentsSql = "SELECT id, name FROM departments WHERE company_id = ?;";

        try {
            Connection connection = DbConnector.getConnection();
            if (connection == null) {
                return ERROR;
            }

            PreparedStatement statement = connection.prepareStatement(departmentsSql);
            statement.setLong(1, company.getId());
            ResultSet rs = statement.executeQuery();
            departments = new ArrayList<>();
            while (rs.next()) {
                departments.add(new Department(rs.getLong("id"),
                        rs.getString("name"),
                        company));
            }
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
