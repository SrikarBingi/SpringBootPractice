package com.gfg.first;

import java.beans.PropertyEditorSupport;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// @Controller
@RestController //Restcontroller = controller+ResponseBody
@RequestMapping (value="/api")
public class SampleController {

    @InitBinder
    protected void initBinder(DataBinder binder){
        binder.registerCustomEditor(String.class,  "firstName",new FirstNamePropertyEditor());
    }

    // @ResponseBody
    // @GetMapping(path="/fetchUser")
    // public String getUserDetails(@RequestParam(name = "firstName") String firstName,@RequestParam(name="lastName", required = false) String lastName, @RequestParam(name="age") int age){
    //     return "fetched details firstName : "+firstName+" lastName : "+lastName+" age : "+age;
    // }

    @GetMapping(path="/fetchUser/{firstName}")
    public ResponseEntity<String> getUserDetails(@PathVariable (value="firstName") String firstName){
        return ResponseEntity.status(HttpStatus.OK).body(firstName);
    }
}