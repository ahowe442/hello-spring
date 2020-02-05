package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class ExerciseStudio {

    //Handler that accepts post requests.
    @RequestMapping(value = "greetingForm", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String createMessage(@RequestParam String name1, String lang){
        String english = "Hello, " + name1 + "!  It's nice that you are here!";
        String french = "Hello "+ name1 + "! This is in French!";
        String spanish = "Hello "+ name1 + "! This is in Spanish!";

        if(lang.equals("english")){
            return english;
        }
        if (lang.equals("french")){
            return "<html>" +
                    "<body>" +
                    "<p>Bonjour</p>" +
                    "<h1>Bonjour </h1>"+ name1 + "<h1>, tu as fait du bon travail avec ce projet!</h1>" +
                    "</body>" +
                    "</html>";
        }
        if (lang.equals("spanish")){
            return "Hola " + name1 +", ¡hiciste un gran trabajo con este proyecto!";
        }
        if (lang.equals("german")){
            return "Hallo " + name1 +", du hast tolle Arbeit mit diesem Projekt geleistet!";
        }
        if (lang.equals("catalan")){
            return "Hola " + name1 + ", vau fer un bon treball amb aquest projecte!";
        }
        else
            return "I'm sorry "+ name1 + " there has been an error! ";
    }

    @GetMapping("form1")
    public String helloForm3(){

        String html = "<html>" +
                "<body>" +
                "<form method = 'get' action = 'greetingForm'>" +
                "<input type = 'text' name = 'name1' />" +
                "\n" +
                "<label for=\"language-select\">Choose a language:</label>\n" +
                "\n" +
                "<select name=\"lang\" id=\"lang-select\">\n" +
                "    <option value=\"\">--Please choose an option--</option>\n" +
                "    <option value=\"english\">English</option>\n" +
                "    <option value=\"french\">French</option>\n" +
                "    <option value=\"spanish\">Spanish</option>\n" +
                "    <option value=\"german\">German</option>\n" +
                "    <option value=\"catalan\">Catalan</option>\n" +
                "</select>" +
                "\n" +
                "<input type = 'submit'; value = 'Greet Me!' />" +
                "</form>" +
                "</body>" +
                "</html>";
        return html;
    }

    @GetMapping("languages")
    @ResponseBody
    public String listLanguages(){
        return "<html>" +
                "<body>" +
                "<h1>Skill Tracker</h1>" +
                "<h2>Here is the list of skills we'd like you to learn</h2>" +
                "<ol>1.  Java</ol>" +
                "<ol>2.  JavaScript</ol>" +
                "<ol>3.  Python</ol>";
    }

    @GetMapping("form5")
    public String enterFormElements(){

        String html = "<html>" +
                "<body>" +
                "<h2>Name: </h2>" +
                "\n" +
                "<form method = 'get' action = 'userEntryForm'>" +
                "<input type = 'text' name = 'name1', value = name />" +
                "\n" +
                "<h2>My Favorite Language: </h2>" +
                "<label for=\"language-select\">Choose a language:</label>\n" +
                "\n" +
                "<select name=\"lang1\" id=\"lang-select\">\n" +
                "    <option value=\"\">--Please choose an option--</option>\n" +
                "    <option value=\"Java\">Java</option>\n" +
                "    <option value=\"Javascript\">JavaScript</option>\n" +
                "    <option value=\"Python\">Python</option>\n" +
                "</select>" +
                "\n" +
                "<h2>My Second Favorite Language: </h2>" +
                "<label for=\"language-select\">Choose a language:</label>\n" +
                "\n" +
                "<select name=\"lang2\" id=\"lang-select\">\n" +
                "    <option value=\"\">--Please choose an option--</option>\n" +
                "    <option value=\"Java\">Java</option>\n" +
                "    <option value=\"Javascript\">JavaScript</option>\n" +
                "    <option value=\"Python\">Python</option>\n" +
                "</select>" +
                "\n" +
                "\n" +
                "<h2>My Third Favorite Language: </h2>" +
                "<label for=\"language-select\">Choose a language:</label>\n" +
                "\n" +
                "<select name=\"lang3\" id=\"lang-select\">\n" +
                "    <option value=\"\">--Please choose an option--</option>\n" +
                "    <option value=\"Java\">Java</option>\n" +
                "    <option value=\"Javascript\">JavaScript</option>\n" +
                "    <option value=\"Python\">Python</option>\n" +
                "</select>" +
                "<input type = 'submit'; value = 'Submit Favorites' />" +
                "</form>" +
                "</body>" +
                "</html>";
        return html;
    }
    //Handler that accepts post requests.
    @RequestMapping(value = "userEntryForm", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String createMessage(@RequestParam String name1, String lang1, String lang2, String lang3){
        String html = "<html>" +
                "<body>" +
                "<h1>"+name1+"</h1>" +
                "<p>" +
                "<ol>"+lang1+"</ol>" +
                "<ol>"+lang2+"</ol>" +
                "<ol>"+lang3+"</ol>" +
                "</p>" +
                "</body>" +
                "</html>";
        return html;
    }
}
