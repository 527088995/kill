package com.debug.kill.server.service;


import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.debug.kill.model.dto.MenuDto;
import com.debug.kill.model.entity.Menu;
import com.debug.kill.model.node.MenuNode;
import com.debug.kill.model.node.ZMenuTree;
import com.debug.kill.model.node.ZTreeNode;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 菜单服务
 *
 * @author ...
 * @date 2017-05-05 22:19
 */
public interface IMenuService  extends IService<Menu> {

    /**
     * 删除菜单
     *
     * @author ...
     * @Date 2017/5/5 22:20
     */
    void delMenu(Long menuId);

    /**
     * 删除菜单包含所有子菜单
     *
     * @author ...
     * @Date 2017/6/13 22:02
     */
    void delMenuContainSubMenus(Long menuId);


    /**
     * 根据条件查询菜单
     *
     * @return
     * @date 2017年2月12日 下午9:14:34
     */
    List<Long> getMenuIdsByRoleId(@Param("roleId") Long roleId);
    /**
     * 根据条件查询菜单
     *
     * @return
     * @date 2017年2月12日 下午9:14:34
     */
    List<Map<String, Object>> selectMenus(Page page, @Param("condition") String condition, @Param("level") String level, Long menuId);
    /**
     * 获取菜单列表树
     *
     * @return
     * @date 2017年2月19日 下午1:33:51
     */
    List<ZMenuTree> menuTreeList();

    /**
     * 获取菜单列表树
     *
     * @return
     * @date 2017年2月19日 下午1:33:51
     */
    List<ZTreeNode> menuTreeListByMenuIds(List<Long> menuIds);

    /**
     * 删除menu关联的relation
     *
     * @param menuId
     * @return
     * @date 2017年2月19日 下午4:10:59
     */
    int deleteRelationByMenu(Long menuId);

    /**
     * 获取资源url通过角色id
     *
     * @param roleId
     * @return
     * @date 2017年2月19日 下午7:12:38
     */
    List<String> getResUrlsByRoleId(Long roleId);

    /**
     * 根据角色获取菜单
     *
     * @param roleIds
     * @return
     * @date 2017年2月19日 下午10:35:40
     */
    List<MenuNode> getMenusByRoleIds(List<Long> roleIds);

    void updateMenu(MenuDto menu);

    List<Map<String, Object>> selectMenuTree(String menuName, String level);

    void addMenu(MenuDto menu);
}
