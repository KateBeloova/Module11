package com.tr.eds.tests.apis.apiadmin.testcore.pojo.defenitionsresponse.ExampleResponse

import com.tr.eds.core.utils.Utils
//@JsonIgnoreProperties(value = [ "method", "examples" ] )
class ExampleResponse {
    String path
    String method
    ArrayList<Examples> examples

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

    ArrayList<Examples> getExamples() {
        return examples
    }

    void setExamples(ArrayList<Examples> examples) {
        this.examples = examples
    }



     boolean esgExamplesURL () {
        for (int i = 0; i < examples.size(); i++) {
            if (examples.get(i).url.contains(path)) {
                return true
            }
            return false
        }
    }

    @Override
    String toString() {
        return Utils.getResponseModelAsJSONString(this);
    }
}
