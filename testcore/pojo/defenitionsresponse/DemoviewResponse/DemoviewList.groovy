package com.tr.eds.tests.apis.apiadmin.testcore.pojo.defenitionsresponse.DemoviewResponse

import com.tr.eds.core.service.response.IApiObject
import com.tr.eds.core.utils.Utils
import com.tr.eds.core.swagger.pojo.response.BasePojo

class DemoviewList extends BasePojo implements IApiObject{
    String path
    String method
    String demoview

    DemoviewList() {
    }

    DemoviewList(String path, String method, String demoview) {
        this.path = path
        this.method = method
        this.demoview = demoview
    }

    String getPath() {
        return path
    }

    void setPath(String path) {
        this.path = path
    }

    String getMethod() {
        return method
    }

    void setMethod(String method) {
        this.method = method
    }

    String getDemoview() {
        return demoview
    }

    void setDemoview(String demoview) {
        this.demoview = demoview
    }

    @Override
    String toString() {
        return Utils.getResponseModelAsJSONString(this);
    }
}
