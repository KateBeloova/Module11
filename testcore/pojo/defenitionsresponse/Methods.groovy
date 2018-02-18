package com.tr.eds.tests.apis.apiadmin.testcore.pojo.defenitionsresponse


class Methods extends Endpoints{

    String method
    String description

    public Methods() {

    }

   public Methods(String method, String description) {
        this.method = method
        this.description = description
    }

    Methods(String path_id, String path, String scheme_id, Descriptions descriptions, ArrayList<Methods> methods, String method, String description) {
        super(path_id, path, scheme_id, descriptions, methods)
        this.method = method
        this.description = description
    }

    String getMethod() {
        return method
    }

    void setMethod(String method) {
        this.method = method
    }

    String getDescription() {
        return description
    }

    void setDescription(String description) {
        this.description = description
    }
}
