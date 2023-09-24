package dat250assignment1;

import io.javalin.Javalin;

public class App {

    private static final String WEBPAGE = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>Convert units</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "<h1>Unit converter</h1>\n" +
            "<form action=\"/convert\" method=\"post\">\n" +
            "    <fieldset>\n" +
            "    <label for=\"val\">Value:</label>" +
            "    <input id=\"val\" type=\"text\" name=\"value\"><br />\n" +
            "    <label for=\"source-unit\">From unit:</label>\n" +
            "    <select name=\"sunit\" id=\"source-unit\">\n" +
            "        <option value=\"in\">Inches</option>\n" +
            "        <option value=\"ft\">Feet</option>\n" +
            "        <option value=\"mi\">Miles</option>\n" +
            "        <option value=\"m\">Metres</option>\n" +
            "    </select><br />\n" +
            "    <label for=\"target-unit\">To unit:</label>\n" +
            "    <select name=\"tunit\" id=\"target-unit\">\n" +
            "        <option value=\"in\">Inches</option>\n" +
            "        <option value=\"ft\">Feet</option>\n" +
            "        <option value=\"mi\">Miles</option>\n" +
            "        <option value=\"m\">Metres</option>\n" +
            "    </select><br />\n" +
            "    <input type=\"submit\" value=\"Calculate\" />\n" +
            "    </fieldset>\n" +
            "</form>\n" +
            "</body>\n" +
            "</html>";

    private static final double IN_TO_METER = 0.0254;
    private static final double FT_TO_METER = 0.3048;
    private static final double MI_TO_METER = 1609.344;


    public static void main(String[] args) {
        Javalin.create()
                .get("/", ctx -> {
                    ctx.html(WEBPAGE);
                })
                .post("/convert", ctx -> {
                    double value = Double.parseDouble(ctx.formParam("value"));
                    String fromUnit = ctx.formParam("sunit");
                    Unit f = Unit.NAN;
                    String toUnit = ctx.formParam("tunit");
                    Unit t = Unit.NAN;
                    double inMETERs;
                    if (fromUnit.equals("in")) {
                        f = Unit.INCHES;
                    } else if (fromUnit.equals("ft")) {
                        f = Unit.FEET;
                    } else if (fromUnit.equals("mi")) {
                        f = Unit.MILES;
                    } else if (fromUnit.equals("m")) {
                        f = Unit.FEET;
                    } else {
                        inMETERs = Double.NaN;
                    }
                    double result;
                    if (toUnit.equals("in")) {
                        t = Unit.INCHES;
                    } else if (toUnit.equals("ft")) {
                        t = Unit.FEET;
                    } else if (toUnit.equals("mi")) {
                        t = Unit.MILES;
                    } else if (toUnit.equals("m")) {
                        t = Unit.METERS;
                    } else {
                        result = Double.NaN;
                    }
                    ctx.result(Double.toString(convertUnit(value, f, t)));
                })
                .start(9000);
    }


    public static double convertUnit(double value, Unit fromUnit, Unit toUnit) {
        switch (fromUnit) {
            case FEET:
                switch (toUnit) {
                    case INCHES:
                        return value * 12.0;
                    case MILES:
                        return value / 5280.0;
                    case METERS:
                        return value * 0.3048;
                    default:
                        throw new IllegalArgumentException("Unsupported conversion: " + fromUnit + " to " + toUnit);
                }

            case INCHES:
                switch (toUnit) {
                    case FEET:
                        return value / 12.0;
                    case MILES:
                        return value / 63360.0;
                    case METERS:
                        return value * 0.0254;
                    default:
                        throw new IllegalArgumentException("Unsupported conversion: " + fromUnit + " to " + toUnit);
                }

            case MILES:
                switch (toUnit) {
                    case FEET:
                        return value * 5280.0;
                    case INCHES:
                        return value * 63360.0;
                    case METERS:
                        return value * 1609.34;
                    default:
                        throw new IllegalArgumentException("Unsupported conversion: " + fromUnit + " to " + toUnit);
                }

            case METERS:
                switch (toUnit) {
                    case FEET:
                        return value * 3.28084;
                    case INCHES:
                        return value * 39.3701;
                    case MILES:
                        return value * 0.000621371;
                    default:
                        throw new IllegalArgumentException("Unsupported conversion: " + fromUnit + " to " + toUnit);
                }

            default:
                throw new IllegalArgumentException("Unsupported conversion: " + fromUnit + " to " + toUnit);
        }
    }
}


