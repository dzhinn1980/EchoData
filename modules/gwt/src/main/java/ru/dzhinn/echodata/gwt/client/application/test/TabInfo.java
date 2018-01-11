package ru.dzhinn.echodata.gwt.client.application.test;

/**
 * Created by A.Dzhioev on 13.12.2017.
 */
public class TabInfo {
    private String token;
    private String tokenParam;
    private String tokenParamValue;

    public TabInfo(String token, String tokenParam, String tokenParamValue) {
        this.token = token;
        this.tokenParam = tokenParam;
        this.tokenParamValue = tokenParamValue;
    }

    public String getToken() {
        return token;
    }

    public String getTokenParam() {
        return tokenParam;
    }

    public String getTokenParamValue() {
        return tokenParamValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TabInfo tabInfo = (TabInfo) o;

        if (!token.equals(tabInfo.token)) return false;
        if (!tokenParam.equals(tabInfo.tokenParam)) return false;
        return tokenParamValue.equals(tabInfo.tokenParamValue);

    }

    @Override
    public int hashCode() {
        int result = token.hashCode();
        result = 31 * result + tokenParam.hashCode();
        result = 31 * result + tokenParamValue.hashCode();
        return result;
    }
}
