package com.example.demo.logic;

import java.util.List;

import com.example.demo.entity.Band;
import com.example.demo.entity.Label;
import com.example.demo.entity.Record;
import com.example.demo.logic.to.BandDTO;
import com.example.demo.logic.to.RecordDTO;

/**
 * @author pparrado
 *
 */
public interface Datamanagement {

  Label saveLabel(Label label);

  List<Label> findLabels();

  List<Band> findBands();

  List<Record> findRecords();

  Band saveBand(BandDTO band);

  Record saveRecord(RecordDTO record);
}
