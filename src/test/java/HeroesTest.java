import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class HeroesTest {
    @Test
    public void heroesObjectIsCorrectlyCreated_true() {
        Heroes Hero = new Heroes("Rachel", 21, "Good cook", "Procrastinating", "cooks");
        assertEquals(true, Hero instanceof Heroes);
    }
    @Test
    public void allHeroesContainsAllHeroes_true() {
        Heroes Hero = new Heroes("Rachel", 21, "Good cook", "Procrastinating", "cooks");
        Heroes secondHero = new Heroes("Liz", 26, "baking", "bathing", "bakers");
        Heroes thirdHero = new Heroes("Grace", 24, "nursing", "cooking", "nurses");
        assertEquals(true, Hero.getAll().contains(Hero));
        assertEquals(true, Hero.getAll().contains(secondHero));
        assertEquals(true, Hero.getAll().contains(thirdHero));
    }
    @Test
    public void getId_heroInstantiatesWithAnID_1() throws Exception {
        Heroes Hero = new Heroes("Rachel", 21, "Good cook", "Procrastinating", "cooks");
        Heroes secondHero = new Heroes("Liz", 26, "baking", "bathing", "bakers");
        Heroes thirdHero = new Heroes("Grace", 24, "nursing", "cooking", "nurses");

        assertEquals(2, Heroes.findById(secondHero.getId()).getId());
    }

    private Heroes setUpNewHero(){
        return new Heroes("Rachel", "21", "Good cook", "procrastinating", "");
    }
    @Test
    public void delete_deleteASpecificHero() throws Exception{
        Heroes rachel = setUpNewHero();
        Heroes secondHero = new Heroes("Liz", 26, "baking", "bathing", "bakers");
        Heroes thirdHero = new Heroes("Grace", 24, "nursing", "cooking", "nurses");
        rachel.deleteHero();
        assertEquals(1, Heroes.getAll().size());
        assertEquals(Heroes.getAll().get(0).getId(), 2);
    }
    @Test
    public void updateChangesHeroContent() throws Exception {
        Heroes heroes = setUpNewHeroes();

        int formerId = heroes.getId();
        String formerName = heroes.getmName();
        int formerAge = heroes.getmAge();
        String formerSpecialPower = heroes.getmSpecialPower();
        String formerWeakness = heroes.getmWeakness();

        heroes.setmName("Ilham");
        heroes.setmAge(20);
        heroes.setmSpecialPower("Kitchen");
        heroes.setmWeakness("Laziness");

        assertEquals(formerId, heroes.getId());
        assertNotEquals(formerName, heroes.getmName());
        assertNotEquals(formerAge, heroes.getmAge());
        assertNotEquals(formerSpecialPower, heroes.getmSpecialPower());
        assertNotEquals(formerWeakness, heroes.getmWeakness());
    }
    private Heroes setUpNewHeroes(){
        return new Heroes("Rachel", 26, "Super Coder", "My Patience", "ForexTraders");
    }
    @Test
    public void squad_ensuresHeroChoosesASquad(){
        Heroes Rachel = setUpNewHeroes();
        Squads avengers = setUpNewSquads();
        boolean exists = false;
        for(Heroes heroes: avengers.getHeroes()){
            if (avengers.doesHeroesExist(Rachel)){
                System.out.println(heroes + "exists");
                exists = true;
            }
        }
        if(!exists){
            avengers.getHeroes().add(Rachel);
        }

        assertEquals(Rachel, avengers.getHeroes().get(0));
    }
        private Squads setUpNewSquads(){
            return new Squads("avengers", "Prepare food");
        }

    }
