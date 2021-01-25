package me.xueyao.service;

import me.xueyao.domain.company.Department;
import me.xueyao.entity.R;

/**
 * @author Simon.Xue
 * @date 1/25/21 2:51 PM
 **/
public interface DepartmentService {

    R add(Department department);

    R update(Department department);

    R findById(String id);

    R delete(String id);

    R findAll(String companyId);
}
