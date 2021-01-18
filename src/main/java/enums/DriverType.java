package enums;

import java.util.stream.Stream;

public enum DriverType {
    FIREFOX("firefox"),
    CHROME("chrome"),
    INTERNET_EXPLORER("iexplorer");

    private String driverType;

    DriverType(String driverType) {
        this.driverType = driverType;
    }


    public static DriverType getByName(String browserName) {
        return Stream.of(DriverType.values()).filter(x -> x.driverType.equals(browserName)).findFirst()
                .orElseThrow(() ->
                        new RuntimeException("Browser name key value in configuration.properties is not matched :" + browserName));

    }

}

