package me.xueyao.domain.system;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Simon.Xue
 * @date 1/25/21 11:36 PM
 **/
@Entity
@Table(name = "pe_permission")
@Getter
@Setter
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
public class Permission implements Serializable {
    @Id
    private String id;

    private String name;
    /**
     * 权限类型 1 菜单 2功能  3API
     */
    private Integer type;

    private String code;

    private String description;

    private String pid;

    private Integer enVisible;

    public Permission(String name, Integer type, String code, String description) {
        this.name = name;
        this.type = type;
        this.code = code;
        this.description = description;
    }
}
