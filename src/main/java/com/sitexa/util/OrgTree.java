package com.sitexa.util;

import com.sitexa.vo.OrgNode;

import java.util.ArrayList;
import java.util.List;

public class OrgTree {

    private OrgNode node;

    private List<OrgTree> children = new ArrayList<>();

    public OrgTree() {
    }

    public OrgTree(OrgNode node) {
        this.node = node;
    }

    public OrgNode getNode() {
        return node;
    }

    public void setNode(OrgNode node) {
        this.node = node;
    }

    public List<OrgTree> getChildren() {
        return children;
    }

    public void add(OrgNode node) {
        if (node.getPid().equals(this.node.getOid())) {
            this.children.add(new OrgTree(node));
        }
    }

    public void addAll(List<OrgNode> list) {
        for (OrgNode node : list) {
            if (node.getPid() == null) {
                this.node = node;
            } else {
                this.add(node);
            }
        }
    }

}
