package com.example.demo.logic.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Band;
import com.example.demo.entity.Label;
import com.example.demo.entity.Record;
import com.example.demo.logic.Datamanagement;
import com.example.demo.logic.to.BandDTO;
import com.example.demo.logic.to.RecordDTO;
import com.example.demo.repository.BandRepository;
import com.example.demo.repository.LabelRepository;
import com.example.demo.repository.RecordRepository;

/**
 * @author pparrado
 *
 */
@Service
@Transactional
public class DatamanagementImpl implements Datamanagement {

  @Autowired
  private LabelRepository labelRepo;

  @Autowired
  private BandRepository bandRepo;

  @Autowired
  private RecordRepository recordRepo;

  @Override
  public Label saveLabel(Label label) {

    return this.labelRepo.save(label);

  }

  @Override
  public List<Label> findLabels() {

    return this.labelRepo.findAll();
  }

  @Override
  public List<Band> findBands() {

    return this.bandRepo.findAll();
  }

  @Override
  public List<Record> findRecords() {

    return this.recordRepo.findAll();
  }

  @Override
  public Band saveBand(BandDTO band) {

    return this.bandRepo.save(map(band));
  }

  @Override
  public Record saveRecord(RecordDTO record) {

    return this.recordRepo.save(map(record));
  }

  private Band map(BandDTO band) {

    Band _band = new Band();

    for (Record record : band.getRecords()) {
      Record _record = new Record();
      _record.setTitle(record.getTitle());
      _record.setYear(record.getYear());
      _band.addToRecords(record);
    }

    _band.setName(band.getName());
    _band.setLabel(band.getLabel());

    return _band;
  }

  private Record map(RecordDTO record) {

    Record _record = new Record();

    _record.setTitle(record.getTitle());
    _record.setYear(record.getYear());
    _record.setBand(record.getBand());

    return _record;
  }

}
