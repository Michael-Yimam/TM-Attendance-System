package edu.mum.tmattendancesystem.service;

import edu.mum.tmattendancesystem.domain.Student;

import javax.print.DocFlavor;
import java.util.List;
import java.util.Map;

public interface StudentService {
    public Student findById(String id);
    List<Student> findAllByEntry(String entry);
    Map<String, String> findEntryReport(String entry);
}
