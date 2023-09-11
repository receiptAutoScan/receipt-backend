package com.receipt.www.receiptbackend.revenue.command.application.controller;


import com.receipt.www.receiptbackend.revenue.command.application.dto.RevenueDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value ="/rev")
public class RevenueRestController {


    @GetMapping(value = "/inquire",produces = "application/json; charset=utf-8")
    public ResponseEntity<?> uploadExcel(@RequestBody Map<String , Object> maps){
        System.out.println(maps);

        return ResponseEntity.ok(maps);
    }

    @DeleteMapping("/delete/{revenueNum}")
    public ResponseEntity<?> deleteExcel(@PathVariable int revenueNum){

        System.out.println(revenueNum);

        return ResponseEntity.ok(revenueNum);
    }
}
