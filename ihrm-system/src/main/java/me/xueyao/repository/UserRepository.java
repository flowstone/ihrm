package me.xueyao.repository;

import me.xueyao.domain.system.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * 企业数据访问接口
 * @author Simon.Xue
 * @date 1/25/21 11:20 PM
 **/
@Repository
public interface UserRepository extends JpaRepository<User, String>,
        JpaSpecificationExecutor<User> {
    /**
     * 查询用户信息
     * @param mobile 手机号
     * @return
     */
    User findByMobile(String mobile);
}
