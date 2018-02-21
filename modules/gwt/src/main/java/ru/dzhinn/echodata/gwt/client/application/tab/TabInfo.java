package ru.dzhinn.echodata.gwt.client.application.tab;

import ru.dzhinn.echodata.gwt.client.place.NameTokens;
import ru.dzhinn.echodata.gwt.client.place.ParameterTokens;

/**
 * Created by A.Dzhioev on 13.12.2017.
 */
public class TabInfo {
    private String token;
    private String tokenParam;
    private String tabParam;
    private String tabParamValue;

    public static TabInfo getTabInfoByParamName(String paramName, String paramValue) {
        if (paramName.contains(TabTypeEnum.PATIENT_VISIT_LIST.getTabParam())){
            return new TabInfo(TabTypeEnum.PATIENT_VISIT_LIST, paramValue);
        } else if (paramName.contains(TabTypeEnum.TEMPLATE.getTabParam())){
            return new TabInfo(TabTypeEnum.TEMPLATE, paramValue);
        } else {
            return null;
        }
    }

    public TabInfo(TabTypeEnum tabType, String tabParamValue) {
        this.token = tabType.getToken();
        this.tokenParam = tabType.getTokenParam();
        this.tabParam = tabType.getTabParam();
        this.tabParamValue = tabParamValue;
    }

    public TabInfo(String token, String tokenParam, String tabParam, String tabParamValue) {
        this.token = token;
        this.tokenParam = tokenParam;
        this.tabParam = tabParam;
        this.tabParamValue = tabParamValue;
    }

    public String getToken() {
        return token;
    }

    public String getTokenParam() {
        return tokenParam;
    }

    public String getTabParam() {
        return tabParam;
    }

    public String getTabParamValue() {
        return tabParamValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TabInfo tabInfo = (TabInfo) o;

        if (!token.equals(tabInfo.token)) return false;
        if (!tokenParam.equals(tabInfo.tokenParam)) return false;
        return tabParamValue.equals(tabInfo.tabParamValue);

    }

    @Override
    public int hashCode() {
        int result = token.hashCode();
        result = 31 * result + tokenParam.hashCode();
        result = 31 * result + tabParamValue.hashCode();
        return result;
    }
}
