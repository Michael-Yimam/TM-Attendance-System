package edu.mum.tmattendancesystem.controller;

import edu.mum.tmattendancesystem.domain.AttendanceKey;
import edu.mum.tmattendancesystem.domain.MeditationTimeType;
import edu.mum.tmattendancesystem.domain.TMAttendance;
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

    //Save the uploaded file to this folder
    private static final String UPLOAD_LOCATION = "C://";

    @GetMapping("/")
    public String index(){
        System.out.println("*******************************");
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

        processFile(file);

        return "redirect:/";
    }

    @GetMapping("/admin")
    public String adminpage(){
        return "dash";
    }

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
    System.out.println("ddddd inside parse each line to model");
        for(String x : allLines){
            String[] arrayString = x.split(",");
            String[] date = arrayString[0].split("-");

            TMAttendance tmAttendance = new TMAttendance();

            if(arrayString.length == 5){

                tmAttendance.setAttendanceKey(new AttendanceKey(
                        arrayString[1],
                        LocalDate.of(Integer.parseInt(date[0]),
                                     Integer.parseInt(date[1]),
                                     Integer.parseInt(date[2]))));
                tmAttendance.setBarcode(arrayString[2]);
                tmAttendance.setLocation(arrayString[3]);
                tmAttendance.setMeditationTimeType(MeditationTimeType.getMeditationTimeType(arrayString[4]));


                System.out.println("/// " + tmAttendance.toString());
                tmAttendanceService.save(tmAttendance);

            }else if(arrayString.length == 4){



            }else{

            }

            System.out.println();
        }

    }
}
