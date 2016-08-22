package com.pineone.icbms.so.contextmodel.entity;

import java.util.List;

/**
 * Created by melvin on 2016. 7. 20..
 * NOTE: Logic 에서 사용할 contextModel Entity
 */
public class ContextModel {

    private String id;
    private String name;
    private List<String> domainIdList;
    private List<String> contextInformationIdList;
    private String contextType;

    public ContextModel() {
    }

    public ContextModel(String id, String name, List<String> domainIdList, List<String> contextInformationIdList, String contextType) {
        this.id = id;
        this.name = name;
        this.domainIdList = domainIdList;
        this.contextInformationIdList = contextInformationIdList;
        this.contextType = contextType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<String> getDomainIdList() {
        return domainIdList;
    }

    public void setDomainIdList(List<String> domainIdList) {
        this.domainIdList = domainIdList;
    }

    public List<String> getContextInformationIdList() {
        return contextInformationIdList;
    }

    public void setContextInformationIdList(List<String> contextInformationIdList) {
        this.contextInformationIdList = contextInformationIdList;
    }

    public String getContextType() {
        return contextType;
    }

    public void setContextType(String contextType) {
        this.contextType = contextType;
    }
}
