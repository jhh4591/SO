package com.pineone.icbms.so.service.pr;


import java.util.List;

/**
 * Created by melvin on 2016. 8. 22..
 */
public class ServiceTransFormObject {

    public ServiceTransFormObject(){};

    public ServiceTransFormObject(String name){
        this.name = name;
    }
    private String id;
    private String name;
    private List<String> virtualObjectIdList;
    private String virtualObjectService;
    private String status;
    private String createTime;
    private String modifiedTime;




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

    public List<String> getVirtualObjectIdList() {
        return virtualObjectIdList;
    }

    public void setVirtualObjectIdList(List<String> virtualObjectIdList) {
        this.virtualObjectIdList = virtualObjectIdList;
    }

    public String getVirtualObjectService() {
        return virtualObjectService;
    }

    public void setVirtualObjectService(String virtualObjectService) {
        this.virtualObjectService = virtualObjectService;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public ServiceTransFormObject(String id, String name, List<String> virtualObjectIdList, String virtualObjectService, String status) {
        this.id = id;
        this.name = name;
        this.virtualObjectIdList = virtualObjectIdList;
        this.virtualObjectService = virtualObjectService;
        this.status = status;
    }

    public ServiceTransFormObject(String id, String name, List<String> virtualObjectIdList, String virtualObjectService, String status, String createTime, String modifiedTime) {
        this.id = id;
        this.name = name;
        this.virtualObjectIdList = virtualObjectIdList;
        this.virtualObjectService = virtualObjectService;
        this.status = status;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
    }

    @Override
    public String toString() {
        return "ServiceTransFormObject{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", virtualObjectIdList=" + virtualObjectIdList +
                ", virtualObjectService='" + virtualObjectService + '\'' +
                ", status='" + status + '\'' +
                ", createTime='" + createTime + '\'' +
                ", modifiedTime='" + modifiedTime + '\'' +
                '}';
    }
}