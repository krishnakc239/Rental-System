package mum.edu.mycar.domain;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class SearchFilter {
    private String zipcode;
    private String category;
    private double min_price;
    private double max_price;

    public SearchFilter(String zipcode, String category, double min_price, double max_price) {
        this.zipcode = zipcode;
        this.category = category;
        this.min_price=min_price;
        this.max_price=max_price;
    }
}
