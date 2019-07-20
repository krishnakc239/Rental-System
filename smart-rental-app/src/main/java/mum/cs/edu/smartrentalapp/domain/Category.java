package mum.cs.edu.smartrentalapp.domain;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private Long id;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private String name;
    List<Category> categories;
    public Category(){
      categories=new ArrayList<>();
        categories.add(new Category(1L,"Car"));
        categories.add( new Category(2L,"Apartment"));
        categories.add(new Category(3L,"Hotel"));
    }
    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public List<Category> getCategories(){
        return  categories;
    }
}
