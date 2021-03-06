package com.tr.eds.tests.apis.apiadmin.endtoend

import com.tr.eds.core.swagger.pojo.response.error.BaseEDSError
import com.tr.eds.tests.apis.apiadmin.ApiAdminBaseTest
import org.testng.annotations.Test

import static com.tr.eds.core.asserts.CustomAsserts.assertThat
import static com.tr.eds.core.matchers.IsHttpStatusMatcher.isStatusCode
import static org.hamcrest.CoreMatchers.containsString

class APIADMIN_GET_DEFINITIONS_EXAMPLES_NEGATIVE extends ApiAdminBaseTest{

    @Test(description = "Sent invalid ID. Expect error.")
    void APIADMIN_GET_EXAMPLES_INVALID_ID() {
        rawResp = get_DEFINITIONS_EXAMPLES("3ltYm9sb2d5L2JldGEx")
        BaseEDSError respModel = (BaseEDSError) rawResp.getResponseModel(BaseEDSError.class)

        assertThat("HTTP Code is 400", rawResp, isStatusCode(400))
        assertThat("ERROR contains 'invalid id'", respModel.error.message, containsString("invalid id"))
    }

    @Test(description = "Sent ID with special symbols. Expect error.")
    void APIADMIN_GET_EXAMPLES_ID_WITH_SPECIAL_SYMBOLS() {
        rawResp = get_DEFINITIONS_EXAMPLES("!@#L2RhdGEvc3ltYm9sb2d5L2JldGEx")
        BaseEDSError respModel = (BaseEDSError) rawResp.getResponseModel(BaseEDSError.class)

        assertThat("HTTP Code is 400", rawResp, isStatusCode(400))
        assertThat("ERROR contains 'invalid id'", respModel.error.message, containsString("invalid id"))
    }
}
