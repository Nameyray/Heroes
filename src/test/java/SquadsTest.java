import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquadsTest {
    @Test
    public void instantiatesSquadCorrectly_true() {
        Heroes heroes = new Heroes("Rachel", 21, "Good cook", "Procrastinating", "cooks");
        Squads squads = new Squads("Cooks", "cooking");
        assertEquals(true, squads instanceof Squads);
    }

    @Test
    public void checksIfSquadIsLimitedToAMaxOf5Heroes_true() {
        Heroes rachel = new Heroes("Rachel", 21, "Good cook", "Procrastinating", "cook");
        Heroes brian = new Heroes("Brian", 27, "Pilot", "Never broke", "Wings");
        Heroes moriell = new Heroes("Moriell", 1, "playing", "sleeping", "gaming");
        Heroes nic = new Heroes("Nic", 24, "Web Developer", "Never broke", "BinaryGuy");
        Heroes shal = new Heroes("Shal", 16, "Music", "cleaning", "DJ");
        Heroes grace = new Heroes("Grace", 24, "Nursing", "Never broke", "Nurses");

        Squads avengers = new Squads("Developers", "coding");
        avengers.setHeroes(rachel);
        avengers.setHeroes(brian);
        avengers.setHeroes(moriell);
        avengers.setHeroes(nic);
        avengers.setHeroes(shal);
    }
    @Test
    public void checksIfHeroAppearsInOnlyOneSquadAtATime_true() {
        Heroes shal = new Heroes("Shal", 16, "Music", "cleaning", "DJ");
        Heroes grace = new Heroes("Grace", 24, "Nursing", "Never broke", "Nurses");

        Squads nurses = new Squads("Nurses", "Nursing");
        Squads music = new Squads("Music", "DJ");
        nurses.setHeroes(grace);
        music.setHeroes(shal);
    }
    @Test
    public void checksIfSquadsCanAddHeroes_true() {
        Heroes shal = new Heroes("Shal", 16, "Music", "cleaning", "DJ");
        Heroes grace = new Heroes("Grace", 24, "Nursing", "Never broke", "Nurses");
        Squads nurses = new Squads("Nurses", "Nursing");

        nurses.setHeroes(shal);
        nurses.setHeroes(grace);
        assertEquals(true, nurses.getHeroes().contains(shal));
    }

}