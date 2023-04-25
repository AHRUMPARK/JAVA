package board.board.controller;


import board.board.domain.BoardEntity;
import board.board.dto.BoardDTO;
import board.board.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class BoardController {


    @Autowired
    MainService mainService;

    @GetMapping("/boards")
    public String getBoard(Model model){
        ArrayList<BoardDTO> boardList = (ArrayList<BoardDTO>) mainService.getBoardList();
        model.addAttribute("list", boardList);
        return "board";
    }

    @GetMapping("/writeBoard")
    public String getGoWrite(){
        return "BoardDetail";
    }

    @PostMapping("/board/write")
    @ResponseBody
    public String postRegister(@RequestBody BoardDTO boardDTO){
        mainService.addWrite(boardDTO);
        return "";
    }

}
