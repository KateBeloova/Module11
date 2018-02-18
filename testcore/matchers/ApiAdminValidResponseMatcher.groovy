package com.tr.eds.tests.apis.apiadmin.testcore.matchers

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException
import com.tr.eds.core.service.response.HttpResponseDecorator
import com.tr.eds.core.matchers.BaseValidApiResponseMatcher
import com.tr.eds.tests.apis.apiadmin.testcore.pojo.defenitionsresponse.ApiAdminError
import org.hamcrest.Matcher

class ApiAdminValidResponseMatcher extends BaseValidApiResponseMatcher {

    static Matcher<HttpResponseDecorator> isValidApiAdminResponse() {
        return new ApiAdminValidResponseMatcher()
    }

    /**
     *  Method that check if HttpResponse contains API-specific errors
     *
     *  Should set following variables:
     *  (boolean) hasApiError - true if error is present in response, false - otherwise
     *
     *  If error present:
     *  (String) expectedResultMessage - expected result (e.g. <"NO ESG ERRORS">)
     *  (String) actualResultMessage - actual error message (e.g. <"ESG ERROR : " + esgErrorModel.toString()>)
     *
     * @param rawResponse
     */
    @Override
    void checkAPIErrors(HttpResponseDecorator rawResponse) {
        ApiAdminError errorModel
        try {
            errorModel = (ApiAdminError) rawResponse.getResponseModel(ApiAdminError.class)
            hasApiError = true
            expectedResultMessage = "NO APIADMIN ERRORS"
            actualResultMessage = "APIADMIN ERROR : " + errorModel.toString()
        }
        catch (UnrecognizedPropertyException err) {
            hasApiError = false
        } catch (Exception e) {
            hasApiError = false
        }
    }
}
