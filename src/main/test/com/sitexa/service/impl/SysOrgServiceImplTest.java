package com.sitexa.service.impl;

import com.sitexa.entity.SysOrg;
import com.sitexa.service.SysOrgService;
import org.junit.Test;

import static org.junit.Assert.*;

public class SysOrgServiceImplTest {

    SysOrgService sysOrgService ;

    public SysOrgServiceImplTest(){
        sysOrgService = new SysOrgServiceImpl();
    }

    @Test
    public void add(){
        SysOrg org = new SysOrg();
        org.setOid("1001");
        org.setOname("a unit");
        org.setOaddr("a address");
        org.setOlevel(2);
        org.setOtype("2");

        sysOrgService.insert(org);

    }

    @Test
    public void getByPid() {
        SysOrg org = new SysOrg();
    }

    @Test
    public void queryByOname() {
    }
}