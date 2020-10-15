package com.turling.controller;

import com.turling.entity.EasyUIDataGrid;
import com.turling.entity.Emp;
import com.turling.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmpController {
    @Autowired
    private EmpService empService;
    @RequestMapping("/showEmp")
    @ResponseBody
    public EasyUIDataGrid showEmp(@RequestParam(name = "page",defaultValue = "2") Integer curPage,
                                  @RequestParam(name = "rows",defaultValue = "2") Integer pageSize){
        return  empService.showEmp(curPage, pageSize);
    }

    //添加
    @PostMapping("/addEmp")
    @ResponseBody
    public String addEmp(Emp emp){
        empService.addEmp(emp);
            return "success";
    }

    @PostMapping("/upEmp")
    @ResponseBody
    public String upEmp(Emp emp) {
        empService.updateEmp(emp);
        return "success";
    }
        @PostMapping("/delEmp")
        @ResponseBody
        public String delEmp(Integer empno){
            empService.delEmp(empno);
            return "success";
        }

}
