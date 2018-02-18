package com.tr.eds.tests.apis.apiadmin.testcore.pojo.defenitionsresponse.Idresponse

import com.tr.eds.core.service.response.IApiObject
import com.tr.eds.core.utils.Utils
import com.tr.eds.core.swagger.pojo.response.BasePojo

class Readme extends BasePojo implements IApiObject {
   String Readme

    Readme() {
    }


    Readme(String readme) {
        Readme = readme
    }

    String getReadme() {
        return Readme
    }

    void setReadme(String readme) {
        Readme = readme
    }

    @Override
    public String toString() {
        return Utils.getResponseModelAsJSONString(this);
    }
}
