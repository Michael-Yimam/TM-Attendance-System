package edu.mum.tmattendancesystem.controller;

import edu.mum.tmattendancesystem.domain.Meditation;
import edu.mum.tmattendancesystem.domain.TMAttendance;
import edu.mum.tmattendancesystem.service.BlockService;
import edu.mum.tmattendancesystem.service.MeditationService;
import edu.mum.tmattendancesystem.service.TMAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController

public class RestController {

    @Autowired
    BlockService blockService;

    @Autowired
    MeditationService meditationService;

    @Autowired
    TMAttendanceService tmAttendanceService;

    @GetMapping(value="/studentAttendance/getBlockMeditations/{block}/{studentId}", produces = "application/json")
    public List<StudentBlockTMAttendance> saveCategory(@PathVariable String block, @PathVariable String studentId) {

        List<Meditation> meditations = meditationService.findByBlock(block);
        System.out.println("//////////////// mediation in that block " + meditations.size());

        List<TMAttendance> tmAttendances = tmAttendanceService.findAttendanceOfAStudent(studentId);
        List<LocalDate> studentAttendanceDates = new ArrayList<>();

        for(TMAttendance ta : tmAttendances){
            studentAttendanceDates.add(ta.getAttendanceKey().getDate());
        }

        System.out.println("//////////////// all student mediation attendance " + tmAttendances.size());

        List<StudentBlockTMAttendance> studentBlockTMAttendanceList = new ArrayList<>();

        for(Meditation md : meditations){
            if(studentAttendanceDates.contains(md.getDate())){
                studentBlockTMAttendanceList.add(new StudentBlockTMAttendance(md.getDate(), true));
            }else{
                studentBlockTMAttendanceList.add(new StudentBlockTMAttendance(md.getDate(), false));
            }
        }

        return studentBlockTMAttendanceList;
    }

    private class StudentBlockTMAttendance{
        public LocalDate date;
        public boolean present;

        public StudentBlockTMAttendance(LocalDate date, boolean present) {
            this.date = date;
            this.present = present;
        }

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public boolean isPresent() {
            return present;
        }

        public void setPresent(boolean present) {
            this.present = present;
        }
    }

}
