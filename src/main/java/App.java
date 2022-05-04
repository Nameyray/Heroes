import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[]args) {
        staticFileLocation("/public");
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();


            return new ModelAndView(model, "layout.hbs");
        }, new HandlebarsTemplateEngine());

        get("heroes", (request, response) ->{
            Map<String, Object> model = new HashMap<>();
            ArrayList<Heroes> foundHero = Heroes.getAll();
            model.put("heroes",foundHero);


            return new ModelAndView(model, "heroes.hbs");
        }, new HandlebarsTemplateEngine());
        get("/heroes/list", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Heroes> Hero = Heroes.getAll();

            model.put("heroes", Hero);
            return new ModelAndView(model, "allheroes.hbs");
        }, new HandlebarsTemplateEngine());
        post("/allheroes/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Heroes> Hero = Heroes.getAll();

            model.put("heroes", Hero);
            return new ModelAndView(model, "allheroes.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes/:id/update", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToEdit = Integer.parseInt(request.params("id"));
            Heroes editHero = Heroes.findById(idOfHeroToEdit);
            model.put("editHero", editHero);
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String age = request.queryParams("age");
            String Id = request.queryParams("Id");
            String strength = request.queryParams("special-power");
            String weakness = request.queryParams("weakness");
            String membership = request.queryParams("squad-membership");

            Heroes heroes = new Heroes(name, age, Id, strength, weakness);
            model.put("Heroes", heroes);
            return new ModelAndView(model, "heroes_success.hbs");
        }, new HandlebarsTemplateEngine());

        get("squads", (request, response) ->{
            Map<String, Object> model = new HashMap<>();

            return new ModelAndView(model, "squad.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads/list", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Squads> squads = Squads.getAll();

            model.put("squads", squads);
            return new ModelAndView(model, "allsquads.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            int idOfListToFind = Integer.parseInt(request.params("id"));
            Squads foundSquad = Squads.findById(idOfListToFind);
            Heroes foundHero = Heroes.findById(idOfListToFind);


            model.put("Squads",foundSquad);
            model.put("Heroes", foundHero);

            return new ModelAndView(model, "squaddetail.hbs");
        }, new HandlebarsTemplateEngine());

        post("/squads/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String squad = request.queryParams("squad");
            String cause = request.queryParams("cause");
            Squads newSquad = new Squads(squad, cause);
            model.put("squad",squad);
            model.put("cause", cause);

            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

    }
}


