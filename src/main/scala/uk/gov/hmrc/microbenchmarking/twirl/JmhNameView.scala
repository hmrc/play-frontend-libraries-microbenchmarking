/*
 * Copyright 2019 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.microbenchmarking.twirl

import org.openjdk.jmh.annotations.Benchmark
import uk.gov.hmrc.microbenchmarking.twirl.PlayHelper._
import views.html._

class JmhNameView {

  @Benchmark
  def renderPage(state: BenchmarkState): Unit = {

    state.inject.instanceOf[NameViewStrippedDown].render()

    //        val view = state.inject.instanceOf[NameViewStrippedDown]
    //        println(s"HTML:${view.render()}")
  }

}