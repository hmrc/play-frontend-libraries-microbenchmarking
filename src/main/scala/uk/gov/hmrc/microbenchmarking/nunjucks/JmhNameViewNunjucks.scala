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

package uk.gov.hmrc.microbenchmarking.nunjucks

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations.Benchmark
import play.api.libs.json.Json
import play.twirl.api.Html
import uk.gov.hmrc.microbenchmarking.helper.PlayHelper._
import uk.gov.hmrc.nunjucks.NunjucksRenderer

import scala.concurrent.Await
import scala.concurrent.duration.Duration

class JmhNameViewNunjucks {

  @Benchmark
  def renderPage(state: BenchmarkState): Html = {

    Await.result(state.inject.instanceOf[NunjucksRenderer].render("name.njk", Json.obj(
      "labelContent" -> "labelContent",
      "buttonContent" -> "buttonContent"
    )), Duration(10, TimeUnit.SECONDS))
  }

}