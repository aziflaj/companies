package com.aziflaj.companies;

import com.aziflaj.companies.action.IndexAction;
import com.opensymphony.xwork2.Action;
import junit.framework.TestCase;

public class IndexActionTest extends TestCase {

    public void testIndexAction() throws Exception {
        IndexAction action = new IndexAction();
        String result = action.execute();
        assertEquals(Action.SUCCESS, result);
    }
}
