package com.debug.kill.log.dictmap;


import com.debug.kill.log.base.AbstractDictMap;

public class WordMap extends AbstractDictMap {

    @Override
    public void init() {
        put("EN", "英文");
        put("CN", "中文");
        put("SHORT", "简称");
        put("REMARK", "备注");
        put("DATA_STATUS", "状态");
    }

    @Override
    protected void initBeWrapped() {
        putFieldWrapperMethodName("DATA_STATUS","getWordStatus");
    }

}
