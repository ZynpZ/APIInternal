package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   //Getter and Setter lari otomatik getiriyor ve toString'i de oluşturuyor
@NoArgsConstructor // parametresiz cons.ları oluşturuyor
@AllArgsConstructor //tüm cons.ları oluşturuyor

public class PojoHerokuappBooking {

    /*
    {
          "firstname":"Ahmet",
          "lastname":"Bulut",
          "totalprice":500,
          "depositpaid":false,
          "bookingdates":{
                 "checkin":"2021-06-01",
                 "checkout":"2021-06-10"
                          }
           ,
          "additionalneeds":"wi-fi"
                                      }
     */
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private PojoHerokuappBookingDates bookingdates; // daha önce oluşturduğumuz booking dates classı
    private String additionalneeds;




}
