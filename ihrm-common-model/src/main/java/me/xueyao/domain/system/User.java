package me.xueyao.domain.system;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Simon.Xue
 * @date 1/25/21 11:08 PM
 **/
@Entity
@Table(name = "bs_user")
@Getter
@Setter
@Accessors(chain = true)
public class User implements Serializable {
    @Id
    private String id;

    private String mobile;

    private String username;

    private String password;
    /**
     * 启用状态 0为禁用 1为启用
     */
    private Integer enableState;

    private Date createTime;

    private String companyId;

    private String companyName;
    /**
     * 部门ID
     */
    private String departmentId;
    /**
     * 入职时间
     */
    private Date timeOfEntry;
    /**
     * 聘用形式
     */
    private Integer formOfEmployment;
    /**
     * 工号
     */
    private String workNumber;
    /**
     * 管理形式
     */
    private String formOfManagement;
    /**
     * 工作城市
     */
    private String workingCity;
    /**
     * 转正时间
     */
    private Date correctionTime;
    /**
     * 在职状态 1.在职 2.离职
     */
    private Integer inServiceStatus;

    private String departmentName;

    /**
     * //用户与角色 多对多
     */
    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "pe_user_role", joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "role_id", referencedColumnName = "id")
    })
    private Set<Role> roles = new HashSet<>();
}
