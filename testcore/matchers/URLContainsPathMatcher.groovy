package com.tr.eds.tests.apis.apiadmin.testcore.matchers

import com.tr.eds.tests.apis.apiadmin.testcore.pojo.defenitionsresponse.ExampleResponse.ExampleResponse
import com.tr.eds.tests.apis.apiadmin.testcore.pojo.defenitionsresponse.ExampleResponse.Examples
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher

class URLContainsPathMatcher extends TypeSafeMatcher<ArrayList<ExampleResponse>> {

    ArrayList<ExampleResponse> exampleResponse
    String failedUrl
    String failedPath

    URLContainsPathMatcher(ArrayList<ExampleResponse> exampleResponse) {
        this.exampleResponse = exampleResponse
    }

    @Override
    void describeTo(final Description description) {
        description.appendText("URL contains path")
    }

    @Override
    protected boolean matchesSafely(ArrayList<ExampleResponse> arrayResponseModel) {
        for (int i = 0; i < arrayResponseModel.size(); i++) {
            ArrayList<Examples> arrayResponseModelEx = arrayResponseModel.get(i).examples
            String path = arrayResponseModel.get(i).path
            for (int j = 0; j < arrayResponseModelEx.size(); j++) {
                if (!arrayResponseModelEx.get(j).url.contains(path)) {
                    failedUrl = arrayResponseModelEx.get(j).url
                    failedPath = arrayResponseModel.get(i).path
                    return false
                }
            }
        }
        return true
    }

    static Matcher<ArrayList<ExampleResponse>> URLContainPath() {
        return new URLContainsPathMatcher()
    }


    @Override
    protected void describeMismatchSafely(ArrayList<ExampleResponse> arrayResponseModel, Description mismatchDescription) {
        if (failedUrl && failedPath){
            mismatchDescription.appendText("ApiAdmin ERROR:" + failedUrl +"not contain" + failedPath)
        }

    }
}

