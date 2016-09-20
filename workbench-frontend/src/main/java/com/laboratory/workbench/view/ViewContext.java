package com.laboratory.workbench.view;

import com.vaadin.navigator.Navigator;

import java.util.Map;

/**
 * @author yim
 * Created by yf on 2016/8/30.
 */
public class ViewContext {
    private String parameters;
    private Map<String,String> parameterMap;
    private String viewName;
    private Navigator navigator;

    public String getParameters() {
        return parameters;
    }

    public String getParameters(String pName){
        return this.parameterMap.get(pName);
    }

    public String getParameters(String pName,String dftVal){
        String v=this.parameterMap.get(pName);
        return v==null?dftVal:v;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public Map<String, String> getParameterMap() {
        return parameterMap;
    }

    public void setParameterMap(Map<String, String> parameterMap) {
        this.parameterMap = parameterMap;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public Navigator getNavigator() {
        return navigator;
    }

    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }
}
