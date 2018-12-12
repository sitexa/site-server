package com.sitexa.util;

import com.sitexa.entity.SysOrg;

import java.util.ArrayList;
import java.util.List;

public class OrgTree {

    private SysOrg node;

    private List<OrgTree> children = new ArrayList<>();

    public OrgTree() {
    }

    public OrgTree(SysOrg node) {
        this.node = node;
    }

    public SysOrg getNode() {
        return node;
    }

    public void setNode(SysOrg node) {
        this.node = node;
    }

    public List<OrgTree> getChildren() {
        return children;
    }

    public void add(SysOrg node) {
        if (node.getPid().equals(this.node.getOid())) {
            this.children.add(new OrgTree(node));
        }
    }

    public void addAll(List<SysOrg> list) {
        for (SysOrg node : list) {
            if (node.getPid() == null) {
                this.node = node;
            } else {
                this.add(node);
            }
        }
    }

}
