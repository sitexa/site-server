package com.sitexa.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.sitexa.annotation.PermInfo;
import com.sitexa.entity.SysOrg;
import com.sitexa.service.SysOrgService;
import com.sitexa.util.OrgTree;
import com.sitexa.util.PageUtils;
import com.sitexa.vo.Json;
import com.sitexa.vo.OrgNode;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@PermInfo(value = "组织机构模块")
@RequiresPermissions("a:sys:org")
@RestController
@RequestMapping("/sys_org")
public class SysOrgController {

    private static final Logger log = LoggerFactory.getLogger(SysOrgController.class);

    @Autowired
    private SysOrgService sysOrgService;

    @PermInfo("添加组织机构")
    @RequiresPermissions("a:sys:org:add")
    @PostMapping
    public Json add(@RequestBody String body) {

        String oper = " add sys org";
        SysOrg org = JSON.parseObject(body, SysOrg.class);

        if (StringUtils.isEmpty(org.getOname())) {
            return Json.fail(oper, "组织机构名称不能为空");
        }

        SysOrg orgDB = sysOrgService.selectOne(new EntityWrapper<SysOrg>().eq("oname", org.getOname()));
        if (orgDB != null) {
            return Json.fail(oper, "组织机构已存在");
        }

        SysOrg orgDB1 = sysOrgService.selectOne(new EntityWrapper<SysOrg>().eq("ocode", org.getOcode()));
        if (orgDB1 != null) {
            return Json.fail(oper, "组织机构已存在");
        }

        boolean success = sysOrgService.insert(org);
        return Json.result(oper, success)
                .data("oid", org.getOid());
    }

    @PermInfo("删除组织机构")
    @RequiresPermissions("a:sys:org:del")
    @DeleteMapping
    public Json delete(@RequestBody String body) {
        String oper = "delete org";
        log.info("{},{}", oper, body);

        JSONObject jsonObj = JSON.parseObject(body);
        String oid = jsonObj.getString("oid");
        if (StringUtils.isEmpty(oid)) {
            return Json.fail(oper, "无法删除组织机构：参数为空（机构id）");
        }

        boolean success = sysOrgService.deleteById(oid);
        return Json.result(oper, success);
    }

    @PermInfo("更新组织机构信息")
    @RequiresPermissions("a:sys:org:update")
    @PatchMapping
    public Json update(@RequestBody String body) {

        String oper = "update org";
        log.info("{},{}", oper, body);

        SysOrg org = JSON.parseObject(body, SysOrg.class);

        boolean success = sysOrgService.updateById(org);

        return Json.result(oper, success).data("updated");
    }

    @PermInfo("查询组织机构信息")
    @RequiresPermissions("a:sys:org:info")
    @PostMapping("/info")
    public Json info(@RequestBody String body) {
        String oper = "query org info";
        log.info("{},{}", oper, body);

        JSONObject jsonObj = JSON.parseObject(body);
        String oid = jsonObj.getString("oid");

        SysOrg org = sysOrgService.selectById(oid);
        return Json.succ("oper").data("org", org);
    }

    @PermInfo("查询组织机构列表")
    @RequiresPermissions("a:sys:org:list")
    @PostMapping("/query")
    public Json query(@RequestBody String body) {
        String oper = "query org";
        log.info("{},{}", oper, body);
        JSONObject json = JSON.parseObject(body);
        String oname = json.getString("oname");
        Page<SysOrg> page = sysOrgService.queryByOname(PageUtils.getPageParam(json), oname);
        return Json.succ(oper).data("page", page);
    }

    @PermInfo("查询组织机构树")
    @RequiresPermissions("a:sys:org:tree")
    @PostMapping("/tree")
    public Json tree(@RequestBody String body) {
        String oper = "query org tree";
        log.info("{},{}", oper, body);
        JSONObject json = JSON.parseObject(body);
        String oid = json.getString("oid");
        List<SysOrg> list = sysOrgService.queryOrgChildren(oid);
        return Json.succ(oper).data("list", list);
    }

    @PermInfo("查询组织机构顶部树")
    @RequiresPermissions("a:sys:org:top")
    @GetMapping("/top")
    public Json top() {
        String oper = "query org top";
        log.info("{}", oper);
        List<SysOrg> list = sysOrgService.getTopOrg();
        List<OrgNode> nodelist = list.stream().map(org -> {
            OrgNode node = new OrgNode();
            BeanUtils.copyProperties(org, node);
            return node;
        }).collect(Collectors.toList());
        OrgTree tree = new OrgTree();
        tree.addAll(nodelist);
        return Json.succ(oper).data("tree", tree);
    }

    @PermInfo("查询组织机构根节点")
    @RequiresPermissions("a:sys:org:top")
    @GetMapping("/root")
    public Json root() {
        String oper = "query org root";
        log.info("{}", oper);
        SysOrg sysOrg = sysOrgService.getRoot();
        return Json.succ(oper).data("root", sysOrg);
    }

}
