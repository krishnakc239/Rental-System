package mum.edu.mycar.controller;

import mum.edu.mycar.domain.Mycar;
import mum.edu.mycar.domain.SearchFilter;
import mum.edu.mycar.service.MyCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mycar")
public class MyCarController {
    @Autowired
    private MyCarService carService;

    @GetMapping("/cars")
    public List<Mycar> getAll() {
        return carService.getAll();
    }

    @GetMapping("filteredcars/{zip}/{min}/{max}")
    public List<Mycar> getAllFilteredCar(Model model, @PathVariable String zip,@PathVariable String min,@PathVariable String max){
      Double min1=new Double(min);
      Double max1=new Double(max);
        return carService.getAllFilteredCar(zip,min1,max1);
    }

    @GetMapping("/cars/all/{vendorId}")
    public List<Mycar> getAllByVendorId(@PathVariable("vendorId") Long id) {
        System.out.println("vendor id :"+ id);
        return carService.findAllByVendorId(id);
    }

    @GetMapping("/cars/{id}")
    public Mycar get(@PathVariable Long id) {
        Mycar mc =  carService.get(id);
       return mc;
    }
    @PostMapping("/cars")
    public Mycar add(@RequestBody Mycar car) {
        carService.save(car);
        return car;

    }
//    @PostMapping("/cars")
//    public RedirectView add(@RequestBody Mycar car) {
//     carService.save(car);
//      return new RedirectView("/cars/" + car.getId());
//    }

    @PutMapping("/cars/{id}")
    public void update(@RequestBody Mycar car)
    {
       carService.update(car);
    }

    @DeleteMapping("/cars/{id}")
    public void delete(@PathVariable Long id) {
        carService.delete(id);
    }

}
