package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Band;
import com.example.demo.entity.Label;
import com.example.demo.entity.Record;
import com.example.demo.logic.Datamanagement;

/**
 * @author pparrado
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { DemoApplication.class })
public class DemoTest {

  @Autowired
  private Datamanagement datamanagement;

  @Test
  public void cascadeSaveTest() {

    List<Label> labelsBefore = this.datamanagement.findLabels();

    List<Band> bandsBefore = this.datamanagement.findBands();

    List<Record> recordsBefore = this.datamanagement.findRecords();

    Band band = new Band();
    Record record = new Record();
    Label label = new Label();

    record.setTitle("Bastard");
    record.setYear("2018");

    band.setName("Indian Handcrafts");
    band.addToRecords(record);

    label.setName("Atrial");
    label.addToBands(band);

    Label savedLabel = this.datamanagement.saveLabel(label);

    List<Label> labelsAfter = this.datamanagement.findLabels();

    List<Band> bandsAfter = this.datamanagement.findBands();

    List<Record> recordsAfter = this.datamanagement.findRecords();

    assertThat(savedLabel).isNotNull();

    assertThat(labelsAfter.size()).isGreaterThan(labelsBefore.size());
    assertThat(bandsAfter.size()).isGreaterThan(bandsBefore.size());
    assertThat(recordsAfter.size()).isGreaterThan(recordsBefore.size());

  }
}
