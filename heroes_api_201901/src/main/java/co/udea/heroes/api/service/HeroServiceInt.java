package co.udea.heroes.api.service;

import co.udea.heroes.api.model.Hero;
import java.util.List;

public interface HeroServiceInt {

    public List<Hero> getHeroes();

    public Hero getHero(int id);

    public Hero getHeroNo404(int id);

    public Hero getHeroByName(String name);

    public Hero addHero(Hero hero);

    public Hero updateHero(Hero hero);

    public void deleteHero(int id);

    public List<Hero> searchHeroes(String name);
}
