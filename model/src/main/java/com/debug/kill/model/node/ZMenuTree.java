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
package com.debug.kill.model.node;

import lombok.Data;

import java.util.List;

/**
 * jquery ztree 插件的节点
 *
 * @author ...
 * @date 2017年2月17日 下午8:25:14
 */
@Data
public class ZMenuTree {

    /**
     * 节点id
     */
    private Long id;

    /**
     * 父节点id
     */
    private Long pId;

    /**
     * 节点名称
     */
    private String menuname;
    /**
     * 节点名称
     */
    private String url;

    /**
     * 是否打开节点
     */
    private Boolean open;

    /**
     * 是否被选中
     */
    private Boolean checked;

    /**
     * 节点图标  single or group
     */
    private String icon;

    public List<ZMenuTree> children;

    /**
     * 创建ztree的父级节点
     *
     * @author ...
     * @Date 2018/12/23 4:51 PM
     */
    public static ZMenuTree createParent() {
        ZMenuTree zTreeNode = new ZMenuTree();
        zTreeNode.setChecked(true);
        zTreeNode.setId(0L);
        zTreeNode.setMenuname("顶级");
        zTreeNode.setOpen(true);
        zTreeNode.setPId(0L);
        return zTreeNode;
    }
}
