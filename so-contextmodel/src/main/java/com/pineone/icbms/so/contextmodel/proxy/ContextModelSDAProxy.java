package com.pineone.icbms.so.contextmodel.proxy;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pineone.icbms.so.contextmodel.entity.ContextModel;
import com.pineone.icbms.so.contextmodel.pr.Content;
import com.pineone.icbms.so.contextmodel.pr.RetrieveData;
import com.pineone.icbms.so.domain.entity.Domain;
import com.pineone.icbms.so.util.address.AddressStore;
import com.pineone.icbms.so.util.address.ContextAddress;
import com.pineone.icbms.so.util.conversion.DataConversion;
import com.pineone.icbms.so.util.http.ClientService;
import com.withwiz.beach.network.http.message.IHttpResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by melvin on 2016. 8. 2..
 * NOTE: ContextModel 관련 SDA Interface 이용
 */

@Service
public class ContextModelSDAProxy implements ContextModelExProxy {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ContextAddress contextAddress;

    public static ContextModelExProxy newContextModelProxy(){
        return newContextModelProxy();
    }

    //NOTE: SDA에 ContextModel 등록
    @Override
    public String registerContextModel(ContextModel contextModel) {
        //
        String sendData = DataConversion.objectToString(contextModel);
        IHttpResponseMessage message = clientService.requestPostService
                (contextAddress.getAddress() + AddressStore.REGISTER_CONTEXTMODEL, sendData);
        String response = DataConversion.responseDataToString(message);
        return response;
    }

    //NOTE: SDA 에서 ContextModelList 를 조회하기 위해 사용
    @Override
    public List<ContextModel> retrieveContextModelListFromSDA() {
        //
        IHttpResponseMessage message = clientService.requestGetService(
                contextAddress.getAddress() + AddressStore.RETRIEVE_CONTEXTMODEL);
        String readData = new Gson().toJson(message);
        Type type = new TypeToken<List<ContextModel>>(){}.getType();
        List<ContextModel> contextModelList = new Gson().fromJson(readData,type);

        return contextModelList;
    }

    //NOTE : SDA 의 ContextModel 상세조회
    @Override
    public ContextModel retrieveContextModelDetail(String contextModelName) {
        //
        IHttpResponseMessage message = clientService.requestGetService(
                contextAddress.getAddress() + AddressStore.RETRIEVE_CONTEXTMODEL + "/" + contextModelName);
        String readData = DataConversion.responseDataToString(message);
        Type type = new TypeToken<ContextModel>(){}.getType();
        ContextModel contextModel = new Gson().fromJson(readData, type);

        return contextModel;
    }

    //NOTE: ContextModel 의 상황이 발생했는지 질의, 발생한 도메인 리스트 수신
    @Override
    public List<String> retrieveContextModelEvent(String contextModelId) {
        //
//        IHttpResponseMessage message = clientService.requestGetService(
//                contextAddress.getAddress() + AddressStore.RETRIEVE_CONTEXTMODEL_EVENT + "/" + contextModelName);
//        String readData = new Gson().toJson(message);
//        Type type = new TypeToken<List<String>>(){}.getType();
//        List<String> domainIdList = new Gson().fromJson(readData,type);

        List<String> domains = new ArrayList<>();
        //TODO : 일시적 테스트
        if(contextModelId.equals("CM-COMFORT-AIR")){
            IHttpResponseMessage message = clientService.requestGetService(
                    contextAddress.getAddress()  + contextModelId + "2/?p=," );
            String readData = DataConversion.responseDataToString(message);
            Type type = new TypeToken<RetrieveData>(){}.getType();
            RetrieveData retrieveData = new Gson().fromJson(readData,type);
            System.out.println(retrieveData.getTime());
            List<Content> contentList = retrieveData.getContent();
            for(Content content : contentList){
                domains.add(content.getLoc());
                System.out.println(content.getLoc());
            }
//            domains = new ArrayList<>();
        }
        else {
            domains = null;
        }
        return domains;
    }
}
