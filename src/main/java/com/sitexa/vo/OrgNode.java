package com.sitexa.vo;


/**
 * Author: xnpeng (xpneng@hotmail.com)
 * Date: 2018/12/21
 **/
public class OrgNode {
    private String oid;
    private String oname;
    private String pid;
    private Integer olevel;
    private String otype;
    private String oaddr;
    private String ocode;
    private String onature;
    private String onaturename;

    public OrgNode() {
    }

    public OrgNode(String oid, String oname, String pid, Integer olevel, String otype, String oaddr, String ocode, String onature, String onaturename) {
        this.oid = oid;
        this.oname = oname;
        this.pid = pid;
        this.olevel = olevel;
        this.otype = otype;
        this.oaddr = oaddr;
        this.ocode = ocode;
        this.onature = onature;
        this.onaturename = onaturename;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Integer getOlevel() {
        return olevel;
    }

    public void setOlevel(Integer olevel) {
        this.olevel = olevel;
    }

    public String getOtype() {
        return otype;
    }

    public void setOtype(String otype) {
        this.otype = otype;
    }

    public String getOaddr() {
        return oaddr;
    }

    public void setOaddr(String oaddr) {
        this.oaddr = oaddr;
    }

    public String getOcode() {
        return ocode;
    }

    public void setOcode(String ocode) {
        this.ocode = ocode;
    }

    public String getOnature() {
        return onature;
    }

    public void setOnature(String onature) {
        this.onature = onature;
    }

    public String getOnaturename() {
        return onaturename;
    }

    public void setOnaturename(String onaturename) {
        this.onaturename = onaturename;
    }
}
