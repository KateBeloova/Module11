package com.tr.eds.tests.apis.apiadmin.testcore.pojo.defenitionsresponse.ExampleResponse

import com.tr.eds.core.service.response.IApiObject
import com.tr.eds.core.utils.Utils
import com.tr.eds.core.swagger.pojo.response.BasePojo
//@JsonIgnoreProperties(value = [ "consumes", "produces","swagger", "basePath", "paths", "definitions", "securityDefinitions", "security" ] )
class Examples extends BasePojo implements IApiObject {

    String name
    String url
    String description
    String body


    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    String getUrl() {
        return url
    }

    void setUrl(String url) {
        this.url = url
    }

    String getDescription() {
        return description
    }

    void setDescription(String description) {
        this.description = description
    }

    @Override
    String toString() {
        return Utils.getResponseModelAsJSONString(this);
    }
}
