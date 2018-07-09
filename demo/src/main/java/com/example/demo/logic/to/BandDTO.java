package com.example.demo.logic.to;

import java.util.List;

import com.example.demo.entity.Label;
import com.example.demo.entity.Record;

/**
 * @author pparrado
 *
 */
public class BandDTO {

  private Integer id;

  private String name;

  private String style;

  private List<Record> records;

  private Label label;

  /**
   * @return id
   */
  public Integer getId() {

    return this.id;
  }

  /**
   * @param id new value of {@link #getid}.
   */
  public void setId(Integer id) {

    this.id = id;
  }

  /**
   * @return name
   */
  public String getName() {

    return this.name;
  }

  /**
   * @param name new value of {@link #getname}.
   */
  public void setName(String name) {

    this.name = name;
  }

  /**
   * @return style
   */
  public String getStyle() {

    return this.style;
  }

  /**
   * @param style new value of {@link #getstyle}.
   */
  public void setStyle(String style) {

    this.style = style;
  }

  /**
   * @return records
   */
  public List<Record> getRecords() {

    return this.records;
  }

  /**
   * @param records new value of {@link #getrecords}.
   */
  public void setRecords(List<Record> records) {

    this.records = records;
  }

  /**
   * @return label
   */
  public Label getLabel() {

    return this.label;
  }

  /**
   * @param label new value of {@link #getlabel}.
   */
  public void setLabel(Label label) {

    this.label = label;
  }

}
