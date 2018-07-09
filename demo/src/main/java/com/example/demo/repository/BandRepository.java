package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Band;

/**
 * @author pparrado
 *
 */
public interface BandRepository extends JpaRepository<Band, Integer> {

}
