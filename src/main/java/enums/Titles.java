package enums;

// TODO This enum can be splitted on NatureElements, Colors, Metals, etc.
public enum Titles {
    HOME_PAGE_TITLE("Home Page"),
    USER_TABLE_TITLE("User Table"),
    MAIN_HEADER_TITLE("EPAM FRAMEWORK WISHES…"),
    MAIN_HEADER_TEXT( "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA"
                        + " ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS" +
                        " AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR."),
    SUB_HEADER("JDI GITHUB");




    public String title;

    Titles(String title) {
        this.title = title;
    }
}
