package board.board.service;


import board.board.domain.BoardEntity;
import board.board.dto.BoardDTO;
import board.board.dto.Write;
import board.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainService {

    @Autowired
    private BoardRepository boardRepository;

    public List<BoardDTO> getBoardList(){
        List<BoardEntity> result = boardRepository.findAll();
        List<BoardDTO> boards = new ArrayList<BoardDTO>();

        for ( int i = 0; i < result.size(); i++ ){
            BoardDTO board = new BoardDTO();
            board.setId(result.get(i).getId());
            board.setTitle(result.get(i).getTitle());
            board.setContent(result.get(i).getContent());

            boards.add(board);
        }
        return boards;
    }

    // 서비스에서 dto에 값을 담아서 보낸다. 컨트롤러에서 할건지 여기서 할건지 정하세요
    public void addWrite(BoardDTO boardDTO){
        BoardEntity board = new BoardEntity();
        board.setId(boardDTO.getId());
        board.setPw(boardDTO.getPw());
        board.setTitle(boardDTO.getTitle());
        board.setContent(boardDTO.getContent());

        boardRepository.save(board);
    }
}
