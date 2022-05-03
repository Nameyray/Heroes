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

        get("heroes", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Heroes> heroes = Heroes.getAll();

            model.put("heroes", heroes);
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

            Heroes heroes = new Heroes(name, age, Id, strength, weakness,membership);
            model.put("Heroes", heroes);
            return new ModelAndView(model, "heroes_success.hbs");
        }, new HandlebarsTemplateEngine());

        get("squads", (request, response) ->{
            Map<String, Object> model = new HashMap<>();

            return new ModelAndView(model, "squad.hbs");
        }, new HandlebarsTemplateEngine());


    }


}


