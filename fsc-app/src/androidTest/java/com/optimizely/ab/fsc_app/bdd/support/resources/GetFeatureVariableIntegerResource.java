/****************************************************************************
 * Copyright 2019, Optimizely, Inc. and contributors                        *
 *                                                                          *
 * Licensed under the Apache License, Version 2.0 (the "License");          *
 * you may not use this file except in compliance with the License.         *
 * You may obtain a copy of the License at                                  *
 *                                                                          *
 *    http://www.apache.org/licenses/LICENSE-2.0                            *
 *                                                                          *
 * Unless required by applicable law or agreed to in writing, software      *
 * distributed under the License is distributed on an "AS IS" BASIS,        *
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. *
 * See the License for the specific language governing permissions and      *
 * limitations under the License.                                           *
 ***************************************************************************/

package com.optimizely.ab.fsc_app.bdd.support.resources;

import com.optimizely.ab.fsc_app.bdd.support.OptimizelyE2EService;
import com.optimizely.ab.fsc_app.bdd.models.requests.GetFeatureVariableIntegerRequest;
import com.optimizely.ab.fsc_app.bdd.models.responses.BaseResponse;
import com.optimizely.ab.fsc_app.bdd.models.responses.ListenerMethodResponse;

public class GetFeatureVariableIntegerResource extends BaseResource<Integer> {

    private static GetFeatureVariableIntegerResource instance;

    private GetFeatureVariableIntegerResource() {
        super();
    }

    public static GetFeatureVariableIntegerResource getInstance() {
        if (instance == null) {
            instance = new GetFeatureVariableIntegerResource();
        }
        return instance;
    }

    public BaseResponse convertToResourceCall(OptimizelyE2EService optimizelyE2EService, Object desreailizeObject) {
        GetFeatureVariableIntegerRequest getFeatureVariableIntegerRequest = mapper.convertValue(desreailizeObject, GetFeatureVariableIntegerRequest.class);
        ListenerMethodResponse<Integer> listenerMethodResponse = getFeatureVariableInteger(optimizelyE2EService, getFeatureVariableIntegerRequest);
        return listenerMethodResponse;
    }

    ListenerMethodResponse<Integer> getFeatureVariableInteger(OptimizelyE2EService optimizelyE2EService, GetFeatureVariableIntegerRequest getFeatureVariableIntegerRequest) {

        Integer variableValue = optimizelyE2EService.getOptimizelyManager().getOptimizely().getFeatureVariableInteger(
                getFeatureVariableIntegerRequest.getFeatureFlagKey(),
                getFeatureVariableIntegerRequest.getVariableKey(),
                getFeatureVariableIntegerRequest.getUserId(),
                getFeatureVariableIntegerRequest.getAttributes()
                );

        return sendResponse(variableValue, optimizelyE2EService);
    }

}