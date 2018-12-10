package com.sitexa.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.sitexa.entity.SysOrg;

public interface SysOrgService extends IService<SysOrg> {

    Page<SysOrg> getByPid(Page page, String pid);

    Page<SysOrg> queryByOname(Page page, String oname);

}
