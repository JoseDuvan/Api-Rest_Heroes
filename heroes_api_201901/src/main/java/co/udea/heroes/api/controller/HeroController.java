package co.udea.heroes.api.controller;

import co.udea.heroes.api.model.Hero;
import co.udea.heroes.api.service.HeroServiceInt;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/tour-heroes")
public class HeroController {

    private HeroServiceInt heroService;


    public HeroController(HeroServiceInt heroService) {
        this.heroService = heroService;
    }


    @GetMapping
    @ApiOperation(value = "Buscar Todos los Héroes", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Los Héroes Fueron Buscados", response = Page.class),
            @ApiResponse(code = 400, message = "La Petición Realizada es Inválida"),
            @ApiResponse(code = 500, message = "Error Interno al Procesar la Respuesta")})
    public ResponseEntity<List<Hero>> getHeroes() {
        return ResponseEntity.ok(heroService.getHeroes());
    }


    @GetMapping ("/BuscarTodos/{name}")
    @ApiOperation(value = "Buscar heroes", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Los Héroes Fueron Buscados", response = Page.class),
            @ApiResponse(code = 400, message = "La Petición Realizada es Inválida"),
            @ApiResponse(code = 500, message = "Error Interno al Procesar la Respuesta")})
    public ResponseEntity<List<Hero>> earchHeroesTerm(@PathVariable("name") String name) {
        return ResponseEntity.ok(heroService.searchHeroes(name));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Hero> getHero(@PathVariable("id") int id) {
        return ResponseEntity.ok(heroService.getHero(id));
    }


    @PostMapping("crear")
    public ResponseEntity<Hero> addHero(@RequestBody Hero hero){
        return ResponseEntity.ok(heroService.addHero(hero));
    }


    @PutMapping("actualizar")
    public ResponseEntity<Hero> updateHero(@RequestBody Hero hero){
        return ResponseEntity.ok(heroService.updateHero(hero));
    }


    @GetMapping("consultar404/{id}")
    public ResponseEntity<Hero> getHeroNo404(@PathVariable("id") int id) {
        return ResponseEntity.ok(heroService.getHeroNo404(id));
    }


    @GetMapping("BuscarPorNombre/{name}")
    public ResponseEntity<Hero> getHeroByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(heroService.getHeroByName(name));
    }


    @DeleteMapping("borrar/{id}")
    public void deleteHero(@PathVariable("id") int id) {
        heroService.deleteHero(id);
    }
}