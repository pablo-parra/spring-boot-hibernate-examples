package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Label;

/**
 * @author pparrado
 *
 */
public interface LabelRepository extends JpaRepository<Label, Integer> {

}
