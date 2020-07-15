package com.debug.kill.model.node;

import java.util.List;

/**
 * @Description:
 * @Auther: wj
 * @Date: 2019/5/29 15:33
 */
public interface Tree {
    String getNodeId();

    String getNodeParentId();

    void setChildrenNodes(List childrenNodes);
}
