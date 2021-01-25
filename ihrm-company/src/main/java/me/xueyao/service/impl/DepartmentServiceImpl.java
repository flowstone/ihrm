package me.xueyao.service.impl;

import me.xueyao.domain.company.Company;
import me.xueyao.domain.company.Department;
import me.xueyao.domain.company.response.DeptListResult;
import me.xueyao.entity.R;
import me.xueyao.enums.ResultCode;
import me.xueyao.repository.CompanyRepository;
import me.xueyao.repository.DepartmentRepository;
import me.xueyao.service.BaseService;
import me.xueyao.service.DepartmentService;
import me.xueyao.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Simon.Xue
 * @date 1/25/21 2:53 PM
 **/
@Service
public class DepartmentServiceImpl extends BaseService implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public R add(Department department) {
        department.setId(idWorker.nextId()+"");
        department.setCreateTime(new Date());
        departmentRepository.save(department);
        return R.SUCCESS();
    }


    @Override
    public R update(Department department) {
        Department sourceDepartment = departmentRepository.findById(department.getId()).get();
        sourceDepartment.setName(department.getName());
        sourceDepartment.setPid(department.getPid());
        sourceDepartment.setManagerId(department.getManagerId());
        sourceDepartment.setIntroduce(department.getIntroduce());
        sourceDepartment.setManager(department.getManager());
        departmentRepository.save(sourceDepartment);
        return R.SUCCESS();
    }

    @Override
    public R findById(String id) {
        Department department = departmentRepository.findById(id).get();
        return new R(ResultCode.SUCCESS, department);
    }

    @Override
    public R delete(String id) {
        departmentRepository.deleteById(id);
        return R.SUCCESS();
    }

    @Override
    public R findAll(String companyId) {
        Company company = companyRepository.findById(companyId).get();
        List<Department> list = departmentRepository.findAll(getSpecification(companyId));
        return new R(ResultCode.SUCCESS, new DeptListResult(company, list));
    }
}
