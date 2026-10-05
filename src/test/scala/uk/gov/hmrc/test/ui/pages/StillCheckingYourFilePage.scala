/*
 * Copyright 2026 HM Revenue & Customs
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

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.support.ui.FluentWait
import org.openqa.selenium.{By, WebDriver}
import uk.gov.hmrc.selenium.component.PageObject
import uk.gov.hmrc.selenium.webdriver.Driver

import java.time.Duration
object StillCheckingYourFilePage extends BasePage with PageObject {

  override val pageUrl: String = baseUrl + "/still-checking-your-file"

  val refreshForUpdatesButton: By = By.id("refresh")

  def refreshUntilRedirected(timeoutSeconds: Long): Unit = {
    onPage()

    new FluentWait[WebDriver](Driver.instance)
      .withTimeout(Duration.ofSeconds(timeoutSeconds))
      .pollingEvery(Duration.ofSeconds(5))
      .until { (driver: WebDriver) =>
        if (driver.getCurrentUrl != pageUrl) {
          java.lang.Boolean.TRUE
        } else {
          click(refreshForUpdatesButton)
          java.lang.Boolean.FALSE
        }
      }
  }
}
