package me.xueyao.controller;

import me.xueyao.domain.company.Department;
import me.xueyao.entity.R;
import me.xueyao.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Simon.Xue
 * @date 1/25/21 3:07 PM
 **/
@RestController
@RequestMapping("/company")
public class DepartmentController extends BaseController {

    @Autowired
    private DepartmentService departmentService;


    @PostMapping("/departments/save")
    public R add(@RequestBody Department department) {
        department.setCompanyId(parseCompanyId());
        return departmentService.add(department);
    }


    @PutMapping("/departments/update")
    public R update(@RequestBody Department department) {
        department.setCompanyId(parseCompanyId());
        return departmentService.update(department);
    }

    @DeleteMapping("/departments/delete/{id}")
    public R delete(@PathVariable("id") String id) {
        return departmentService.delete(id);
    }

    @GetMapping("/departments/findById/{id}")
    public R findById(@PathVariable("id") String id) {
        return departmentService.findById(id);
    }


    @GetMapping("/departments/findAll")
    public R findAll() {
        return departmentService.findAll(parseCompanyId());
    }
}



