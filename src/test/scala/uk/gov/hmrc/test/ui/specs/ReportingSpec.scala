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

package uk.gov.hmrc.test.ui.specs

import uk.gov.hmrc.test.ui.pages.*
import uk.gov.hmrc.test.ui.specs.tags.*
class ReportingSpec extends BaseSpec {

  Feature("Reporting Upload file journeys") {

    Scenario("1 - Organisation user uploads Valid file", ReportingTests) {

      Given("the Organisation user logs in with a valid CARF ID")
      AuthLoginPage.loginAsOrgAdminWithoutCtUtr("RG1111")

      And("the Organisation user clicks on 'Upload an XML file' link on '/manage-cryptoasset-reports' page")
      ServiceHomePage.clickOnLink(ServiceHomePage.uploadXmlFileLink)

      And("the Organisation user uploads a valid file on '/upload-file' page")
      UploadFilePage.fileUpload("Valid.xml")

      And("the Organisation user is on '/check-your-file-details' page")
      CheckYourDetailsPage.onPage()
      // TODO: Continue journey as pages are implemented
    }
    Scenario("2 - Organisation user uploads Invalid file", ReportingTests) {
      Given("the Organisation user logs in with a valid CARF ID")
      AuthLoginPage.loginAsOrgAdminWithoutCtUtr("RG1111")

      // TODO: Change navigation when redirection from service home page is ready
      And("the Organisation user navigates to '/invalid-xml' page")
      InvalidXmlPage.navigateInvalidXmlPage()

      And("the Organisation user clicks 'Upload a different file' link on '/invalid-xml' page")
      InvalidXmlPage.clickOnLink(InvalidXmlPage.uploadADifferentFileLink)
    }
  }
}
