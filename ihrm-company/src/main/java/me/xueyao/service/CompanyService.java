package me.xueyao.service;

import me.xueyao.domain.Company;
import me.xueyao.entity.R;

/**
 * @author Simon.Xue
 * @date 1/24/21 9:36 PM
 **/

public interface CompanyService {

    R add(Company company);

    R update(Company company);

    R findById(String id);

    R deleteById(String id);

    R findAll();
}
