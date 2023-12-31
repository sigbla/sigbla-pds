/*
 * Copyright (c) 2014 Andrew O'Malley
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package sigbla.app.pds.collection.performance

import sigbla.app.pds.collection.Builder
import sigbla.app.pds.collection.Pair
import sigbla.app.pds.collection.TreeMap
import sigbla.app.pds.collection.mutable.MutableTreeMap
import sigbla.app.pds.collection.Map as DMap

open class SortedMapPerformanceTest : MapPerformanceTest() {

    override fun compare(description: String, operations: Int, iterations: Int, f: (builder: Builder<Pair<Int, Int>, out DMap<Int, Int>>) -> PerformanceMeasurement.Result) {
        val java = time(iterations) { f(MutableTreeMap.factory<Int, Int>().newBuilder()) }
        val dexx = time(iterations) { f(TreeMap.factory<Int, Int>(null, null).newBuilder()) }
        compare("SortedMap: $description", operations, java, dexx)
    }
}

