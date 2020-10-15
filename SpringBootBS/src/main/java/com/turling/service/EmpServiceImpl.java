package com.turling.service;

import com.turling.dao.EmpMapper;
import com.turling.entity.EasyUIDataGrid;
import com.turling.entity.Emp;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

@Service
public class EmpServiceImpl implements EmpService{
    @Resource
    private EmpMapper empMapper;

    @Override
    public EasyUIDataGrid showEmp(Integer curPage, Integer pageSize) {
        EasyUIDataGrid easyUIDataGrid=new EasyUIDataGrid();
        easyUIDataGrid.setTotal(empMapper.getCount());
        easyUIDataGrid.setRows(empMapper.findEmp((curPage-1)*pageSize, pageSize));

        return easyUIDataGrid;
    }

    @Override
    public void addEmp(Emp emp) {
        empMapper.insert(emp);
    }

    @Override
    public void updateEmp(Emp emp) {
        empMapper.updateByPrimaryKey(emp);
    }

    @Override
    public void delEmp(Integer empno) {
        empMapper.deleteByPrimaryKey(empno);
    }
}
