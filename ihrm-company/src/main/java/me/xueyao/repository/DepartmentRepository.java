package me.xueyao.repository;

import me.xueyao.domain.company.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * 部门操作
 * @author Simon.Xue
 * @date 1/25/21 2:49 PM
 **/
@Repository
public interface DepartmentRepository extends JpaRepository<Department, String>, JpaSpecificationExecutor<Department> {
}
