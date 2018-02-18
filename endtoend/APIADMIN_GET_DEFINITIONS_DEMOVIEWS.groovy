package com.tr.eds.tests.apis.apiadmin.endtoend

import com.tr.eds.core.utils.Utils
import com.tr.eds.tests.apis.apiadmin.ApiAdminBaseTest
import com.tr.eds.tests.apis.apiadmin.testcore.pojo.defenitionsresponse.DemoviewResponse.DemoviewList
import org.testng.annotations.Test

import static com.tr.eds.core.asserts.CustomAsserts.assertThat
import static com.tr.eds.core.asserts.SoftAsserts.expect
import static com.tr.eds.core.asserts.SoftAsserts.softAsserts
import static com.tr.eds.tests.apis.apiadmin.testcore.matchers.ApiAdminValidResponseMatcher.isValidApiAdminResponse
import static org.hamcrest.CoreMatchers.notNullValue

class APIADMIN_GET_DEFINITIONS_DEMOVIEWS extends ApiAdminBaseTest {

    @Test(dataProvider = "getDataEndToEnd",description = "Request to get demoview. Expect valid response.")
    void APIADMIN_GET_DEMOVIEWS(String decodedString, String title ,ArrayList<String> paths) {
        rawResp = get_DEFINITIONS_DEMOVIEWS(Utils.convertBasic64(decodedString))

        assertThat(NO_ERRORS_IN_APIADMIN_RESPONSE, rawResp, isValidApiAdminResponse())
        ArrayList<DemoviewList> respModel = (ArrayList<DemoviewList>) getResponseModelArrayApiAdminDemoviewresponse()

        softAsserts {
            expect("Demoviews are not null", respModel.demoview, notNullValue())
        }
    }
}
