package boxvi.bqmongo.config;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseMessage {

    private String title;
    private String text;
    private String icon;
    private Object data;

    public ResponseMessage() {
    }

}
