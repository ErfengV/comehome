package com.ac.comehome.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * @program: comehome
 * @description:
 * @author: ErFeng_V
 * @create: 2021-04-11 20:33
 */
//表示父类映射到数据库表
//@MappedSuperclass
//启动审计监听器
//@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class BaseEntity implements Serializable {

//        @Column(columnDefinition = "datetime comment '创建时间'")
//        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
////        @CreatedDate
//        private Date createTime;
//
//        @Column(columnDefinition = "datetime comment '更新时间'")
//        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
////        @LastModifiedDate
//        private Date updateTime;
//
//        @Override
//        public String toString() {
//                return "BaseEntity{" +
//                        "createtime=" + createTime +
//                        ", updatetime=" + updateTime +
//                        '}';
//        }
}
