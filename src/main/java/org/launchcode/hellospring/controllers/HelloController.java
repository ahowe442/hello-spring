package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody //@ResponseBody // Will return a plaintext http response and can be annotated about method. but because
// each method in class utilizes it then we can added it to the class so that the methods inherit this annotation.
//@RequestMapping("hello")// this means that every method in this class should begin with hello
public class HelloController {
//
////     The following controller handle static get requests.
////    Handles requests at path /hello
////    @GetMapping("hello")  //This specifies to SpringBoot that this method can only handle get requests.
////    @ResponseBody // Will return a plaintext http response.
////    public String hello(){
////        return "Hello Spring!";
////    }
//
//    // The following controller handle static get requests.
//    //Handles requests at path /hello/goodbye
//    @GetMapping("goodbye")  //This specifies to SpringBoot that this method can only handle get requests.
//    public String goodbye() {
//        return "goodbye Spring!";
//    }
//    // lives at /hello/hello
//    //Dynamic get request. (accepts data)
//    //handles requests of the form /hello?name=LaunchCode
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})  //This specifies to SpringBoot that these methods can handle both get and post requests.
//    public String helloWithQueryParam(@RequestParam String name) {
//        return "Hello " + name + " !";
//    }
//
//    //Dynamic get request. (accepts data)
//    // Responds to get requests at /hello/LaunchCode
//    // the annotation @PathVariable handler method tells Spring Boot that it's looking for a path
//    // to hello/{variable name}.  Name could be anything that the user enters.
//
//    @GetMapping("{name}")
//    public String helloWithPathParam(@PathVariable String name) {
//        return "Hello, " + name + "!";
//    }
//
//    //This now lives at /hello/form
//    //Sending form data via a form
//    @GetMapping("form")
//    public String helloForm() {
//        return "<html>" +
//                "<body>" +
//                "<form action='hello' >" + //Submits a request to /hello - often form tag includes a method,
//                // the default method is "get". this will be submitted via a get request.  The hello method above which
//                // all set up to handle get requests.
//                "<input type='text' name='name' >" +
//                "<input type='submit' value='Greet me!'> " +
//                "</form>" +
//                "</body>" +
//                "</html>";
//
//    }
//
//    //Sending form data via a form
//    @GetMapping("form1")
//    public String helloForm1() {
//        return "<html>" +
//                "<body>" +
//                "<form action='hello' method='post' >" + //Submits a request to /hello - often form tag includes a method,
//                // the default method is "get". this will be submitted via a get request.  The hello method above which
//                // all set up to handle get requests.
//                "<input type='text' name='name' >" +
//                "<input type='submit' value='Greet me!'> " +
//                "</form>" +
//                "</body>" +
//                "</html>";
//
//    }
//
//
//    //To send data via a simple form in Spring Boot, we’ll set things up like this:
//    //We have a controller method that generates a form at index.
//    //Remember, without an argument, @GetMapping maps to /. On form submission, the data is sent to another path, /hello. We need a controller for that.
//    @GetMapping
//    public String helloForm2() {
//        String html =
//                "<html>" +
//                        "<body>" +
//                        "<form method = 'get' action = '/hello'>" +
//                        "<input type = 'text' name = 'coder' />" +
//                        "<input type = 'submit' value = 'Greet Me!' />" +
//                        "</form>" +
//                        "</body>" +
//                        "</html>";
//        return html;
//    }
//
//    //Controller for the above form data.
//    @GetMapping("hello")
//    public String hello(@RequestParam String coder) {
//        return "Hello, " + coder + "!";
//    }
//    /*
//    Now, you have a controller that can handle the form submission. When the form submits,
//    the input entered in the text box will be passed to the URL via a query string.
//    This is why the controller method above passes in @RequestParam to handle the coder key.
//     */

    //Example from Video
    @GetMapping("form")
    @ResponseBody
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" +
                "<input type='text' name='name'>" +  // name is the identifyer to submit form.
                "<input type='submit' value='greet me'" +
                "</form>" +
                "</body>" +
                "</html";
    }
    // Handler that accepts post requests.
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value="hello" )
    @ResponseBody
    public String printMessage(@RequestParam String name){
        return "Hello" + name + "!";

    }

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

