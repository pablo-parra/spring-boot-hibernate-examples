package com.example.demo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author pparrado
 *
 */
@Entity
@Table(name = "label")
public class Label implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String name;

  @OneToMany(mappedBy = "label", cascade = CascadeType.ALL)
  private List<Band> bands = new ArrayList<>();

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
   * @return bands
   */
  public List<Band> getBands() {

    return this.bands;
  }

  /**
   * @param bands new value of {@link #getBands}.
   */
  public void setBands(List<Band> bands) {

    this.bands = bands;
  }

  public void addToBands(Band band) {

    this.bands.add(band);
    band.setLabel(this);

  }

}
