package com.turling.service;

import com.turling.entity.EasyUIDataGrid;
import com.turling.entity.Emp;

public interface EmpService {
        public EasyUIDataGrid showEmp(Integer curPage,Integer pageSize);

        public void addEmp(Emp emp);

        public void delEmp(Integer id);

        public void updateEmp(Emp emp);
}
