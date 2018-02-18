package com.tr.eds.tests.apis.apiadmin.testcore.pojo.defenitionsresponse

import com.fasterxml.jackson.annotation.JsonProperty
//@JsonIgnoreProperties(value = { "POST", "PUT", "DELETE", "PATCH", "OPTIONS", "HEAD", "CONNECT", "PUT", "TRACE"})
class Descriptions {
    @JsonProperty("GET")
    String GET
    @JsonProperty("POST")
    String POST
    @JsonProperty("PUT")
    String PUT
    @JsonProperty("DELETE")
    String DELETE
    @JsonProperty("PATCH")
    String PATCH
    @JsonProperty("OPTIONS")
    String OPTIONS
    @JsonProperty("HEAD")
    String HEAD
    @JsonProperty("CONNECT")
    String CONNECT
    @JsonProperty("TRACE")
    String TRACE

    Descriptions() {
    }

    Descriptions(String GET, String POST, String PUT, String DELETE, String PATCH, String OPTIONS, String HEAD, String CONNECT, String TRACE) {
        this.GET = GET
        this.POST = POST
        this.PUT = PUT
        this.DELETE = DELETE
        this.PATCH = PATCH
        this.OPTIONS = OPTIONS
        this.HEAD = HEAD
        this.CONNECT = CONNECT
        this.TRACE = TRACE
    }

    String getGET() {
        return GET
    }

    void setGET(String GET) {
        this.GET = GET
    }

    String getPOST() {
        return POST
    }

    void setPOST(String POST) {
        this.POST = POST
    }

    String getPUT() {
        return PUT
    }

    void setPUT(String PUT) {
        this.PUT = PUT
    }

    String getDELETE() {
        return DELETE
    }

    void setDELETE(String DELETE) {
        this.DELETE = DELETE
    }

    String getPATCH() {
        return PATCH
    }

    void setPATCH(String PATCH) {
        this.PATCH = PATCH
    }

    String getOPTIONS() {
        return OPTIONS
    }

    void setOPTIONS(String OPTIONS) {
        this.OPTIONS = OPTIONS
    }

    String getHEAD() {
        return HEAD
    }

    void setHEAD(String HEAD) {
        this.HEAD = HEAD
    }

    String getCONNECT() {
        return CONNECT
    }

    void setCONNECT(String CONNECT) {
        this.CONNECT = CONNECT
    }

    String getTRACE() {
        return TRACE
    }

    void setTRACE(String TRACE) {
        this.TRACE = TRACE
    }
}


