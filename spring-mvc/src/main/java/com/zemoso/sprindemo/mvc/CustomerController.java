package com.zemoso.sprindemo.mvc;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //initbinder to trim whitespaces in all text inputs
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }



    @RequestMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer,
                              BindingResult theBindingResult) {

        //System.out.println("Last name: |"+ theCustomer.getLastName()+ "|");

        System.out.println("Binding result" + theBindingResult);
        System.out.println("\n\n");

        if ( theBindingResult.hasErrors() ) {
            return "customer-form";
        } else {
            System.out.println(theCustomer.getFirstName() + " " + theCustomer.getLastName());
            return "customer-confirmation";
        }
    }
}
