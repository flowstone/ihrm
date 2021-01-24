package me.xueyao.controller;

import me.xueyao.domain.Company;
import me.xueyao.entity.R;
import me.xueyao.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Simon.Xue
 * @date 1/24/21 10:05 PM
 **/
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @PostMapping("/add")
    public R add(@RequestBody Company company) {
        return companyService.add(company);
    }

    @PutMapping("/update")
    public R update(@RequestBody Company company) {
        return companyService.update(company);
    }


    @GetMapping("/findById/{id}")
    public R findById(@PathVariable("id") String id) {
        return companyService.findById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public R deleteById(@PathVariable("id") String id) {
        return companyService.deleteById(id);
    }


    @GetMapping("/findAll")
    public R findAll() {
        return companyService.findAll();
    }
}
