package com.wangxcit.framework.domain.order;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@Entity
@Table(name="xc_talk")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class XcTalk implements Serializable {
    private static final long serialVersionUID = -916357210051689788L;
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "id",length = 32)
    private String id;
    private String courseid;
    private String coursename;
    private String userid;
    private String username;
    private Date talktime;
    private String area;
}
