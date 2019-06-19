package edu.mum.tmattendancesystem.controller;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import edu.mum.tmattendancesystem.domain.CSVDemoClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@Controller
public class CSVController {
    @GetMapping("/exportCSV")
    public void generateReport(HttpServletResponse response) throws Exception {
        System.out.println("export csv");
        CSVDemoClass r1 = new CSVDemoClass("aaa", 1);
        CSVDemoClass r2 = new CSVDemoClass("bbb", 2);
        CSVDemoClass r3 = new CSVDemoClass("ccc", 3);
        List<CSVDemoClass> list = Arrays.asList(r1, r2, r3);
        //set file name and content type
        String filename = "report.csv";

        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");

        //create a csv writer
        StatefulBeanToCsv<CSVDemoClass> writer = new StatefulBeanToCsvBuilder<CSVDemoClass>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withOrderedResults(false)
                .build();

        //write all users to csv file
        writer.write(list);
    }

    @GetMapping("/csvdemo")
    public String csvDemo() {
        return "csvdemo";
    }
}
