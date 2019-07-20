package mum.cs.edu.smartrentalapp.controller;

import mum.cs.edu.smartrentalapp.domain.Mycar;
import mum.cs.edu.smartrentalapp.domain.SearchFIlter;
import mum.cs.edu.smartrentalapp.domain.apartment.Apartment;
import mum.cs.edu.smartrentalapp.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ApartmentController {
    @Autowired
    private ApartmentService apartmentService;

    @GetMapping("/showCategoryDetail")
    public String showCategoryDetail(Model model){
        List<Apartment> apartmentList= apartmentService.getApartments();
        model.addAttribute("apartments",apartmentList);
        model.addAttribute("category","");
        return "views/apartment/apartmentTable";

    }

    @GetMapping("/viewApartment/{id}")
    public String singleIntemDisplay(Model model, @PathVariable Long id){
        Apartment apartment=apartmentService.get(id);
        model.addAttribute("singleApartment",apartment);
        return "views/apartment/singleApartment";

    }

//    @GetMapping("/available/apartment/")
//    public String carsList(Model model){
//        List<Mycar> cars = carService.getAll();
////        model.addAttribute("cars",cars);
//        return "test";
//    }
@GetMapping("/available/apartment/")
public String apartmentList(Model model, HttpSession session, WebRequest request){
    if(session.getAttribute("filter")!=null){
        SearchFIlter filter = (SearchFIlter) session.getAttribute("filter");
        List<Apartment> apartments = apartmentService.filterList(filter);
        if (apartments.isEmpty()) {
            System.out.println("apartment list found !!!!!!!!!!!!!");
            model.addAttribute("msg","No Such Result Found !");

        }
        else{
            System.out.println("apartemnet slis "+ apartments);
            model.addAttribute("apartments",apartments);
        }
    }
    return "views/apartment/apartmentList";
}
}
