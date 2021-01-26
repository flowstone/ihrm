package me.xueyao.domain.system;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 按钮权限
 * @author Simon.Xue
 * @date 1/26/21 9:21 AM
 **/
@Entity
@Table(name = "pe_permission_point")
@Getter
@Setter
public class PermissionPoint implements Serializable {
    @Id
    private String id;
    /**
     * 权限代码
     */
    private String pointClass;

    private String pointIcon;

    private String pointStatus;
}
