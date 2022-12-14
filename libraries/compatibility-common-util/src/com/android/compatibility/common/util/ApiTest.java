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

package com.android.compatibility.common.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** Marks the type of CTS test with purpose of asserting API functionalities and behaviors. */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface ApiTest {
    // The list of APIs being tested.
    //
    // For example, if a CTS test is validating APIs:
    //     1. android.example.ClassA#MethodA
    //     2. android.example.ClassB#MethodB
    // This test should be annotated by @ApiTest with the format:
    //     @ApiTest(apis={"android.example.ClassA#MethodA", "android.example.ClassB#MethodB"})
    //
    // For other special cases:
    //     1. a test is validating an API field via an API method (e.g. request.set(key, value):
    //            @ApiTest(apis={"android.example.ClassC#MethodC(FieldA)"})
    //     2. a test is validating an API field directly:
    //            @ApiTest(apis={"android.example.ClassD#FieldB"})
    String[] apis();
}
