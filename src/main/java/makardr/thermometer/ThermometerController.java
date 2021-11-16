package makardr.thermometer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.ListIterator;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

@Controller
public class ThermometerController {

    private List<Integer> values = List.of(13);
    private ListIterator<Integer> iterator = values.listIterator();

    private final String html = """
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

    @GetMapping
    @ResponseBody
    public String currentTemperature() {
        return html.formatted(getNextValue());
    }

    private int getNextValue() {
        if (!iterator.hasNext()) {
            resetIterator();
        }
        return iterator.next();
    }

    private void resetIterator() {
        iterator = values.listIterator();
    }

    @PostMapping
    @ResponseBody
    public void setupResponses(@RequestParam(name = "values") String valuesString) {
        values = stream(valuesString.split(","))
                .map(Integer::parseInt)
                .collect(toList());
        resetIterator();
    }
}
