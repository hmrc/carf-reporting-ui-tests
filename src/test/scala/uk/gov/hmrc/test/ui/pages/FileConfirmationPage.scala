package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.By

object FileConfirmationPage extends BasePage {

  override val pageUrl: String = baseUrl + "/file-confirmation"
  
  val uploadAnotherFileLink: By = By.id("upload-link")

}
