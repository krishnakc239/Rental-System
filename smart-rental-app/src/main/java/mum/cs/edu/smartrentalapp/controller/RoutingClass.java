package mum.cs.edu.smartrentalapp.controller;

import org.springframework.web.servlet.ModelAndView;

public class  RoutingClass {



    public static ModelAndView routingServices(String url){


            return new ModelAndView("redirect:"+url);

//        if(session.getAttribute("filter")!=null){
//            session.removeAttribute("filter");
//        }
//        if(searchFilter.getCategory().equals("1")){
//            session.setAttribute("filter",searchFilter);
//            return new ModelAndView("redirect:/available/cars/");
//        }
//        else if(searchFilter.getCategory().equals("2")){
//            return new ModelAndView("redirect:/available/apartment/");
//        }else{
//            return new ModelAndView("redirect:/available/hotels/");
//        }
//    }
    }
}
