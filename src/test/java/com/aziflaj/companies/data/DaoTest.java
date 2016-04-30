package com.aziflaj.companies.data;

import com.aziflaj.companies.data.dao.CompanyDao;
import com.aziflaj.companies.data.model.Company;
import junit.framework.TestCase;

import java.sql.SQLException;

public class DaoTest extends TestCase {

    public void testCompanyDao() {
        try {
            CompanyDao dao = new CompanyDao();

            // TEST INSERTION
            int count = dao.all().size();
            Company c = new Company(-1,
                    "a77788899b",
                    "testname",
                    "somewhere",
                    "testmail@email.com",
                    "password");

            c = dao.insert(c);
            int countAfterInsert = dao.all().size();
            assertEquals("CompanyDao#insert should add a new company",
                    count + 1, countAfterInsert);
            assertFalse("Id after insertion shouldn't be -1", c.getId() == -1);

            // TEST UPDATING
            c.setEmail("otherTestMail@mail.com");
            if (dao.update(c)) {
                Company testCompany = dao.getById(c.getId());
                assertEquals("CompanyDao#update should update the company",
                        c.getEmail(), testCompany.getEmail());
            } else {
                fail("CompanyDao#update should update the company");
            }

            // TEST DELETION
            if (dao.delete(c)) {
                int countAfterDelete = dao.all().size();
                assertEquals("CompanyDao#delete should delete the company",
                        countAfterInsert - 1, countAfterDelete);
            } else {
                fail("CompanyDao#delete should delete the company");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            assertFalse("Exception thrown while testing CompanyDao", true);
        }
    }
}
