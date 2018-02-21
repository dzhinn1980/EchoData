package ru.dzhinn.echodata.gwt.client.application.tab;

import ru.dzhinn.echodata.gwt.client.place.NameTokens;
import ru.dzhinn.echodata.gwt.client.place.ParameterTokens;

/**
 * Created by A.Dzhioev on 14.02.2018.
 */
public enum TabTypeEnum {
    PATIENT_VISIT_LIST(NameTokens.VISIT, ParameterTokens.PATIENT_ID, ParameterTokens.TAB_VISIT),
    TEMPLATE(NameTokens.TEMPLATE, ParameterTokens.TEMPLATE_ID, ParameterTokens.TAB_TEMPLATE);

    private String token;
    private String tokenParam;
    private String tabParam;

    TabTypeEnum(String token, String tokenParam, String tabParam) {
        this.token = token;
        this.tokenParam = tokenParam;
        this.tabParam = tabParam;
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

    public static TabTypeEnum byToken(String token) {
        for (TabTypeEnum type : TabTypeEnum.values()) {
            if (type.getToken().equalsIgnoreCase(token)) {
                return type;
            }
        }
        throw new IllegalArgumentException("TabTypeEnum not found by id : " + token);
    }

//    public static TabTypeEnum getTabInfoByParamName(String paramName, String paramValue) {
////        String str = paramName.substring(3);
//        TabTypeEnum tabInfo = null;
//        if (paramName.contains(TabTypeEnum.PATIENT_VISIT_LIST.getTabParam())){
//            tabInfo = TabTypeEnum.PATIENT_VISIT_LIST;
//        } else if (paramName.contains(TabTypeEnum.TEMPLATE.getTabParam())){
//            tabInfo = TabTypeEnum.TEMPLATE;
//        }
//
//        if (tabInfo != null){
//            tabInfo.setTokenParamValue(paramValue);
//        }
//
//        return tabInfo;
//    }


}
