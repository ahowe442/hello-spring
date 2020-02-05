package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController{

//    // lives at http://localhost:8080/hello
//    @GetMapping("hello")  //Specifies to Spring boot that this method should handle get requests.  This in wired up to be a full fledged request handler.
//    @ResponseBody
//    public String hello(){
//        return "Hello Spring";
//    }

    // lives at http://localhost:8080/goodbye
//    @GetMapping("goodbye")
//    @ResponseBody
//    public String goodbye(){
//        return  "Goodbye Spring";
//    }


    /**** Controllers with parameters ****/
    /**** 10.2.2. Controllers and Query Parameters ****/

    //These routes return a dynamic response based on user input.
    // Handles requests at http://localhost:8080/hello1?name=LaunchCode
//    @GetMapping("hello1")
//    @ResponseBody
//    public String helloWithQueryParam(@RequestParam String name){
//        return "Hello, " + name + "!";
//    }

    // Responds to get requests at /hello2/LaunchCode
//    @GetMapping("hello2/{name}")
//    @ResponseBody
//    public String helloAgain(@PathVariable String name) {
//        return "Hello, " + name + "!";
//    }

    /*****10.3.2. Sending Form Data*****/
//    @GetMapping
//    @ResponseBody
//    public String helloForm() {
//        String html =
//                "<html>" +
//                    "<body>" +
//                        "<form method = 'get' action = '/hello3'>" +
//                            "<input type = 'text' name = 'coder' />" +
//                            "<input type = 'submit' value = 'Greet Me!' />" +
//                        "</form>" +
//                    "</body>" +
//                "</html>";
//        return html;
//    }

    //Data from the form above is sent to the below path.
//    @GetMapping("hello3")
//    @ResponseBody
//    public String hello(@RequestParam String coder) {
//        return "Hello, " + coder + "!";
//    }

    /****
    To be able to submit the form via POST, we’ll need to modify the hello() controller to use @RequestMapping.
    Remember, @RequestMapping can annotate a method that responds to both GET and POST.
     *****/
    // Responds to get and post requests at /hello?name=LaunchCoder
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String hello1(@RequestParam String name, Model model) {
        String greeting = "Hello "+ name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    // Responds to get requests at /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloAgain(@PathVariable String name, Model model) {
        String greeting = "Hello "+ name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @GetMapping
    public String helloForm2() {
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("Java");
        names.add("JavaScript");
        names.add("LaunchCode");
        names.add("Abby");
        model.addAttribute("names", names);
        return "hello-list";
    }
}






