package edu.mum.tmattendancesystem.controller;

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
import java.util.List;

@Controller
public class FileUploadController {

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

        try{

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_LOCATION + file.getOriginalFilename());
            Files.write(path, bytes);

            List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
            for(String x : allLines){
                String[] arrayString = x.split(",");

                for(int i = 0; i < arrayString.length; i++){
                    System.out.print(arrayString[i] + " - ");
                }
                System.out.println();
            }

            redirectAttributes.addFlashAttribute("uploadMessage",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
        }catch(IOException io){
            io.printStackTrace();
        }

        return "redirect:/";
    }

    @GetMapping("/admin")
    public String adminpage(){
        return "dash";
    }

}
