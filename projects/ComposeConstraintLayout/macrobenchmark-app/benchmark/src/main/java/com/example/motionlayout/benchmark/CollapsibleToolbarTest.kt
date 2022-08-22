/*
 * Copyright (C) 2022 The Android Open Source Project
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

package com.example.motionlayout.benchmark

import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Direction
import kotlin.math.roundToInt

internal fun MacrobenchmarkRule.testCollapsibleToolbar() =
    motionBenchmark("CollapsibleToolbar") {
        val column = device.findObject(By.res("LazyColumn"))
        val bounds = column.visibleBounds
        val vMargin = (bounds.height() * 0.1f).roundToInt()
        val x = (bounds.width() * 0.5f).roundToInt()
        val y1 = bounds.bottom - vMargin
        val y2 = bounds.top + vMargin

        device.swipe(x, y1, x, y2, 50)
        device.waitForIdle()
    }