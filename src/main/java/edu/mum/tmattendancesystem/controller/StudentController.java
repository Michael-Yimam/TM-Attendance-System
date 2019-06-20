package edu.mum.tmattendancesystem.controller;

import edu.mum.tmattendancesystem.domain.*;
import edu.mum.tmattendancesystem.service.BlockService;
import edu.mum.tmattendancesystem.service.StudentService;
import edu.mum.tmattendancesystem.service.TMAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    BlockService blockService;

    @Autowired
    StudentService studentService;

    @Autowired
    TMAttendanceService tmAttendanceService;

    @GetMapping("/studentAttendance")
    public String studentPage(Model model){

        //Find all blocks available
        List<Block> blockList = blockService.findAll();

        //Getting student id and name from authorization configurer
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        //Getting student from database
        Student student = studentService.findById(auth.getName());

        model = findTotalTMAttendance(model, student);
        model.addAttribute("blocks", blockList);
        model.addAttribute("student", student);
        model.addAttribute("role", "student");
        return "studentAttendance";
    }

    @GetMapping("/checkingPage")
    public String studentTMChencking(Model model){

        //Getting student id and name from authorization configurer
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        //Getting student from database
        Student student = studentService.findById(auth.getName());

        List<TMChecking> tmCheckings = student.getTmCheckings();
        List<Retreat> tmRetreats = student.getRetreats();
        System.out.println("his retreats " + tmRetreats.size());

        model.addAttribute("studentTmCheckings", tmCheckings);
        model.addAttribute("studentRetreats", tmRetreats);
        model.addAttribute("student", student);
        return "checkingPage";
    }

    private Model findTotalTMAttendance(Model model, Student student){

        List<Block> blocks = blockService.findAll();
        System.out.println("number of blocks " + blocks.size());
        int found = 0;
        int numberOfPossibleMediations = 0;
        for(Block b : blocks){
            if(b.getName().equals(student.getEntry())) found = 1;
            if(found == 1){
                numberOfPossibleMediations += b.getNumberOfMeditation();
            }
        }

        List<TMAttendance> tmAttendances = tmAttendanceService.findAttendanceOfAStudent(student.getId());

        model.addAttribute("totalMediationAttended", tmAttendances.size());
        model.addAttribute("totalMediationPossible", numberOfPossibleMediations);

        System.out.println("total attedance"+ tmAttendances.size());
        System.out.println("total possible"+ numberOfPossibleMediations);

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);

        model.addAttribute("totalPercentage", (df.format(((float)tmAttendances.size() / numberOfPossibleMediations) * 100)) + "%");
        return model;
    }

    private class StudentTMChecking{
        private String checkingType;
        private LocalDate date;

        public StudentTMChecking(String checkingType, LocalDate date) {
            this.checkingType = checkingType;
            this.date = date;
        }

        public String getCheckingType() {
            return checkingType;
        }

        public void setCheckingType(String checkingType) {
            this.checkingType = checkingType;
        }

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }
    }

}
