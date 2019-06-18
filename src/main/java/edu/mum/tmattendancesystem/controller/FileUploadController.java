package edu.mum.tmattendancesystem.controller;

import edu.mum.tmattendancesystem.domain.AttendanceKey;
import edu.mum.tmattendancesystem.domain.MeditationTimeType;
import edu.mum.tmattendancesystem.domain.Student;
import edu.mum.tmattendancesystem.domain.TMAttendance;
import edu.mum.tmattendancesystem.service.StudentService;
import edu.mum.tmattendancesystem.service.TMAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

@Controller
public class FileUploadController {

    @Autowired
    TMAttendanceService tmAttendanceService;

    @Autowired
    StudentService studentService;

    //Save the uploaded file to this folder
    private static final String UPLOAD_LOCATION = "C://";

    @GetMapping("/adminPage")
    public String index(){
        return "adminPage";
    }

    @PostMapping("/fileUpload")
    public String singleFileUpload(@RequestParam("file")MultipartFile file,
                                   RedirectAttributes redirectAttributes){

        if(file.isEmpty()){
            redirectAttributes.addFlashAttribute("uploadMessage", "Please Select a file to upload");
            return "redirect:/";
        }

        redirectAttributes.addFlashAttribute("uploadMessage",
                "You successfully uploaded '" + file.getOriginalFilename() + "'");

        // All file processing and uploading to database is handled by a separate thread
        new Thread(() -> processFile(file)).start();


        return "redirect:/adminPage";
    }

//    @GetMapping("/adminPage")
//    public String adminpage(){
//        return "dash";
//    }

    private void processFile(MultipartFile file){

        try{

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_LOCATION + file.getOriginalFilename());
            Files.write(path, bytes);

            List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
            parseEachLineToModel(allLines);


        }catch(IOException io){
            io.printStackTrace();
        }

    }

    private void printFileContentToConsole(List<String> allLines){
        for(String x : allLines){
            String[] arrayString = x.split(",");

            for(int i = 0; i < arrayString.length; i++){
                System.out.print(arrayString[i] + " - ");
            }
            System.out.println();
        }
    }

    private void parseEachLineToModel(List<String> allLines){

        for(String x : allLines){
            String[] arrayString = x.split(",");
            String[] date = arrayString[0].split("-");

            TMAttendance tmAttendance;

            if(arrayString.length == 5){

                tmAttendance = initializeTmAttendanceObject(arrayString[1], date, arrayString[2],
                        arrayString[3], arrayString[4]);

                tmAttendanceService.save(tmAttendance);

            }else if(arrayString.length == 3){

                Student student = studentService.findById(arrayString[1]);
                System.out.println(student.getName());

                tmAttendance = initializeTmAttendanceObject(arrayString[1], date, student.getBarcode(),
                        "DB", "AM");
                tmAttendanceService.save(tmAttendance);

            }else{

            }

        }

    }

    private TMAttendance initializeTmAttendanceObject(String studentId, String[] date, String barCode,
                                                     String location, String meditationTimeType){

        TMAttendance tmAttendance = new TMAttendance();
        tmAttendance.setAttendanceKey( new AttendanceKey(
                studentId,
                LocalDate.of(Integer.parseInt(date[0]),
                        Integer.parseInt(date[1]),
                        Integer.parseInt(date[2]))));
        tmAttendance.setBarcode(barCode);
        tmAttendance.setLocation(location);
        tmAttendance.setMeditationTimeType(MeditationTimeType.getMeditationTimeType(meditationTimeType));

        return tmAttendance;
    }

    private void removeDuplicateRecords(){

    }
}
