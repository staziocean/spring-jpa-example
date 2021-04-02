package fr.diginamic.spring.jpa.controller;

import fr.diginamic.spring.jpa.model.Game;
import fr.diginamic.spring.jpa.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("api/games")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    // Requête HTTP GET http://<server_url>/api/games
    @RequestMapping(method = RequestMethod.GET)
    public List<Game> findAll() {
        return gameService.findAll();
    }
}
