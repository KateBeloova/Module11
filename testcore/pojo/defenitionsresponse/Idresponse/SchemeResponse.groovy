package com.tr.eds.tests.apis.apiadmin.testcore.pojo.defenitionsresponse.Idresponse

import com.tr.eds.core.service.response.IApiObject
import com.tr.eds.core.utils.Utils
import com.tr.eds.core.swagger.pojo.response.BasePojo


class SchemeResponse extends BasePojo implements IApiObject {
    Scheme scheme

    @Override
    String toString() {
        return Utils.getResponseModelAsJSONString(this);
    }
}
