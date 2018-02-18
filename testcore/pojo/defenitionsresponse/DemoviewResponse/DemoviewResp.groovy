package com.tr.eds.tests.apis.apiadmin.testcore.pojo.defenitionsresponse.DemoviewResponse

import com.tr.eds.core.service.response.IApiObject
import com.tr.eds.core.utils.Utils
import com.tr.eds.core.swagger.pojo.response.BasePojo


class DemoviewResp extends BasePojo implements IApiObject{

     ArrayList<String> demoviewslist


    @Override
    public String toString() {
        return Utils.getResponseModelAsJSONString(this);
    }
}
