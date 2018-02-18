package com.tr.eds.tests.apis.apiadmin.testcore.pojo.defenitionsresponse.Idresponse

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.tr.eds.core.utils.Utils

@JsonIgnoreProperties(value = [ "consumes", "produces","swagger","paths", "definitions", "securityDefinitions", "security" , "schemes"] )

class Scheme extends SchemeResponse{

        Info info
        String basePath

    Scheme() {
    }

    Scheme(Info info, String basePath) {

        this.info = info
        this.basePath = basePath

    }

    Info getInfo() {
        return info
    }

    void setInfo(Info info) {
        this.info = info
    }

    String getBasePath() {
        return basePath
    }

    void setBasePath(String basePath) {
        this.basePath = basePath
    }

    @Override
    public String toString() {
        return Utils.getResponseModelAsJSONString(this);
    }
}
