package com.springboot.crud.springbooth2flyway.api;

import com.springboot.crud.springbooth2flyway.model.Departments;
import com.springboot.crud.springbooth2flyway.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/departments")
@RestController
public class DepartmentsController {

    private DepartmentService departmentService;

    @Autowired
    public DepartmentsController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public void addDepartment(@RequestBody Departments departments){
        departmentService.addDepartment(departments);
    }

    @GetMapping
    public List<Departments> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @GetMapping(path = "{id}")
    public Departments getDepartmentById(@PathVariable("id") int id){
        return departmentService.selectDepartmentById(id);
    }
    @DeleteMapping(path ="{id}")
    public void deleteDepartmentById(@PathVariable("id") int id){
        departmentService.deleteDepartment(id);
    }

    @PutMapping(path = "{id}")
    public void updateDepartment(@PathVariable("id") int id,@RequestBody Departments department){
        departmentService.updateDepartment(id,department);
    }

}
