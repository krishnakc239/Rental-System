package mum.cs.edu.smartrentalapp.domain;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class SearchFIlter {
    private String zipcode;
    private String category;
    private String min_price;
    private String max_price;

    public SearchFIlter(String zipcode, String category, String min_price, String max_price) {
        this.zipcode = zipcode;
        this.category = category;
       this.min_price=min_price;
       this.max_price=max_price;
    }
}
