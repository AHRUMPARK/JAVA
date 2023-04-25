package sesac.jpaPractice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sesac.jpaPractice.domain.Board;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {

    List<Board> findByTitle(String title);

    void deleteByWriter(String writer); // delete from where writer =#{writer}
}
