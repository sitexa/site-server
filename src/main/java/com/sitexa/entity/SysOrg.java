package com.sitexa.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_org")
public class SysOrg  extends Model<SysOrg> {

    @TableId(type = IdType.ID_WORKER_STR)
    private String oid;
    /** 组给你吧机构id */
    private String oname;
    /** 组织机构名称 */
    private String pid;
    /** 父机构名称 */
    private Integer olevel;
    /** 机构层级 */
    private String otype;
    /** 机构类型（部门？机构） */
    private String oaddr;
    /** 地址 */
    private String ocode;
    /** 编码 */
    private String onature;
    /** 机构性质code */
    private String onaturename;
    /** 机构性质（省、市、区县、园区、直属部门）*/
    private String status;
    /** 记录状态*/
    private Date created;
    /** 创建时间*/
    private Date updated;
    /** 修改时间*/

    @Override
    protected Serializable pkVal() {
        return oid;
    }
}
