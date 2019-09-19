package com.optimizely.ab.android.test_app.bdd.support.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Map;

public class ListenerMethodResponse<T> implements BaseResponse {
    @JsonProperty("result")
    private T result;

    @JsonProperty("listener_called")
    private ArrayList<Map<String, Object>> listenerCalled;

    public ListenerMethodResponse(T result, ArrayList<Map<String, Object>> listenerCalled) {
        this.result = result;
        this.listenerCalled = listenerCalled;
    }

    public void setListenerCalled(ArrayList<Map<String, Object>> listenerCalled) {
        this.listenerCalled = listenerCalled;
    }

    public ArrayList<Map<String, Object>> getListenerCalled() {
        return listenerCalled;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public Boolean compareResults(Object expectedResponse) {
        Object expectedVal = expectedResponse;
        if (result.equals("NULL")) {
            expectedVal = null;
        } else if (expectedVal.equals("true") || expectedVal.equals("false")) {
            expectedVal = Boolean.parseBoolean((String) expectedVal);
        }
        Assert.assertTrue(expectedVal == result);
        return true;
    }

}
