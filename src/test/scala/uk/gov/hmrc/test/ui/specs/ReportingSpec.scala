package uk.gov.hmrc.test.ui.specs

import uk.gov.hmrc.test.ui.pages.*
import uk.gov.hmrc.test.ui.specs.tags.*
class ReportingSpec extends BaseSpec {

  Feature("Reporting Upload file journeys") {

    Scenario("1 - Organisation user uploads Valid file", ReportingTests) {

      Given("the Organisation user logs in with a valid CARF ID")
      AuthLoginPage.loginAsOrgAdminWithoutCtUtr("RG1111")

      // TODO: Change navigation when redirection from service home page is ready
      And("the Organisation user navigates to '/invalid-xml' page")
      InvalidXmlPage.navigateInvalidXmlPage

      And("the Organisation user clicks 'Upload a different file' link on '/invalid-xml' page")
      InvalidXmlPage.clickOnLink(InvalidXmlPage.uploadADifferentFileLink)

      And("the Organisation user uploads a valid file on '/upload-file' page")
      UploadFilePage.fileUpload("Valid.xml")

      And("the Organisation user is on '/check-your-file-details' page")
      CheckYourDetailsPage.onPage()
      // TODO: Continue journey as pages are implemented
    }
  }
}
