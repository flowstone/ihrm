package me.xueyao.domain.system;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 菜单权限
 * @author Simon.Xue
 * @date 1/26/21 9:17 AM
 **/
@Entity
@Table(name = "pe_permission_menu")
@Getter
@Setter
public class PermissionMenu implements Serializable {
    @Id
    private String id;
    /**
     * 展示图标
     */
    private String menuIcon;
    /**
     * 排序号
     */
    private String menuOrder;
}
