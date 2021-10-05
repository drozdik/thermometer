package makardr.thermometer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class FakeTemperatureSensorEndpoint {

    private String html = """
            <html>
                <head>
                    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                    <meta http-equiv="refresh" content="5">
                    <title>Термометр</title>
                    <style>
                          body { background-color: #dfdfdf; font-family: Arial, Helvetica, Sans-Serif; Color: #777777; }
                    </style>
                </head>
                <body>
                    <center>
                        <h1>Температура в комнате.</h1>
                    </center>
                    <center>
                        <p> %d градуса </p>
                    </center>
                </body>
            </html>
            """;

    @GetMapping("/current-temperature")
    @ResponseBody
    public String greeting() {
        int temperature = new Random().nextInt(160);
        return html.formatted(temperature);
    }

}
