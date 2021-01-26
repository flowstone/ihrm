package me.xueyao.domain.system;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 接口权限
 * @author Simon.Xue
 * @date 1/26/21 9:13 AM
 **/
@Entity
@Table(name = "pe_permission_api")
@Getter
@Setter
public class PermissionApi implements Serializable {
    @Id
    private String id;
    /**
     * 链接
     */
    private String apiUrl;
    /**
     * 请求类型
     */
    private String apiMethod;
    /**
     * 权限等级  1通用接口权限  2需要校验接口权限
     */
    private String apiLevel;
}
