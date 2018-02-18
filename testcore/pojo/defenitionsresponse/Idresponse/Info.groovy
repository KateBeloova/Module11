package com.tr.eds.tests.apis.apiadmin.testcore.pojo.defenitionsresponse.Idresponse


class Info {
    String description
    String title
    String version

    String getTitle() {
        return title
    }

    void setTitle(String title) {
        this.title = title
    }

    String getVersion() {
        return version
    }

    void setVersion(String version) {
        this.version = version
    }

    String getDescription() {
        return description
    }

    void setDescription(String description) {
        this.description = description
    }
}
