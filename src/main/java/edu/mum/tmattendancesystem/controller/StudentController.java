package edu.mum.tmattendancesystem.controller;

import edu.mum.tmattendancesystem.domain.Block;
import edu.mum.tmattendancesystem.domain.Student;
import edu.mum.tmattendancesystem.service.BlockService;
import edu.mum.tmattendancesystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


import java.util.List;

@Controller
public class StudentController {

    @Autowired
    BlockService blockService;

    @Autowired
    StudentService studentService;

    @GetMapping("/studentAttendance")
    public String studentPage(Model model){

        //Find all blocks available
        List<Block> blockList = blockService.findAll();

        //Getting student id and name from authorization configurer
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        //Getting student from database
        Student student = studentService.findById(auth.getName());

        model.addAttribute("blocks", blockList);
        model.addAttribute("student", student);
        model.addAttribute("role", "student");
        return "studentAttendance";
    }

    @GetMapping("/checkingPage")
    public String studentTMChencking(){
        return "checkingPage";
    }

}
