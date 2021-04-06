package fr.diginamic.spring.jpa.controller;

import fr.diginamic.spring.jpa.model.Game;
import fr.diginamic.spring.jpa.service.GameService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/games")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    // Requête HTTP GET http://<server_url>/api/games
    @GetMapping
    public List<Game> findAll() {
        return gameService.findAll();
    }

    // Requête HTTP POST http://<server_url>/api/games
    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public Game create(@RequestBody Game game) {
        return gameService.create(game);
    }

    // Requête HTTP PUT http://<server_url>/api/games/:id -> Body = JSON
    // @RequestMapping(method = RequestMethod.PUT...
    @PutMapping("{id}")
    public Game update(@PathVariable(name = "id") Long id, @RequestBody Game game) {
        game.setId(id);
        return gameService.update(game);
    }
}
