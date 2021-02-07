package com.texoit.challenge.challenge;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long> {
    
    List<Movie> findByStudios(String studios);

    Movie findById(long id);

    String maxQuery = "SELECT m.producer as producer, (m2.year - m.year) as interval, m.year as previousWin, m2.year as followingWin FROM Movie m, Movie m2 WHERE m.producer = m2.producer AND m.winner = true AND m2.year = (SELECT MIN(m3.year) FROM Movie m3 WHERE m3.producer = m2.producer AND m3.year > m.year AND m3.winner = true) AND (m2.year - m.year) = (SELECT MAX(m5.year - m4.year) FROM Movie m4, Movie m5 WHERE m4.producer = m5.producer AND m4.winner = true AND m5.year = (SELECT MIN(m3.year) FROM Movie m3 WHERE m3.producer = m4.producer AND m3.year > m4.year AND m3.winner = true))";
    String minQuery = "SELECT m.producer as producer, (m2.year - m.year) as interval, m.year as previousWin, m2.year as followingWin FROM Movie m, Movie m2 WHERE m.producer = m2.producer AND m.winner = true AND m2.year = (SELECT MIN(m3.year) FROM Movie m3 WHERE m3.producer = m2.producer AND m3.year > m.year AND m3.winner = true) AND (m2.year - m.year) = (SELECT MIN(m5.year - m4.year) FROM Movie m4, Movie m5 WHERE m4.producer = m5.producer AND m4.winner = true AND m5.year = (SELECT MIN(m3.year) FROM Movie m3 WHERE m3.producer = m4.producer AND m3.year > m4.year AND m3.winner = true))";
    @Query(maxQuery)
    List<MovieResultset> findMaxInterval();

    @Query(minQuery)
    List<MovieResultset> findMinInterval();

 
    @Query("SELECT m.producer as producer, (m2.year - m.year) as interval, m.year as previousWin, m2.year as followingWin FROM Movie m, Movie m2 WHERE m.producer = m2.producer AND m.winner = true AND m2.year = (SELECT MIN(m3.year) FROM Movie m3 WHERE m3.producer = m2.producer AND m3.year > m.year AND m3.winner = true)")
    List<MovieResultset> findIntervals();

}
