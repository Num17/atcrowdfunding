package com.jiuhe.atcrowdfunding.util;

import java.util.Collection;

public class CollectionUtil {

    /**
     * 判断集合是否为空
     */
    public static <T> boolean isEmpty(Collection<T> collection) {
        return collection == null || collection.size() == 0;
    }

}
