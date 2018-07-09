package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author pparrado
 *
 */
@Entity
@Table(name = "record")
public class Record implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String title;

  private String year;

  @ManyToOne
  @JoinColumn(name = "band_ref")
  @JsonIgnore
  private Band band;

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
   * @return title
   */
  public String getTitle() {

    return this.title;
  }

  /**
   * @param title new value of {@link #getTitle}.
   */
  public void setTitle(String title) {

    this.title = title;
  }

  /**
   * @return year
   */
  public String getYear() {

    return this.year;
  }

  /**
   * @param year new value of {@link #getYear}.
   */
  public void setYear(String year) {

    this.year = year;
  }

  /**
   * @return band
   */
  public Band getBand() {

    return this.band;
  }

  /**
   * @param band new value of {@link #getBand}.
   */
  public void setBand(Band band) {

    this.band = band;
  }

}
