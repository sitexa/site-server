package com.sitexa.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.sitexa.dao.SysOrgMapper;
import com.sitexa.entity.SysOrg;
import com.sitexa.service.SysOrgService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysOrgServiceImpl extends ServiceImpl<SysOrgMapper, SysOrg> implements SysOrgService {

    @Override
    public Page<SysOrg> getByPid(Page page, String pid) {
        return page.setRecords(baseMapper.getOrgByPid(page,pid));
    }

    @Override
    public Page<SysOrg> queryByOname(Page page, String oname) {
        return page.setRecords(baseMapper.queryByOname(page,oname));
    }

    @Override
    public List<SysOrg> queryOrgChildren(String oid) {
        return baseMapper.queryOrgChildren(oid);
    }

    @Override
    public List<SysOrg> getTopOrg() {
        return baseMapper.getTopOrg();
    }

    @Override
    public SysOrg getRoot() {
        return baseMapper.getRoot();
    }


}
