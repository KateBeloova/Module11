package com.tr.eds.tests.apis.apiadmin.endtoend

import com.tr.eds.core.utils.Utils
import com.tr.eds.tests.apis.apiadmin.ApiAdminBaseTest
import com.tr.eds.tests.apis.apiadmin.testcore.pojo.defenitionsresponse.ExampleResponse.ExampleResponse
import org.testng.annotations.Test

import static com.tr.eds.core.asserts.CustomAsserts.assertThat
import static com.tr.eds.core.asserts.SoftAsserts.expect
import static com.tr.eds.core.asserts.SoftAsserts.softAsserts
import static com.tr.eds.tests.apis.apiadmin.testcore.matchers.ApiAdminValidResponseMatcher.isValidApiAdminResponse
import static com.tr.eds.tests.apis.apiadmin.testcore.matchers.URLContainsPathMatcher.URLContainPath
import static org.hamcrest.CoreMatchers.hasItems

class APIADMIN_GET_DEFINITIONS_EXAMPLES extends ApiAdminBaseTest{

    @Test(dataProvider = "getDataEndToEnd",description = "Request to get examples. Expect list of examples.", enabled = true)
    void APIADMIN_GET_EXAMPLES(String decodedString, String title ,ArrayList<String> paths) {
        rawResp = get_DEFINITIONS_EXAMPLES(Utils.convertBasic64(decodedString))

        assertThat(NO_ERRORS_IN_APIADMIN_RESPONSE, rawResp, isValidApiAdminResponse())
        ArrayList<ExampleResponse> respModel = (ArrayList<ExampleResponse>) getResponseModelArrayApiAdminExampleresponse()

        assertThat("All URL contain paths", respModel, URLContainPath())

        softAsserts{
            expect("Examples contain correct paths", respModel.path, hasItems(paths.toArray()))
        }
    }
}
