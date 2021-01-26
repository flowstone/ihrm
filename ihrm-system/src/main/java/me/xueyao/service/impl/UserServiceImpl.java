package me.xueyao.service.impl;

import me.xueyao.domain.system.Role;
import me.xueyao.domain.system.User;
import me.xueyao.entity.PageResult;
import me.xueyao.entity.R;
import me.xueyao.enums.ResultCode;
import me.xueyao.repository.RoleRepository;
import me.xueyao.repository.UserRepository;
import me.xueyao.service.UserService;
import me.xueyao.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

/**
 * @author Simon.Xue
 * @date 1/25/21 11:30 PM
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;


    @Override
    public R findByMobileAndPassword(String mobile, String password) {
        User user = userRepository.findByMobile(mobile);
        if (user != null && password.equals(user.getPassword())) {
            return new R(ResultCode.SUCCESS, user);
        }
        return new R();
    }

    @Override
    public R save(User user) {
        user.setId(idWorker.nextId()+"");
        user.setCreateTime(new Date());
        user.setPassword("123456");
        user.setEnableState(1);
        userRepository.save(user);
        return R.SUCCESS();
    }

    @Override
    public R update(User user) {
        User source = userRepository.getOne(user.getId());
        source.setPassword(user.getPassword());
        source.setUsername(user.getUsername());
        source.setMobile(user.getMobile());
        source.setDepartmentId(user.getDepartmentId());
        source.setDepartmentName(user.getDepartmentName());
        userRepository.save(source);
        return R.SUCCESS();
    }

    @Override
    public R findById(String id) {
        return new R(ResultCode.SUCCESS, userRepository.findById(id).get());
    }

    @Override
    public R delete(String id) {
        userRepository.deleteById(id);
        return R.SUCCESS();
    }

    @Override
    public R findSearch(Map<String, Object> map, int pageNum, int pageSize) {
        Page<User> all = userRepository.findAll(createSpecification(map), PageRequest.of(pageNum - 1, pageSize));
        PageResult<User> pr = new PageResult<>(all.getTotalElements(), all.getContent());
        return new R(ResultCode.SUCCESS, pr);
    }

    private Specification<User> createSpecification(Map<String, Object> map) {

        return new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicateList = new ArrayList<>();
                //ID
                if (map.get("id")!= null && !"".equals(map.get("id"))) {
                    predicateList.add(cb.equal(root.get("id").as(String.class), (String) map.get("id")));
                }

                //手机号码
                if (map.get("mobile")!= null && !"".equals(map.get("mobile"))) {
                    predicateList.add(cb.equal(root.get("mobile").as(String.class), (String) map.get("mobile")));
                }

                //部门id
                if (map.get("departmentId")!= null && !"".equals(map.get("departmentId"))) {
                    predicateList.add(cb.equal(root.get("departmentId").as(String.class), (String) map.get("departmentId")));
                }

                //formOfEmployment
                if (map.get("formOfEmployment")!= null && !"".equals(map.get("formOfEmployment"))) {
                    predicateList.add(cb.equal(root.get("formOfEmployment").as(String.class), (String) map.get("formOfEmployment")));
                }

                //companyId
                if (map.get("companyId")!= null && !"".equals(map.get("companyId"))) {
                    predicateList.add(cb.equal(root.get("companyId").as(String.class), (String) map.get("companyId")));
                }

                //hasDept
                if (map.get("hasDept")!= null && !"".equals(map.get("hasDept"))) {
                    if ("0".equals((String) map.get("hasDept"))) {
                        predicateList.add(cb.isNull(root.get("departmentId")));
                    } else {
                        predicateList.add(cb.isNotNull(root.get("departmentId")));
                    }

                }
                return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));

            }
        };
    }

    @Override
    public R changeDept(String deptId, String deptName, List<String> ids) {
        ids.forEach(id-> {
            User user = userRepository.findById(id).get();
            user.setDepartmentName(deptName);
            user.setDepartmentId(deptId);
            userRepository.save(user);
        });
        return R.SUCCESS();
    }

    @Override
    public R assignRoles(String userId, List<String> roleIds) {
        User user = userRepository.findById(userId).get();
        Set<Role> roles = new HashSet<>();
        roleIds.forEach(roleId-> {
            Role role = roleRepository.findById(roleId).get();
            roles.add(role);
        });

        user.setRoles(roles);
        userRepository.save(user);
        return R.SUCCESS();
    }
}
