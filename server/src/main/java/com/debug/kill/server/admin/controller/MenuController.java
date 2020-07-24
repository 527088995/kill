/**
 * Copyright 2018-2020 stylefeng & fengshuonan (https://gitee.com/stylefeng)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.debug.kill.server.admin.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.plugins.Page;
import com.debug.kill.model.dto.MenuDto;
import com.debug.kill.model.entity.Menu;
import com.debug.kill.model.node.ZMenuTree;
import com.debug.kill.model.node.ZTreeNode;
import com.debug.kill.server.admin.base.controller.BaseController;
import com.debug.kill.server.admin.base.response.ResponseData;
import com.debug.kill.server.admin.page.LayuiPageFactory;
import com.debug.kill.server.admin.page.LayuiPageInfo;
import com.debug.kill.server.admin.warpper.MenuWrapper;
import com.debug.kill.server.common.constant.factory.ConstantFactory;
import com.debug.kill.server.common.exception.BizExceptionEnum;
import com.debug.kill.server.exception.ServiceException;
import com.debug.kill.server.service.IMenuService;
import com.debug.kill.server.utils.ToolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 菜单控制器
 *
 * @author ...
 * @Date 2017年2月12日21:59:14
 */
@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController {

    private static String PREFIX = "/modular/system/menu/";

    @Autowired
    private IMenuService menuService;
//
//    @Autowired
//    private IUserService userService;

    /**
     * 跳转到菜单列表列表页面
     *
     * @author ...
     * @Date 2018/12/23 5:53 PM
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "menu.html";
    }

    /**
     * 跳转到菜单列表列表页面
     *
     * @author ...
     * @Date 2018/12/23 5:53 PM
     */
    @RequestMapping(value = "/menu_add")
    public String menuAdd() {
        return PREFIX + "menu_add.html";
    }

    /**
     * 跳转到菜单详情列表页面
     *
     * @author ...
     * @Date 2018/12/23 5:53 PM
     */
    @RequestMapping(value = "/menu_edit")
    public String menuEdit(@RequestParam Long menuId) {
        if (ToolUtil.isEmpty(menuId)) {
            throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
        }

        //获取菜单当前信息，记录日志用
        Menu menu = this.menuService.selectById(menuId);
        //LogObjectHolder.me().set(menu);

        return PREFIX + "menu_edit.html";
    }

    /**
     * 修该菜单
     *
     * @author ...
     * @Date 2018/12/23 5:53 PM
     */
    @RequestMapping(value = "/edit")
    @ResponseBody
    public ResponseData edit(MenuDto menu) {

        //如果修改了编号，则该菜单的子菜单也要修改对应编号
        this.menuService.updateMenu(menu);

        //刷新当前用户菜单
        //this.userService.refreshCurrentUser();

        return SUCCESS_TIP;
    }

    /**
     * 获取菜单列表
     *
     * @author ...
     * @Date 2018/12/23 5:53 PM
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(@RequestParam(required = false) String menuName,
                       @RequestParam(required = false) String level,
                       @RequestParam(required = false) Long menuId) {
        Page page = LayuiPageFactory.defaultPage();
        List<Map<String, Object>> menus = this.menuService.selectMenus(page, menuName, level, menuId);
        page.setRecords((new MenuWrapper(menus).wrap()));
        return LayuiPageFactory.createPageInfo(page);
    }

    /**
     * 获取菜单列表（s树形）
     *
     * @author ...
     * @Date 2019年2月23日22:01:47
     */
    @RequestMapping(value = "/listTree")
    @ResponseBody
    public Object listTree(@RequestParam(required = false) String menuName,
                           @RequestParam(required = false) String level) {
        List<Map<String, Object>> menus = this.menuService.selectMenuTree(menuName, level);
        List<Map<String, Object>> menusWrap = new MenuWrapper(menus).wrap();

        LayuiPageInfo result = new LayuiPageInfo();
        result.setData(menusWrap);
        return result;
    }

    /**
     * 新增菜单
     *
     * @author ...
     * @Date 2018/12/23 5:53 PM
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public ResponseData add(MenuDto menu) {
        this.menuService.addMenu(menu);
        return SUCCESS_TIP;
    }

    /**
     * 删除菜单
     *
     * @author ...
     * @Date 2018/12/23 5:53 PM
     */
    @RequestMapping(value = "/remove")
    @ResponseBody
    public ResponseData remove(@RequestParam Long menuId) {
        if (ToolUtil.isEmpty(menuId)) {
            throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
        }

        //缓存菜单的名称
       // LogObjectHolder.me().set(ConstantFactory.me().getMenuName(menuId));

        this.menuService.delMenuContainSubMenus(menuId);

        return SUCCESS_TIP;
    }

    /**
     * 查看菜单
     *
     * @author ...
     * @Date 2018/12/23 5:53 PM
     */
    @RequestMapping(value = "/view/{menuId}")
    @ResponseBody
    public ResponseData view(@PathVariable Long menuId) {
        if (ToolUtil.isEmpty(menuId)) {
            throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
        }
        Menu menu = this.menuService.selectById(menuId);
        return ResponseData.success(menu);
    }

    /**
     * 获取菜单信息
     *
     * @author ...
     * @Date 2018/12/23 5:53 PM
     */
    @RequestMapping(value = "/getMenuInfo")
    @ResponseBody
    public ResponseData getMenuInfo(@RequestParam Long menuId) {
        if (ToolUtil.isEmpty(menuId)) {
            throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
        }

        Menu menu = this.menuService.selectById(menuId);

        MenuDto menuDto = new MenuDto();
        BeanUtil.copyProperties(menu, menuDto);

        //设置pid和父级名称
        menuDto.setPid(ConstantFactory.me().getMenuIdByCode(menuDto.getPcode()));
        menuDto.setPcodeName(ConstantFactory.me().getMenuNameByCode(menuDto.getPcode()));

        return ResponseData.success(menuDto);
    }

    /**
     * 获取菜单列表(首页用)
     *
     * @author ...
     * @Date 2018/12/23 5:54 PM
     */
    @RequestMapping(value = "/menuTreeList")
    @ResponseBody
    public List<ZMenuTree> menuTreeList() {
        return this.menuService.menuTreeList();
    }

    /**
     * 获取菜单列表(选择父级菜单用)
     *
     * @author ...
     * @Date 2018/12/23 5:54 PM
     */
    @RequestMapping(value = "/selectMenuTreeList")
    @ResponseBody
    public List<ZMenuTree> selectMenuTreeList() {
        List<ZMenuTree> fatherTreeList = this.menuService.menuTreeList();
        List<ZMenuTree> roleTreeList = this.menuService.menuTreeList();
        for (ZMenuTree zMenuTree:roleTreeList){

        }
        return roleTreeList;
    }

    /**
     * 获取角色的菜单列表
     *http://127.0.0.1/menu/menuTreeListByRoleId/5
     * @author ...
     * @Date 2018/12/23 5:54 PM
     */
    @RequestMapping(value = "/menuTreeListByRoleId/{roleId}")
    @ResponseBody
    public List<ZTreeNode> menuTreeListByRoleId(@PathVariable Long roleId) {
        List<Long> menuIds = this.menuService.getMenuIdsByRoleId(roleId);
        if (ToolUtil.isEmpty(menuIds)) {
            return null;
        } else {
            return this.menuService.menuTreeListByMenuIds(menuIds);
        }
    }

}
