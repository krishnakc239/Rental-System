package mum.cs.edu.smartrentalapp.controller;

import mum.cs.edu.smartrentalapp.domain.Mycar;
import mum.cs.edu.smartrentalapp.domain.apartment.Apartment;
import mum.cs.edu.smartrentalapp.domain.user.User;
import mum.cs.edu.smartrentalapp.service.ApartmentService;
import mum.cs.edu.smartrentalapp.service.MyCarService;
import mum.cs.edu.smartrentalapp.service.UserService;
import mum.cs.edu.smartrentalapp.utils.CategoryConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CrudController {
    @Autowired
    private ApartmentService apartmentService;

    @Autowired
    private MyCarService myCarService;
    @Autowired
    private UserService userService;

    @GetMapping("/add/{type}")
    public ModelAndView showNewForm(@PathVariable("type") String type) {
        return getAddForm(type);
    }

    public ModelAndView getAddForm(String type){
        ModelAndView modelAndView = new ModelAndView();
        if (type.equalsIgnoreCase(CategoryConstants.APARTMENT)){
            modelAndView.addObject("apartment", new Apartment());
            modelAndView.setViewName("views/apartment/apartment-form");
            }
        else if (type.equalsIgnoreCase(CategoryConstants.CAR)) {
            modelAndView.addObject("car", new Mycar());
            modelAndView.setViewName("views/cars/car-form");
        }else if (type.equalsIgnoreCase(CategoryConstants.HOTEL)) {
//            modelAndView.addObject("hotel", new Apartment());
            modelAndView.setViewName("views/home/hotel-form");
        }
        return modelAndView;
    }
    @PostMapping("/addNew/APARTMENT")
    public ModelAndView addApartment(@ModelAttribute Apartment apartment){
        ModelAndView modelAndView = new ModelAndView();
            apartmentService.save(apartment);
            List<Apartment> apartmentList = apartmentService.getApartments();
            modelAndView.addObject("apartments", apartmentList);
            modelAndView.setViewName("views/apartment/apartmentTable");

        return modelAndView;

    }

    @PostMapping("/addNew/CAR")
    public ModelAndView addApartment(@ModelAttribute Mycar mycar){
        ModelAndView modelAndView = new ModelAndView();
        myCarService.save(mycar);
        System.out.println("car saved !!!!!!!!!!");
        List<Mycar> mycarList = myCarService.getAll();
        modelAndView.addObject("cars", mycarList);
        modelAndView.setViewName("views/cars/carTable");
        return modelAndView;

    }

    @PostMapping("/add/user")
    public ModelAndView addApartment(@ModelAttribute User user){
        ModelAndView modelAndView = new ModelAndView();
        userService.add(user);
        System.out.println("car saved !!!!!!!!!!");
        List<User> userList = userService.getUsers();
        modelAndView.addObject("users", userList);
        modelAndView.setViewName("views/cuser/userTable");
        return modelAndView;

    }
//    @PostMapping("/addNew/{type}")
//    public ModelAndView addApartment(@PathVariable("type") String type, @ModelAttribute Apartment apartment){
//        return getViewAfterAdd(type,apartment);
//
//    }
//
//    public ModelAndView getViewAfterAdd(String type){
//        ModelAndView modelAndView = new ModelAndView();
//        if (type.equalsIgnoreCase(CategoryConstants.APARTMENT)){
//            apartmentService.save(apartment);
//            List<Apartment> apartmentList = apartmentService.getApartments();
//            modelAndView.addObject("apartments", apartmentList);
//            modelAndView.setViewName("views/home/accesoriesTable");
//
//        }else if (type.equalsIgnoreCase(CategoryConstants.CAR)){
//            System.out.println("inside addnew car !!!!!!!!");
//
//
//        }
//        return modelAndView;
//    }
    @GetMapping("/edit/{type}/{id}")
    public ModelAndView showUpdateForm(@PathVariable("type") String type, @PathVariable("id") long id, Model model) {
        System.out.println("type ===="+ type);
        return getRequiredViewForUpdate(type,id);

    }

    @PostMapping("/update/APARTMENT/{id}")
    public String updateApartment(@PathVariable("id") long id, Apartment apartment, BindingResult result,
                            Model model) {
        if (result.hasErrors()) {
            apartment.setId(id);
            return "update-apartment";
        } else {
            apartmentService.save(apartment);
            model.addAttribute("apartments", apartmentService.getApartments());
            return "views/apartment/apartmentTable";
        }
    }
    @PostMapping("/update/CAR/{id}")
    public String updateApartment(@PathVariable("id") long id, Mycar car, BindingResult result,
                            Model model) {
        if (result.hasErrors()) {
            car.setId(id);
            return "views/cars/update-car";
        } else {
            myCarService.save(car);
            model.addAttribute("cars", myCarService.getAll());
            return "views/cars/carTable";
        }
    }
//    @PostMapping("/add/user/")
//    public String updateApartment(User user, BindingResult result,
//                            Model model) {
//        if (result.hasErrors()) {
//            user.setId(user);
//            return "update-apartment";
//        } else {
//            myCarService.save(user);
//            model.addAttribute("cars", myCarService.getAll());
//            return "views/home/carTable";
//        }
//    }
    @GetMapping("/delete/{type}/{id}")
    public ModelAndView deleteApartment(@PathVariable("type") String type,@PathVariable("id") long id) {
        return getRequiredViewForDelete(type,id);
    }

    @GetMapping("/showDetail/{type}/{vid}")
    public ModelAndView showDetail(@ModelAttribute("category") String category,
                             @PathVariable("type") String type,
                                   @PathVariable("vid") Long vid){
        return getRequiredViewForDetail(type,vid);

    }
    public ModelAndView getRequiredViewForDetail(String type,Long vid){
        ModelAndView modelAndView = new ModelAndView();

        System.out.println("type :"+ type+" id:"+ vid);
        if (type.equalsIgnoreCase(CategoryConstants.APARTMENT)) {
            List<Apartment> apartmentList = apartmentService.getApartmentsByVendorId(vid);
            modelAndView.setViewName("views/apartment/apartmentTable");
            modelAndView.addObject("apartments", apartmentList);
        }else if (type.equalsIgnoreCase(CategoryConstants.CAR)){
            List<Mycar> mycarList = myCarService.getCarsByVendorId(vid);
            modelAndView.addObject("cars", mycarList);
            modelAndView.setViewName("views/cars/carTable");

        }else if (type.equalsIgnoreCase(CategoryConstants.HOTEL)){
//            List<> mycarList = myCarService.getAll();
//            modelAndView.addObject("cars", mycarList);
        }
        return modelAndView;
    }

    public ModelAndView getRequiredViewForDelete(String type, Long id){
        ModelAndView model = new ModelAndView();
        if (type.equalsIgnoreCase(CategoryConstants.APARTMENT)){
            apartmentService.delete(id);
            model.addObject("apartments", apartmentService.getApartments());
            model.setViewName("views/apartment/apartmentTable");
            return model;
        }
        else if (type.equalsIgnoreCase(CategoryConstants.CAR)){
            System.out.println("car going to be deleted !!!");
            myCarService.delete(id);
            model.addObject("cars", myCarService.getAll());
            model.setViewName("views/cars/carTable");
            return model;
        }else {
            return model;
        }
    }
    public ModelAndView getRequiredViewForUpdate(String type, Long id){
        ModelAndView model = new ModelAndView();
        if (type.equalsIgnoreCase("APARTMENT")){
            Apartment apartment = apartmentService.get(id);
            model.addObject("apartment", apartment);
            model.setViewName("views/apartment/update-apartment");
            return model;
        }
        else if (type.equalsIgnoreCase("CAR")){
            Mycar mycar = myCarService.get(id);
            model.addObject("car", mycar);
            model.setViewName("views/cars/update-car");
            return model;
        }else {
            return model;
        }
    }
}
