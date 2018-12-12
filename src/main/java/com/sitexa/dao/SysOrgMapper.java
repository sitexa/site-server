package com.sitexa.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.sitexa.entity.SysOrg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysOrgMapper extends BaseMapper<SysOrg> {

    List<SysOrg> getOrgByPid(Page page, @Param("pid")String pid);

    List<SysOrg> queryByOname(Page page,@Param("oname")String oname);

    List<SysOrg> queryOrgChildren(@Param("oid")String oid);

    List<SysOrg> getTopOrg();

    SysOrg getRoot();

}
