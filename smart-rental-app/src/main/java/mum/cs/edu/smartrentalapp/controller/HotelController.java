package mum.cs.edu.smartrentalapp.controller;

import mum.cs.edu.smartrentalapp.domain.Hotel;
import mum.cs.edu.smartrentalapp.domain.SearchFIlter;
import mum.cs.edu.smartrentalapp.domain.rent.Rent;
import mum.cs.edu.smartrentalapp.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class HotelController {

    @Autowired
    private HotelService service;

    @GetMapping("available/hotels/")
    public String hotelList(Model model, HttpSession session){
        if(session.getAttribute("filter")!=null){
            SearchFIlter filter = (SearchFIlter) session.getAttribute("filter");
            List<Hotel> hotels = service.filterList(filter);
            System.out.println(hotels);
            if (hotels.isEmpty()) {
                model.addAttribute("msg","No Such Result Found !");

            }
            else{
                model.addAttribute("hotels",hotels);
            }
        }
        return "views/hotels/hotellist";
    }

    @GetMapping("/viewHotel/{id}")
    public String singleHotel(Model model, @PathVariable Long id){
        Hotel hotel=service.getOne(id);
        model.addAttribute("singleHotel",hotel);
        model.addAttribute("rent",new Rent());
        return "views/hotels/singleHotel";

    }
}
