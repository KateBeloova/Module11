package com.tr.eds.tests.apis.apiadmin.testcore.pojo.defenitionsresponse

import com.tr.eds.core.service.response.IApiObject
import com.tr.eds.core.swagger.pojo.response.BasePojo


class ApiAdminError extends BasePojo implements IApiObject {

    public String id
    public String code
    public String status
    public String message

    ApiAdminError() {
    }

    ApiAdminError(String id, String code, String status, String message) {
        this.id = id
        this.code = code
        this.status = status
        this.message = message
    }


    String getId() {
        return id
    }

    void setId(String id) {
        this.id = id
    }

    String getCode() {
        return code
    }

    void setCode(String code) {
        this.code = code
    }

    String getStatus() {
        return status
    }

    void setStatus(String status) {
        this.status = status
    }

    String getMessage() {
        return message
    }

    void setMessage(String message) {
        this.message = message
    }


    @Override
    public String toString() {
        sb.append("class ApiAdminError {\n")
        sb.append("    id: ").append(toIndentedString(id)).append("\n")
        sb.append("    code: ").append(toIndentedString(code)).append("\n")
        sb.append("    status: ").append(toIndentedString(status)).append("\n")
        sb.append("    message: ").append(toIndentedString(message)).append("\n")
        sb.append("}")
        return sb.toString()
    }
}
