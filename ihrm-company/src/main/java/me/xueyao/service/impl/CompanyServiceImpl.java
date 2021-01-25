package me.xueyao.service.impl;

import me.xueyao.domain.company.Company;
import me.xueyao.entity.R;
import me.xueyao.enums.ResultCode;
import me.xueyao.repository.CompanyRepository;
import me.xueyao.service.CompanyService;
import me.xueyao.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Simon.Xue
 * @date 1/24/21 9:46 PM
 **/
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private IdWorker idWorker;

    @Override
    public R add(Company company) {
        company.setId(idWorker.nextId() + "");
        company.setCreateTime(new Date());
        company.setState(1);
        company.setAuditState("0");
        company.setBalance(0D);
        companyRepository.save(company);
        return R.SUCCESS();
    }

    @Override
    public R update(Company company) {
        String id = company.getId();
        Optional<Company> companyOptional = companyRepository.findById(id);

        Company one = companyOptional.get();
        one.setName(company.getName());
        one.setRemarks(company.getRemarks());
        one.setState(company.getState());
        one.setAuditState(company.getAuditState());
        companyRepository.save(one);
        return R.SUCCESS();
    }

    @Override
    public R findById(String id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        Company company = companyOptional.get();
        return new R(ResultCode.SUCCESS, company);
    }

    @Override
    public R deleteById(String id) {
        companyRepository.deleteById(id);
        return R.SUCCESS();
    }

    @Override
    public R findAll() {
        List<Company> all = companyRepository.findAll();
        return new R(ResultCode.SUCCESS, all);
    }
}
