import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        Heroes liz = new Heroes("Liz", 26, "baking", "bathing", "bakers");
        rachel.deleteHero();
        assertEquals(1, Heroes.getAll().size());
        assertEquals(Heroes.getAll().get(0).getId(), 2);
    }

}
