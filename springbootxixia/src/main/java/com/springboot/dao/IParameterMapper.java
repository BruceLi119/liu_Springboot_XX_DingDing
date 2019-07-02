package com.springboot.dao;

import com.springboot.domain.Parameter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface IParameterMapper {
    /**
     * 根据userId查询本人台账
     *
     * @param userId
     * @return
     */
    public List<Parameter> findByUserId(String userId);

    /**
     * 根据id查询台账
     *
     * @param id
     * @return
     */
    public List<Parameter> findById(int id);

    /**
     * 插入台账，不分日周月
     *
     * @param parameter
     * @return
     */
    public void insertTz(Parameter parameter);

    /**
     * 根据开始时间和结束时间查询台账信息
     */
    public List<Parameter> findTzByTime(@Param("userId") String userId, @Param("startTime") Date startTime,
                                        @Param("endTime") Date endTime);

    /**
     * 根据时间和台账类型查询
     *
     * @param userId
     * @param styleTz
     * @param startTime
     * @param endTime
     * @return
     */
    public List<Parameter> findTzByTimeAndByStyleTz(@Param("userId") String userId, @Param("styleTz") String styleTz,
                                                    @Param("startTime") Date startTime, @Param("endTime") Date endTime);
}
