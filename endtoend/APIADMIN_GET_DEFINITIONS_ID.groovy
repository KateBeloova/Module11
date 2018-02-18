package com.tr.eds.tests.apis.apiadmin.endtoend

import com.tr.eds.core.utils.Utils
import com.tr.eds.tests.apis.apiadmin.ApiAdminBaseTest
import com.tr.eds.tests.apis.apiadmin.testcore.pojo.defenitionsresponse.Idresponse.SchemeResponse
import org.testng.annotations.Test

import static com.tr.eds.core.asserts.CustomAsserts.assertThat
import static com.tr.eds.core.asserts.SoftAsserts.expect
import static com.tr.eds.core.asserts.SoftAsserts.softAsserts
import static com.tr.eds.tests.apis.apiadmin.testcore.matchers.ApiAdminValidResponseMatcher.isValidApiAdminResponse
import static org.hamcrest.CoreMatchers.containsString

class APIADMIN_GET_DEFINITIONS_ID extends ApiAdminBaseTest {


    @Test(dataProvider = "getDataEndToEnd",description = "Request to get list of definitions. Expect valid response")
    void APIADMIN_GET_DEFINITIONS(String decodedString, String title ,ArrayList<String> paths) {
        rawResp = get_DEFINITIONS_ID(Utils.convertBasic64(decodedString))

        assertThat(NO_ERRORS_IN_APIADMIN_RESPONSE, rawResp, isValidApiAdminResponse())
        SchemeResponse respModel = (SchemeResponse) rawResp.getResponseModel(SchemeResponse.class)

        softAsserts {
            expect("Title contain " + title, respModel.scheme.info.title, containsString(title))
        }
    }
}
