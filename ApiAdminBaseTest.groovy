package com.tr.eds.tests.apis.apiadmin

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.tr.eds.core.runner.TestConfig
import com.tr.eds.core.service.requestor.Requestor
import com.tr.eds.core.service.response.HttpResponseDecorator
import com.tr.eds.core.service.response.IApiObject
import com.tr.eds.tests.apis.apiadmin.testcore.pojo.defenitionsresponse.DemoviewResponse.DemoviewList
import com.tr.eds.tests.apis.apiadmin.testcore.pojo.defenitionsresponse.ExampleResponse.ExampleResponse
import com.tr.eds.tests.apis.apiadmin.testcore.pojo.defenitionsresponse.Listresponse
import com.tr.eds.tests.base.Constants
import com.tr.eds.tests.base.GWBaseTest
import org.testng.annotations.DataProvider

class ApiAdminBaseTest extends GWBaseTest implements Constants {
    static String basePath = "/docs/beta1"
    private static url = TestConfig.URL + basePath


    static HttpResponseDecorator get_DEFINITIONS() {
        return Requestor.GET(url + "/definitions", TestConfig.HEADERS)
    }

    static HttpResponseDecorator get_DEFINITIONS_ID(String id) {
        return Requestor.GET(url + "/definitions/" + id, TestConfig.HEADERS)
    }

    static HttpResponseDecorator get_DEFINITIONS_DEMOVIEWS(String id) {
        return Requestor.GET(url + "/definitions/" + id + "/demoviews", TestConfig.HEADERS)
    }

    static HttpResponseDecorator get_DEFINITIONS_EXAMPLES(String id) {
        return Requestor.GET(url + "/definitions/" + id + "/examples", TestConfig.HEADERS)
    }

    static HttpResponseDecorator get_DEFINITIONS_README(String id) {
        return Requestor.GET(url + "/definitions/" + id + "/readme", TestConfig.HEADERS)
    }

    @DataProvider(name =  "getDataSmoke")
    static Object[][] getDataSmoke() {
        [
                ["/data/symbology/beta1","Symbology", ["/convert", "/convert"]],

        ]
    }


    @DataProvider(name =  "getDataEndToEnd")
    static Object[][] getDataEndtoEnd() {
    [
        ["/data/estimates/beta1", "Estimates", ["/views/income-statement", "/views/recommendation-overview"] ],
        ["/data/starmine/beta1", "Starmine", ["/views/models","/views/combined-credit-model"]],
        ["/data/company-overview/beta1", "Company snapshot", ["/views/financials","/views/general", "/views/ratios", "/views/snapshot" ]],
        ["/data/financial-ratios/beta1","Financial ratios",["/views/other-ratios", "/views/per-share", "/views/pricing", "/views/margins"]],
        ["/alerts/beta1","Subscriptions to content alerts API",["/research-subscriptions"]],
        ["/data/environmental-social-governance/beta1", "ESG", ["/universe","/views/basic","/views/scores-standard", "/views/scores-full", "/views/measures-standard","/views/measures-full"] ],
        ["/docs/beta1", "Docs", []],
        ["/auth/oauth2/beta1", "EDS Authentication",[]],
        ["/auth/cloud-credentials/beta1", "Cloud Credentials API",[]],
        ["/data/ratios/beta1","Ratios report", ["/views/financial-strength"]],
        ["/data/ownership/beta1","Ownership",  ["/views/top-10-investors"]]
        ]
    }

    /**
     * Get ApiObject from array of ApiObjects by basepath value
     * @param basepath
     * @param arrayResponseModel
     * @return Listresponse object that contains specified basepath
     */

    static Listresponse getListresponseModelForBasepath(String basepath, ArrayList<Listresponse> arrayResponseModel) {
        for (int i = 0; i < arrayResponseModel.size(); i++) {
            if (arrayResponseModel.get(i).basepath.equals(basepath)) {
                return arrayResponseModel.get(i)
            }
        }
        return null
    }


    static ExampleResponse getExampleresponseModelForPath(String path, ArrayList<ExampleResponse> arrayResponseModelEx) {
        for (int i = 0; i < arrayResponseModelEx.size(); i++) {
            if (arrayResponseModelEx.get(i).path.equals(path)) {
                return arrayResponseModelEx.get(i)
            }
        }
        return null
    }

    ArrayList<? extends IApiObject> getResponseModelArrayApiAdminListresponse() {
        ObjectMapper mapper = new ObjectMapper()
        return mapper.readValue(rawResp.responseBody, new TypeReference<List<Listresponse>>() {})
    }

    ArrayList<? extends IApiObject> getResponseModelArrayApiAdminExampleresponse() {
        ObjectMapper mapper = new ObjectMapper()
        return mapper.readValue(rawResp.responseBody, new TypeReference<List<ExampleResponse>>() {})
    }

    ArrayList<? extends IApiObject> getResponseModelArrayApiAdminDemoviewresponse() {
        ObjectMapper mapper = new ObjectMapper()
        return mapper.readValue(rawResp.responseBody, new TypeReference<List<DemoviewList>>() {})
    }
}

