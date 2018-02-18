package com.tr.eds.tests.apis.apiadmin.testcore.pojo.defenitionsresponse

import com.tr.eds.core.service.response.IApiObject
import com.tr.eds.core.swagger.pojo.response.BasePojo

class Endpoints extends BasePojo implements IApiObject {
    String path_id
    String path
    String scheme_id
    ArrayList<Methods> methods
    Descriptions descriptions


    public Endpoints() {

    }

    public Endpoints(String path_id, String path, String scheme_id, Descriptions descriptions, ArrayList<Methods> methods) {
        this.path_id = path_id
        this.path = path
        this.scheme_id = scheme_id
        this.descriptions = descriptions
        this.methods = methods
    }


    @Override
    String toString() {
        return null
    }
}
