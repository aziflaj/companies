package com.aziflaj.companies;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.conversion.annotations.Conversion;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Conversion()
public class IndexAction extends ActionSupport {
    public static final Logger LOGGER = LogManager.getLogger(IndexAction.class);

    public String execute() throws Exception {
        LOGGER.debug("REQUIRE LOGIN");
        return SUCCESS;
    }
}
