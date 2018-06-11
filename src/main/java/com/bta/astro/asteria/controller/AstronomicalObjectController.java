package com.bta.astro.asteria.controller;

import com.bta.astro.asteria.entity.AstronomicalObject;
import com.bta.astro.asteria.repository.AstronomicalObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

@RequestMapping("astronomical-objects")
@RestController
public class AstronomicalObjectController {

//    @Autowired
//    private AstronomicalObjectRepository repository;
//
//    @GetMapping
//    public String migrate() throws Exception {
//        File file = new File("C:\\Users\\brett\\Documents\\ngc.txt");
//        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                if (!line.startsWith("NGC") || !StringUtils.isEmpty(line)) {
//                    String[] parts = line.split(",");
//
//                    AstronomicalObject object = new AstronomicalObject.Builder()
//                            .name("NGC " + parts[0])
//                            .otherNames(parts.length >=2 ? parts[1] : null)
//                            .type(parts.length >=3 ? parts[2] : null)
//                            .constellation(parts.length >=4 ? parts[3] : null)
//                            .rightAscension(parts.length >=5 ? parts[4] : null)
//                            .declination(parts.length >=6 ? parts[5] : null)
//                            .apparentMagnitude(parts.length >=7 ? parts[6] : null)
//                            .build();
//
//                    //repository.save(object);
//                }
//            }
//        }
//        return "success";
//    }
}
