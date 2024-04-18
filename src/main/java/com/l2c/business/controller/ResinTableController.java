package com.l2c.business.controller;

import com.l2c.business.dto.ResinTableDto;
import com.l2c.business.service.ResinTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tables")
public class ResinTableController {

    @Autowired
    private ResinTableService tableService;

    @PostMapping("/create")
    public ResponseEntity<ResinTableDto> createResinTable(@RequestBody ResinTableDto resinTableDto) {
        return new ResponseEntity<>(tableService.createResinTable(resinTableDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResinTableDto> getResinTableById(@PathVariable(name = "id") Integer id) {
        return new ResponseEntity<>(tableService.getResinTableById(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTableById(@PathVariable(name = "id") Integer id) {
        tableService.deleteResinTableById(id);
        return new ResponseEntity<>("The table was deleted with successfully!", HttpStatus.OK);
    }

}
