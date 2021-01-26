package me.xueyao.repository;

import me.xueyao.domain.system.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author Simon.Xue
 * @date 1/26/21 9:52 AM
 **/
@Repository
public interface RoleRepository extends JpaRepository<Role, String> , JpaSpecificationExecutor<Role> {
}
