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

import org.openjdk.jmh.annotations.{Scope, State}
import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice._
import play.api.i18n.{Messages, MessagesApi}
import play.api.inject.Injector
import play.api.inject.guice.GuiceApplicationBuilder
import play.api.test.FakeRequest

object PlayHelper extends PlaySpec with GuiceOneAppPerSuite {

  def injector: Injector = app.injector

  def messagesApi: MessagesApi = injector.instanceOf[MessagesApi]

  def fakeRequest = FakeRequest("", "")

  implicit def messages: Messages = messagesApi.preferred(fakeRequest)

  def applicationBuilder: GuiceApplicationBuilder = new GuiceApplicationBuilder()

  @State(Scope.Benchmark)
  class BenchmarkState {
    var inject = applicationBuilder.build().injector
  }

  @State(Scope.Thread)
  class ThreadState {
    var inject = applicationBuilder.build().injector
  }
}