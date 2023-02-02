package com.Customer.PO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * PROJECT_NAME Customer
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/1/29~14:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@TableName(value = "user")
public class User implements Serializable {
    @TableField(value = "username")
    private String username;

    /**
     *
     */
    @TableField(value = "id")
    @TableId
    private Long id;

    /**
     *
     */
    @TableField(value = "userAccount")
    private String userAccount;

    /**
     *
     */
    @TableField(value = "avatarUrl")
    private String avatarUrl;

    /**
     *
     */
    @TableField(value = "gender")
    private Integer gender;

    /**
     *
     */
    @TableField(value = "userPassword")
    private String userPassword;

    /**
     *
     */
    @TableField(value = "phone")
    private String phone;

    /**
     *
     */
    @TableField(value = "email")
    private String email;

    /**
     *
     */
    @TableField(value = "userStatus")
    private Integer userStatus;

    /**
     *
     */
    @TableField(value = "createTime")
    private Date createTime;

    /**
     *
     */
    @TableField(value = "updateTime")
    private Date updateTime;

    /**
     *
     */
    @TableField(value = "isDelete")
    private Integer isDelete;

    /**
     *
     */
    @TableField(value = "userRole")
    private Integer userRole;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}
