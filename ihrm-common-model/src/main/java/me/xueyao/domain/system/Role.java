package me.xueyao.domain.system;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Simon.Xue
 * @date 1/25/21 11:33 PM
 **/
@Entity
@Table(name = "pe_role")
@Getter
@Setter
public class Role implements Serializable {
    @Id
    private String id;

    private String name;

    private String description;

    private String companyId;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>(0);


}
