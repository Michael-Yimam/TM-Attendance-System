package edu.mum.tmattendancesystem.controller;

import edu.mum.tmattendancesystem.domain.*;
import edu.mum.tmattendancesystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
public class FacultyController {
    @Autowired
    private UserCredentialsService userService;

    @Autowired
    CourseEnrollmentService enrollmentService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private CourseOfferService courseOfferService;

    @Autowired
    private TMAttendanceService attendanceService;

    @RequestMapping(value="/faculty/home", method = RequestMethod.GET)
    public ModelAndView facultyHome(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Faculty user = facultyService.findById(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("message","Content Available Only for University Faculties");
        modelAndView.setViewName("faculty/home");
        return modelAndView;
    }

    @RequestMapping(value="/TM-attendance", method = RequestMethod.GET)
    public String attendanceForm(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Faculty user = facultyService.findById(auth.getName());

        List<CourseOffer> courses = courseOfferService.findAllByFaculty(user);
        model.addAttribute("courses", courses);
        model.addAttribute("course", new CourseOffer());
        model.addAttribute("student", new Student());
        //model.addAttribute("courseId", "wap2019");
        //model.addAttribute("studentId");
        model.addAttribute("userName", "Welcome " + user.getName() + " (" + user.getEmail() + ")");
        model.addAttribute("message","Content Available Only for University Faculties");
        return "faculty/faculty-report";
    }

    @RequestMapping(value="/TM-attendance/block", method = RequestMethod.POST)
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




    @RequestMapping(value="/TM-attendance/block/student", method = RequestMethod.POST)
    public String viewStudentAttendance(@RequestParam("courseId") String courseId,
                                 @RequestParam("studentId") String studentId, Model model){
        // Check input parameters
        System.out.println("Entered course Id: " + courseId);
        System.out.println("Entered student Id: " + studentId);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Block block = courseOfferService.findBlockByCourseId(courseId);

        Map<LocalDate, Boolean> attendanceList = attendanceService.
                findByStudentAndBlock(studentId,block);
        Double extraCredt = attendanceService.findExtraCredit(studentId, block);
        System.out.println("List size: " + attendanceList.size());
        model.addAttribute("attendanceList",attendanceList);
        model.addAttribute("extraCredit", extraCredt);
        model.addAttribute("student", studentService.findById(studentId));
        return "faculty/TM-Attendance";
    }

}
