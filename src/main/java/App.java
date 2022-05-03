import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.staticFileLocation;

public class App {
    public static void main(String[]args) {
        staticFileLocation("/public");
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            return new ModelAndView(model, "layout.hbs");
        }, new HandlebarsTemplateEngine());

        get("heroes", (request, response) ->{
            Map<String, Object> model = new HashMap<>();

            return new ModelAndView(model, "heroes.hbs");
        }, new HandlebarsTemplateEngine());
        get("squads", (request, response) ->{
            Map<String, Object> model = new HashMap<>();

            return new ModelAndView(model, "squad.hbs");
        }, new HandlebarsTemplateEngine());


    }


}


