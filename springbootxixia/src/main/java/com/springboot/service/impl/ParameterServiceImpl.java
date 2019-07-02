package com.springboot.service.impl;

import com.springboot.dao.IParameterMapper;
import com.springboot.domain.Parameter;
import com.springboot.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("parameterService")
public class ParameterServiceImpl implements ParameterService {

    @Autowired
    private IParameterMapper parameterMapper;

    @Override
    public List<Parameter> findByUserId(String userId) {
        return parameterMapper.findByUserId(userId);
    }

    /**
     * 根据id查询台账
     *
     * @param id
     * @return
     */
    @Override
    public List<Parameter> findById(int id) {
        return parameterMapper.findById(id);
    }

    /**
     * 插入台账，不分日周月
     *
     * @param parameter
     * @return
     */
    @Override
    public void insertTz(Parameter parameter) {
        parameterMapper.insertTz(parameter);
    }

    /**
     * 根据开始时间和结束时间查询台账信息
     *
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public List<Parameter> findTzByTime(String userId, Date startTime, Date endTime) {
        return parameterMapper.findTzByTime(userId, startTime, endTime);
    }

    /**
     * 根据时间和台账类型查询
     *
     * @param userId
     * @param styleTz
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public List<Parameter> findTzByTimeAndByStyleTz(String userId, String styleTz,
                                                    Date startTime, Date endTime) {
        return parameterMapper.findTzByTimeAndByStyleTz(userId, styleTz, startTime, endTime);
    }
}
