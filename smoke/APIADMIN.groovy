package com.tr.eds.tests.apis.apiadmin.smoke

import com.tr.eds.core.utils.Utils
import com.tr.eds.tests.apis.apiadmin.ApiAdminBaseTest
import com.tr.eds.tests.apis.apiadmin.testcore.pojo.defenitionsresponse.DemoviewResponse.DemoviewList
import com.tr.eds.tests.apis.apiadmin.testcore.pojo.defenitionsresponse.ExampleResponse.ExampleResponse
import com.tr.eds.tests.apis.apiadmin.testcore.pojo.defenitionsresponse.Idresponse.Readme
import com.tr.eds.tests.apis.apiadmin.testcore.pojo.defenitionsresponse.Idresponse.SchemeResponse
import com.tr.eds.tests.apis.apiadmin.testcore.pojo.defenitionsresponse.Listresponse
import org.testng.Assert
import org.testng.annotations.Test

import static com.tr.eds.core.asserts.CustomAsserts.assertThat
import static com.tr.eds.core.asserts.SoftAsserts.expect
import static com.tr.eds.core.asserts.SoftAsserts.softAsserts
import static com.tr.eds.core.matchers.IsHttpStatusMatcher.isStatusCode
import static com.tr.eds.tests.apis.apiadmin.testcore.matchers.ApiAdminValidResponseMatcher.isValidApiAdminResponse
import static com.tr.eds.tests.apis.apiadmin.testcore.matchers.URLContainsPathMatcher.URLContainPath
import static org.hamcrest.CoreMatchers.*

class APIADMIN extends ApiAdminBaseTest {

    final String NO_ERRORS_IN_APIADMIN_RESPONSE = "NO ERRORS in APIADMIN response"

    @Test(dataProvider = "getDataSmoke",description = "Request to get list of definitions", enabled = true)
    void APIADMIN_GET_DEFINITIONS(String decodedString, String title ,ArrayList<String> paths) {

    rawResp = get_DEFINITIONS()

    assertThat(NO_ERRORS_IN_APIADMIN_RESPONSE, rawResp, isValidApiAdminResponse())
    ArrayList<Listresponse> respModel = (ArrayList<Listresponse>) getResponseModelArrayApiAdminListresponse()

    List<String> valueOfContentTypeHeader = rawResp.getHeaders().get("content-type")
    Assert.assertTrue(valueOfContentTypeHeader.get(0).contains("application/json"))

        softAsserts{
            assertThat("HTTP Code is 200", rawResp, isStatusCode(200))
            expect("All paths for API are correct", respModel.basepath,hasItems(decodedString))
        }
    }

    @Test(dataProvider = "getDataSmoke",description = "Request to get list of definitions for API's. Expect valid response.")
    void APIADMIN_GET_DEFINITION_BY_ID(String decodedString, String title ,ArrayList<String> paths) {

        rawResp = get_DEFINITIONS_ID(Utils.convertBasic64(decodedString))

        assertThat(NO_ERRORS_IN_APIADMIN_RESPONSE, rawResp, isValidApiAdminResponse())
        SchemeResponse respModel = (SchemeResponse) rawResp.getResponseModel(SchemeResponse.class)

        softAsserts {
            assertThat("HTTP Code is 200", rawResp, isStatusCode(200))
            expect("Title contain " + title, respModel.scheme.info.title, containsString(title))
        }
    }

    @Test(dataProvider = "getDataSmoke", description = "Request to get examples for API's. Expect list of examples.", enabled = true)
    void APIADMIN_GET_EXAMPLES_BY_ID(String decodedString, String title ,ArrayList<String> paths) {
        rawResp = get_DEFINITIONS_EXAMPLES(Utils.convertBasic64(decodedString))

        assertThat(NO_ERRORS_IN_APIADMIN_RESPONSE, rawResp, isValidApiAdminResponse())
        ArrayList<ExampleResponse> respModel = (ArrayList<ExampleResponse>) getResponseModelArrayApiAdminExampleresponse()

        assertThat("All URL contain paths", respModel, URLContainPath())

        softAsserts{
            expect("Examples contain correct paths", respModel.path, hasItems(paths.toArray()))
        }

    }

    @Test(dataProvider = "getDataSmoke",description = "Request to get demoviews for API's. Expect valid response.")
    void APIADMIN_GET_DEMOVIEWS_BY_ID(String decodedString, String title ,ArrayList<String> paths) {
        rawResp = get_DEFINITIONS_DEMOVIEWS(Utils.convertBasic64(decodedString))

        assertThat(NO_ERRORS_IN_APIADMIN_RESPONSE, rawResp, isValidApiAdminResponse())
        ArrayList<DemoviewList> respModel = (ArrayList<DemoviewList>) getResponseModelArrayApiAdminDemoviewresponse()

        softAsserts {
            expect("Demoviews are not null", respModel.demoview, notNullValue())
        }

    }

    @Test(dataProvider = "getDataSmoke",description = "Request to get readme for API's. Expect valid response.")
    void APIADMIN_GET_README_BY_ID(String decodedString, String title ,ArrayList<String> paths) {
        rawResp = get_DEFINITIONS_README(Utils.convertBasic64(decodedString))

        assertThat(NO_ERRORS_IN_APIADMIN_RESPONSE, rawResp, isValidApiAdminResponse())
        Readme respModel = (Readme) rawResp.getResponseModel(Readme.class)
        softAsserts {
            expect("Readme are not null", respModel.readme, notNullValue())
        }
    }
}
