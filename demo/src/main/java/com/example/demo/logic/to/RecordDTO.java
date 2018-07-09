package com.example.demo.logic.to;

import com.example.demo.entity.Band;

/**
 * @author pparrado
 *
 */
public class RecordDTO {

  private Integer id;

  private String title;

  private String year;

  private Band band;

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
   * @return title
   */
  public String getTitle() {

    return this.title;
  }

  /**
   * @param title new value of {@link #gettitle}.
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
   * @param year new value of {@link #getyear}.
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
   * @param band new value of {@link #getband}.
   */
  public void setBand(Band band) {

    this.band = band;
  }

}
