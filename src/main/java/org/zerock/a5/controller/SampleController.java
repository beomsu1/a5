package org.zerock.a5.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/sample")
public class SampleController {
    
    @PreAuthorize("permitAll") // 모든 사용자가 사용 가능
    @GetMapping("/all")
    public void doAll(){

        log.info("doALL....");
    }

    @PreAuthorize("hasRole('USER')") // USER로 들어왔을 때만 가능
    @GetMapping("/user")
    public void doUser(){

        log.info("doUser....");
    }

    @PreAuthorize("hasRole('G1')") // G1으로 들어왔을 때만 가능
    @GetMapping("/g1")
    public void doG1(){

        log.info("doG1....");
    }
}

