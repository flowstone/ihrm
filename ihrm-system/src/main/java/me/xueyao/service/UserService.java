package me.xueyao.service;

import me.xueyao.domain.system.User;
import me.xueyao.entity.R;

import java.util.List;
import java.util.Map;

/**
 * @author Simon.Xue
 * @date 1/25/21 11:23 PM
 **/
public interface UserService {

    R findByMobileAndPassword(String mobile, String password);

    R save(User user);

    R update(User user);

    R findById(String id);

    R delete(String id);

    R findSearch(Map<String, Object> map, int pageNum, int pageSize);

    /**
     * 调整部门
     * @param deptId
     * @param deptName
     * @param ids
     * @return
     */
    R changeDept(String deptId, String deptName, List<String> ids);

    /**
     * 分配角色
     * @param userId
     * @param roleIds
     * @return
     */
    R assignRoles(String userId, List<String> roleIds);

}
