package me.xueyao.domain.company.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.xueyao.domain.company.Company;
import me.xueyao.domain.company.Department;

import java.util.List;

/**
 * @author Simon.Xue
 * @date 1/25/21 3:25 PM
 **/
@Getter
@Setter
@NoArgsConstructor
public class DeptListResult {
    private String companyId;
    private String companyName;
    private String companyManage;

    private List<Department> depts;

    public DeptListResult(Company company, List depts) {
        this.companyId = company.getId();
        this.companyName = company.getName();
        this.companyManage = company.getLegalRepresentative();
        this.depts = depts;
    }
}
