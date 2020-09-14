package com.debug.kill.server.common.constant.factory;

import cn.hutool.core.lang.Dict;
import com.debug.kill.log.util.SpringContextHolder;
import com.debug.kill.model.entity.Menu;
import com.debug.kill.model.mapper.MenuMapper;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 常量的生产工厂
 *
 * @author ...
 * @date 2017年2月13日 下午10:55:21
 */
@Component
@DependsOn("springContextHolder")
public class ConstantFactory implements IConstantFactory {

    private MenuMapper menuMapper = SpringContextHolder.getBean(MenuMapper.class);

    public static IConstantFactory me() {
        return SpringContextHolder.getBean("constantFactory");
    }


    @Override
    public String getUserNameById(Long userId) {
        return null;
    }

    @Override
    public String getUserAccountById(Long userId) {
        return null;
    }

    @Override
    public String getRoleName(String roleIds) {
        return null;
    }

    @Override
    public String getSingleRoleName(Long roleId) {
        return null;
    }

    @Override
    public String getSingleRoleTip(Long roleId) {
        return null;
    }

    @Override
    public String getDeptName(Long deptId) {
        return null;
    }

    @Override
    public String getMenuNames(String menuIds) {
        return null;
    }

    @Override
    public String getMenuName(Long menuId) {
        return null;
    }

    @Override
    public Menu getMenuByCode(String code) {
        return null;
    }

    @Override
    public String getMenuNameByCode(String code) {
        return null;
    }

    @Override
    public Long getMenuIdByCode(String code) {
        return null;
    }

    @Override
    public String getDictName(Long dictId) {
        return null;
    }

    @Override
    public String getNoticeTitle(Long dictId) {
        return null;
    }

    @Override
    public String getDictsByName(String name, String code) {
        return null;
    }

    @Override
    public String getSexName(String sexCode) {
        return null;
    }

    @Override
    public String getStatusName(String status) {
        return null;
    }

    @Override
    public String getMenuStatusName(String status) {
        return null;
    }

    @Override
    public List<Dict> findInDict(Long id) {
        return null;
    }

    @Override
    public String getCacheObject(String para) {
        return null;
    }

    @Override
    public List<Long> getSubDeptId(Long deptId) {
        return null;
    }

    @Override
    public List<Long> getParentDeptIds(Long deptId) {
        return null;
    }

    @Override
    public String getDelFlag(String delFlag) {
        return null;
    }
}
