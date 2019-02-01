package enums;

public enum MainHeader {
    MAIN_HEADER("EPAM FRAMEWORK WISHES…", "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA"
            + " ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS" +
            " AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

    public String mainTitle;
    public String mainTitleText;

    MainHeader(String mainTitle, String mainTitleText) {
        this.mainTitle = mainTitle;
        this.mainTitleText = mainTitleText;

    }
}
