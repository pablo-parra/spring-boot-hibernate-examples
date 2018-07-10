package com.example.demo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author pparrado
 *
 */
@Entity
@Table(name = "band")
public class Band implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String name;

  private String style;

  @OneToMany(mappedBy = "band", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Record> records = new ArrayList<>();

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "label_ref")
  @JsonIgnore
  private Label label;

  /**
   * @return id
   */
  public Integer getId() {

    return this.id;
  }

  /**
   * @param id new value of {@link #getId}.
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
   * @param name new value of {@link #getName}.
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
   * @param style new value of {@link #getStyle}.
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
   * @param records new value of {@link #getRecords}.
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
   * @param label new value of {@link #getLabel}.
   */
  public void setLabel(Label label) {

    this.label = label;
  }

  public void addToRecords(Record record) {

    this.records.add(record);
    record.setBand(this);
  }

}
