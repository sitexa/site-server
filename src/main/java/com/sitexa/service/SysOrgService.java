package com.sitexa.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.sitexa.entity.SysOrg;

import java.util.List;

public interface SysOrgService extends IService<SysOrg> {

    Page<SysOrg> getByPid(Page page, String pid);

    Page<SysOrg> queryByOname(Page page, String oname);

    List<SysOrg> queryOrgChildren(String oid);

    List<SysOrg> getTopOrg();

    SysOrg getRoot();
}
