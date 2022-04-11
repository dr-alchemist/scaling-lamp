package dralchemist.scaling.lamp.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHandler extends StdDeserializer<Date> {

    public static final Logger log = LoggerFactory.getLogger(DateHandler.class);

    private static final long serialVersionUID = 1L;

    protected DateHandler(Class<?> vc) {
        super(vc);
    }

    public DateHandler() {
        this(null);
    }

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException {
        String date = jsonParser.getText();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd");
            return sdf.parse(date);
        } catch (Exception e) {
            log.error(" Date format error ", e);
            return null;
        }
    }
}
