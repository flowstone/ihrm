package me.xueyao.controller;

import me.xueyao.domain.system.User;
import me.xueyao.entity.R;
import me.xueyao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author Simon.Xue
 * @date 1/26/21 10:40 AM
 **/
@RestController
@RequestMapping("/sys")
public class UserController extends BaseController{
    @Autowired
    private UserService userService;

    @PostMapping("/user/add")
    public R add(@RequestBody User user) {
        return userService.save(user.setCompanyId(parseCompanyId())
                .setCompanyName(parseCompanyName()));
    }

    @PutMapping("/user/update")
    public R update(@RequestBody User user) {
        return userService.update(user);
    }

    @GetMapping("/user/findById/{id}")
    public R findById(@PathVariable("id") String id) {
        return userService.findById(id);
    }


    @GetMapping("/user/findByPage")
    public R findByPage(@RequestParam int pageNum, @RequestParam int pageSize, @RequestParam Map<String, Object> map) {
        map.put("companyId", parseCompanyId());
        return userService.findSearch(map, pageNum, pageSize);
    }

    @DeleteMapping("/user/delete/{id}")
    public R delete(@PathVariable("id") String id) {
        return userService.delete(id);
    }


}
