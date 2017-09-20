package com.kohls.controller;

import com.kohls.service.StudentServiceDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tkmabp3 on 9/18/17.
 */
@RestController
public class SchoolServiceController {
    @Autowired
    StudentServiceDelegate studentServiceDelegate;

    @RequestMapping(value = "/getSchoolDetails/{schoolname}", method = RequestMethod.GET)
    public String getStudents(@PathVariable String schoolname) throws Exception{
        System.out.println("Going to call student service to get data!");
        return studentServiceDelegate.callStudentServiceAndGetData(schoolname);
    }
}
