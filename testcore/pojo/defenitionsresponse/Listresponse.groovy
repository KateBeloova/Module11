package com.tr.eds.tests.apis.apiadmin.testcore.pojo.defenitionsresponse

import com.tr.eds.core.service.response.IApiObject
import com.tr.eds.core.utils.Utils
import com.tr.eds.core.swagger.pojo.response.BasePojo

class Listresponse extends BasePojo implements IApiObject {
        String id
        String basepath
        String category_name
    String description
    ArrayList<Endpoints> endpoints

    public Listresponse() {

    }

    public Listresponse(String id, String basepath, String category_name, String description, ArrayList<Endpoints> endpoints) {
        this.id = id
        this.basepath = basepath
        this.category_name = category_name
        this.description = description
        this.endpoints = endpoints

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    String getBasepath() {
        return basepath
    }

    void setBasepath(String basepath) {
        this.basepath = basepath
    }

    ArrayList<Endpoints> getEndpoints() {
        return endpoints
    }

    void setEndpoints(ArrayList<Endpoints> endpoints) {
        this.endpoints = endpoints
    }

    @Override
    public String toString() {
        return Utils.getResponseModelAsJSONString(this);
    }
}

