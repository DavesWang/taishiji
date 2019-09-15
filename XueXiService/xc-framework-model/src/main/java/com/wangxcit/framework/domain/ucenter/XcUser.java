package com.wangxcit.framework.domain.ucenter;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


@Data
@ToString
@Entity
@Table(name="xc_user")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class XcUser {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String id;
    private String username;
    private String password;
    private String salt;
    private String name;
    private String utype;
    private Date birthday;
    private String userpic;
    private String sex;
    private String email;
    private String phone;
    private String qq;
    private String status;
    @Column(name="create_time")
    private Date createTime;
    @Column(name="update_time")
    private Date updateTime;
    private Float money;


}