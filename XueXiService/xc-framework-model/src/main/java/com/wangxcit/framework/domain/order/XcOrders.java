package com.wangxcit.framework.domain.order;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/*
* 切记指定uuid的主键策略
* */
@Data
@ToString
@Entity
@Table(name="xc_orders")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class XcOrders implements Serializable {
    private static final long serialVersionUID = -916357210051689789L;
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "id",length = 32)
    private String id;
    private String courseid;
    private String buyerid;
    private String sellerid;
    private Float price;
    private String status;
    private Date ordertime;

}
