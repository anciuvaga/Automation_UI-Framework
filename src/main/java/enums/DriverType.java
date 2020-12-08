package enums;

public enum DriverType {
    FIREFOX,
    CHROME,
    INTERNET_EXPLORER;

    public static DriverType getByName(String browserName) {
            switch (browserName) {
                case "chrome":
                    return DriverType.CHROME;
                case "firefox":
                    return DriverType.FIREFOX;
                case "iexplorer":
                    return DriverType.INTERNET_EXPLORER;
                default:
                    throw new RuntimeException("Browser Name Key value in configuration.properties is not matched :" + browserName);
            }
        }
    }



