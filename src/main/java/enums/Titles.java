package enums;

// TODO This enum can be splitted on NatureElements, Colors, Metals, etc.
public enum Titles {
    HOME_PAGE_TITLE("Home Page"),
    MAIN_HEADER_TITLE("EPAM FRAMEWORK WISHES…"),
    MAIN_HEADER_TEXT( "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA"
                        + " ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS" +
                        " AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR."),
    SUB_HEADER("JDI GITHUB"),
    CHECK_BOX_WATER("Water"),
    CHECK_BOX_EARTH("Earth"),
    CHECK_BOX_WIND("Wind"),
    CHECK_BOX_FIRE("Fire"),
    RADIO_BUTTON_GOLD("Gold"),
    RADIO_BUTTON_SILVER("Silver"),
    RADIO_BUTTON_BRONZE("Bronze"),
    RADIO_BUTTON_SELEN("Selen"),
    DROP_DOWN_RED("Red"),
    DROP_DOWN_GREEN("Green"),
    DROP_DOWN_BLUE("Blue"),
    DROP_DOWN_YELLOW("Yellow");


    public String title;

    Titles(String title) {
        this.title = title;
    }
}
