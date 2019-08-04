package co.udea.heroes.api.service;

import co.udea.heroes.api.model.Hero;
import co.udea.heroes.api.repository.HeroRepository;
import co.udea.heroes.api.exception.DataNotFoundException;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Optional;

@Service
public class HeroService implements HeroServiceInt{

    private HeroRepository heroRepository;

    public HeroService(HeroRepository heroRepository){
        this.heroRepository = heroRepository;
    }

    private final Logger log = LoggerFactory.getLogger(HeroService.class);


    @Override
    public List<Hero> getHeroes(){
        return heroRepository.findAll();
    }


    @Override
    public Hero getHero(int id) {
        Optional<Hero> posibleHero = heroRepository.findById(id);
        if(posibleHero.isPresent()){
            return posibleHero.get();
        }else {
            log.error("No Existe un Héroe Asociado al ID Ingresado");
            throw new DataNotFoundException("NNo Existe un Héroe Asociado al ID Ingresado: "+ id);}
    }


    @Override
    public Hero getHeroNo404(int id) {
        Optional<Hero> posibleHero = heroRepository.findById(id);
        if(posibleHero.isPresent()){
            return posibleHero.get();
        }else {
            log.error("No Existe un Héroe Asociado al ID Ingresado - Mensaje: 404 Not Found");
            throw new DataNotFoundException("No Existe un Héroe Asociado al ID Ingresado: "+ id +" Mensaje: Error 404 Not Found");        }
    }


    @Override
    public Hero getHeroByName(String name) {
        Optional<Hero> posibleHero = heroRepository.findByName(name);
        if(posibleHero.isPresent()){
            return posibleHero.get();
        }else {
            return null;
        }
    }


    @Override
    public List<Hero> searchHeroes(String name) {
        return heroRepository.findAllByNameContains(name);

    }


    @Override
    public Hero addHero(Hero hero) {
        return heroRepository.save(hero);
    }


    @Override
    public Hero updateHero(Hero hero) {
        return heroRepository.save(hero);
    }


    @Override
    public void deleteHero(int id) {
        Optional<Hero> posibleHero = heroRepository.findById(id);
        if(posibleHero.isPresent()){
            heroRepository.delete(posibleHero.get());
        }else {
            log.error("No Existe un Héroe Asociado al ID Ingresado");
            throw new DataNotFoundException("No Existe un Héroe Asociado al ID Ingresado: "+ id);}
    }
}
