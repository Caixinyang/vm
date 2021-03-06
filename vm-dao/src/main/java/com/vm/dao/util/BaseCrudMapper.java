package com.vm.dao.util;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseCrudMapper<T> {

    Integer insert(T t);

    Integer batchInsert(List<T> list);

    int batchUpdate(@Param("query") Object query, @Param("newObj") Object newObj);

    int updateInIds(@Param("idList") List<Long> idList, @Param("newObj") Object newObj);

    int update(@Param("id") Long id, @Param("newObj") Object newObj);

    int delete(Object id);

    int deleteBy(@Param("query") Object query);

    int deleteInIds(@Param("idList") List<Long> idList);

    T select(Long id);

    int count(@Param("query") Object query);

    List<Long> selectIdList(@Param("query") Object query);

    List<T> selectInIds(List<Long> idList);

    List<T> selectByAndInIds(@Param("idList") List<Long> idList, @Param("query") Object query);

    List<T> selectBy(@Param("query") Object query);

    T selectOneBy(@Param("query") Object query);

    List<T> selectList(@Param("start") int start, @Param("size") int size, @Param("query") Object query);

    List<T> selectListOrderBy(@Param("start") int start,
                              @Param("size") int size,
                              @Param("orderBy") String orderBy,
                              @Param("orderType") String orderType,
                              @Param("query") Object query);

}
