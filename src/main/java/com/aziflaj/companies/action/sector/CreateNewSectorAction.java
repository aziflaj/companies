package com.aziflaj.companies.action.sector;

import com.opensymphony.xwork2.ActionSupport;

public class CreateNewSectorAction extends ActionSupport {
    private String sectorName;

    @Override
    public String execute() {

        return SUCCESS;
    }

//    @Override
//    public void validate() {
//        // TODO: validate
//    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

}
