package edu.mum.tmattendancesystem.controller;

import edu.mum.tmattendancesystem.domain.*;
import edu.mum.tmattendancesystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller

public class AdminController {

    @Autowired
    private UserCredentialsService userService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private RoleService roleService;

    @Autowired
    CourseEnrollmentService enrollmentService;

    @Autowired
    private CourseOfferService courseOfferService;

    @Autowired
    private TMAttendanceService attendanceService;


    @RequestMapping(value="/admin/home", method = RequestMethod.GET)
    public ModelAndView adminHome(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("User Id: " + auth.getName());
        Admin admin = adminService.findById(auth.getName());
        modelAndView.addObject("userName", "Welcome " + admin.getName() + " " + " (" + admin.getEmail() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }

    @RequestMapping(value="/student/home", method = RequestMethod.GET)
    public ModelAndView studentHome(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Logged in User Id: " + auth.getName());
        UserCredentials user = userService.findByUserName(auth.getName());
        //modelAndView.addObject("userName", "Welcome " + admin.getName() + " " + admin.getLastName() + " (" + admin.getEmail() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName("student/home");
        return modelAndView;
    }


    //================== From Faculty Controller ============================//
    @RequestMapping(value="/tm/report", method = RequestMethod.GET)
    public String attendanceForm(Model model){
        System.out.println("In /tm/reports ....");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Admin user = adminService.findById(auth.getName());

        List<CourseOffer> courses = courseOfferService.findAll();
        model.addAttribute("courses", courses);
        model.addAttribute("course", new CourseOffer());


        model.addAttribute("student", new Student());
        model.addAttribute("userName", "Welcome " + user.getName() + " (" + user.getEmail() + ")");
        model.addAttribute("message","Content Available Only for Admin users");
        return "admin/admin-report";
    }


    @RequestMapping(value="/tm/entry", method = RequestMethod.GET)
    public String viewEntryAttendance(@RequestParam("entryId") String entryId, Model model){
        // Check input parameters
        System.out.println("Entered Entry Id: " + entryId);

        //Get Faculty Id;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Map<String, String> report = studentService.findEntryReport(entryId);
        System.out.println("List size: " + report.size());
        model.addAttribute("report",report);
        model.addAttribute("entry", entryId);
        return "admin/entry-report";
    }

    @RequestMapping(value="/tm/block", method = RequestMethod.GET)
    public String viewBlockAttendance(@RequestParam("courseId") String courseId, Model model){
        // Check input parameters
        System.out.println("Entered course Id: " + courseId);

        //Get Faculty Id;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Block block = courseOfferService.findBlockByCourseId(courseId);

        Map<String, Double> report = attendanceService.
                findBlockReport(courseId, block);
        System.out.println("List size: " + report.size());
        model.addAttribute("report",report);
        model.addAttribute("courseId", courseId);
        return "faculty/block-report";
    }




    @RequestMapping(value="/tm/block/student", method = RequestMethod.POST)
    public String viewStudentAttendance(@RequestParam("courseId") String courseId,
                                        @RequestParam("studentId") String studentId, Model model){
        // Check input parameters
        System.out.println("Entered course Id: " + courseId);
        System.out.println("Entered student Id: " + studentId);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Block block = courseOfferService.findBlockByCourseId(courseId);

        Map<LocalDate, Boolean> attendanceList = attendanceService.
                findByStudentAndBlock(studentId,block);
        Double extraCredit = attendanceService.findExtraCredit(studentId, block);
        System.out.println("List size: " + attendanceList.size());
        model.addAttribute("attendanceList",attendanceList);
        model.addAttribute("extraCredit", extraCredit);
        model.addAttribute("student", studentService.findById(studentId));
        return "faculty/TM-Attendance";
    }
}
