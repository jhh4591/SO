package com.pineone.icbms.so.bizcontext.logic;

import com.pineone.icbms.so.bizcontext.proxy.BizContextProxy;
import com.pineone.icbms.so.bizcontext.proxy.BizContextSDAProxy;
import com.pineone.icbms.so.domain.entity.Domain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by melvin on 2016. 8. 3..
 * NOTE: 다음수업에 필요한 PC의 수와 현재 PC 수를 조회해서 키보드의 부족한 개수를 도출
 */

@Service
public class LackPCBizLogic extends AbstractBizContextLogic{

//    public static LackPCBizLogic newLackPCBizLogic(){
//        return new LackPCBizLogic();
//    }

    @Autowired
    private BizContextProxy bizContextProxy ;

    @Override
    public int retrieveNeedQuantity(Domain domain){
        //
        int currentValue = bizContextProxy.retrieveCurrentClassPCAmount(domain);
        int nextValue = bizContextProxy.retrieveNextClassPCAmount(domain);

        return nextValue - currentValue;
    }

}
