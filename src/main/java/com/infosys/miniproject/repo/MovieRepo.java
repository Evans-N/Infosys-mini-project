package com.infosys.miniproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.miniproject.domain.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long>{

}
