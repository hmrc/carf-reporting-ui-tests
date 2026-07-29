package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.By

object InvalidXmlPage extends BasePage {

  override val pageUrl: String = baseUrl + "/report/problem/invalid-xml"

  val uploadADifferentFileLink: By = By.cssSelector("a[href*='/send-a-cryptoasset-report/report/upload-file']")

  def navigateInvalidXmlPage: this.type = { // TODO: Remove this method once the previous pages are implemented
    driver.navigate().to(pageUrl)
    onPage()
    this
  }
}
