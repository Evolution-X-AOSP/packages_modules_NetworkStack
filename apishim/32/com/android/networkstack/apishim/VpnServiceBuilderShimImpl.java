/*
 * Copyright (C) 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.networkstack.apishim;

import android.net.IpPrefix;
import android.net.VpnService;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.android.modules.utils.build.SdkLevel;
import com.android.networkstack.apishim.common.UnsupportedApiLevelException;
import com.android.networkstack.apishim.common.VpnServiceBuilderShim;

/**
 * Implementation of {@link com.android.networkstack.apishim.common.VpnServiceBuilderShim}.
 */
@RequiresApi(32) // Change to Build.VERSION_CODES.T when it is available, and adding T methods
public class VpnServiceBuilderShimImpl extends
        com.android.networkstack.apishim.api31.VpnServiceBuilderShimImpl {

    /**
     * Get a new instance of {@link VpnServiceBuilderShim}.
     */
    @RequiresApi(Build.VERSION_CODES.Q)
    public static VpnServiceBuilderShim newInstance() {
        if (SdkLevel.isAtLeastT()) {
            return new VpnServiceBuilderShimImpl();
        } else {
            return new com.android.networkstack.apishim.api31.VpnServiceBuilderShimImpl();
        }
    }

    @Override
    public VpnService.Builder excludeRoute(VpnService.Builder builder, IpPrefix prefix)
            throws UnsupportedApiLevelException {
        return builder.excludeRoute(prefix);
    }

    @Override
    public VpnService.Builder addRoute(VpnService.Builder builder, IpPrefix prefix)
            throws UnsupportedApiLevelException {
        return builder.addRoute(prefix);
    }
}
