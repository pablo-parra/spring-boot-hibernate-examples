package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Band;
import com.example.demo.entity.Label;
import com.example.demo.entity.Record;
import com.example.demo.logic.Datamanagement;
import com.example.demo.logic.to.BandDTO;
import com.example.demo.logic.to.RecordDTO;

/**
 * The REST controller
 *
 */
@Controller
@CrossOrigin
@RequestMapping("/api/v1")
public class DataController {

  @Autowired
  private Datamanagement datamanagement;

  @RequestMapping(value = "/getLabels", method = RequestMethod.GET)
  public @ResponseBody ResponseEntity<?> getLabels() {

    return new ResponseEntity<>(this.datamanagement.findLabels(), HttpStatus.OK);
  }

  @RequestMapping(value = "/saveLabel", method = RequestMethod.POST)
  public @ResponseBody ResponseEntity<?> saveLabel(@RequestBody Label label) {

    Label savedLabel = this.datamanagement.saveLabel(labelMapping(label));
    return ResponseEntity.noContent().build();
  }

  @RequestMapping(value = "/saveBand", method = RequestMethod.POST)
  public @ResponseBody ResponseEntity<?> saveBand(@RequestBody BandDTO band) {

    this.datamanagement.saveBand(band);
    return ResponseEntity.noContent().build();
  }

  @RequestMapping(value = "/saveRecord", method = RequestMethod.POST)
  public @ResponseBody ResponseEntity<?> saveRecord(@RequestBody RecordDTO record) {

    this.datamanagement.saveRecord(record);
    return ResponseEntity.noContent().build();
  }

  // TODO implement a DTO mapping for the Label Entity

  private Label labelMapping(Label label) {

    Label _label = new Label();

    for (Band band : label.getBands()) {
      Band _band = new Band();

      for (Record record : band.getRecords()) {
        Record _record = new Record();
        _record.setTitle(record.getTitle());
        _record.setYear(record.getYear());
        _record.setBand(band);
        _band.addToRecords(record);
      }
      _band.setName(band.getName());
      _band.setLabel(label);
      _label.addToBands(band);
    }
    _label.setName(label.getName());
    return _label;
  }

}
