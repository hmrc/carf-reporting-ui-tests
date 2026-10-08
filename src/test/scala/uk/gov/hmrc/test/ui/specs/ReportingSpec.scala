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

    Scenario("1 - Organisation user uploads Valid file - Fast journey", ReportingTests) {

      Given("the Organisation user logs in with a valid CARF ID")
      AuthLoginPage.loginAsOrgAdminWithoutCtUtr("RG1111")

      And("the Organisation user clicks on 'Upload an XML file' link on '/manage-cryptoasset-reports' page")
      ServiceHomePage.clickOnLink(ServiceHomePage.uploadXmlFileLink)

      And("the Organisation user uploads a valid file on '/upload-file' page")
      UploadFilePage.fileUpload("accepted-valid-carf.xml")

      And("the Organisation user clicks 'Continue' on '/check-your-file-details' page")
      CheckYourFileDetailsPage.onPageContinueById()

      And("the Organisation user click 'Confirm and send' on '/send-your-file' page")
      SendYourFilePage.onPageSubmitById()
      SendYourFilePage.loadingSpinnerDisappear(150)

      And("the Organisation user click 'Upload another file' link on '/file-confirmation' page")
      FileConfirmationPage.clickOnLinkWithUploadIdPage(FileConfirmationPage.uploadAnotherFileId)

      And("the Organisation user is on '/upload-file' page")
      UploadFilePage.onPage()

    }

    Scenario("2 - Organisation user uploads Valid file - Slow journey", ReportingTests) {

      Given("the Organisation user logs in with a valid CARF ID")
      AuthLoginPage.loginAsOrgAdminWithoutCtUtr("RG1121")

      And("the Organisation user clicks on 'Upload an XML file' link on '/manage-cryptoasset-reports' page")
      ServiceHomePage.clickOnLink(ServiceHomePage.uploadXmlFileLink)

      And("the Organisation user uploads a valid file on '/upload-file' page")
      UploadFilePage.fileUpload("accepted-slow-valid-carf.xml")

      And("the Organisation user clicks 'Continue' on '/check-your-file-details' page")
      CheckYourFileDetailsPage.onPageContinueById()

      And("the Organisation user click 'Confirm and send' on '/send-your-file' page")
      SendYourFilePage.onPageSubmitById()
      SendYourFilePage.loadingSpinnerDisappear(150)

      And("the Organisation user clicks '/Refresh for updates' button on '/still-checking-your-file' page")
      StillCheckingYourFilePage.refreshUntilRedirected(StillCheckingYourFilePage.refreshForUpdatesButton, 150)

      And("the Organisation user click 'Go to confirmation' button on '/file-passed-checks' page")
      FilePassedCheckPage.onPageContinueById()

      And("the Organisation user click 'Upload another file' link on '/file-confirmation' page")
      FileConfirmationPage.clickOnLinkWithUploadIdPage(FileConfirmationPage.uploadAnotherFileId)

      And("the Organisation user is on '/upload-file' page")
      UploadFilePage.onPage()
    }

    Scenario("3 - Organisation user uploads Invalid file", ReportingTests) {
      Given("the Organisation user logs in with a valid CARF ID")
      AuthLoginPage.loginAsOrgAdminWithoutCtUtr("RG1131")

      And("the Organisation user clicks on 'Upload an XML file' link on '/manage-cryptoasset-reports' page")
      ServiceHomePage.clickOnLink(ServiceHomePage.uploadXmlFileLink)

      And("the Organisation user uploads malformed file on '/upload-file' page")
      UploadFilePage.fileUpload("malformed-xml.xml")

      And("the Organisation user clicks 'Upload a different file' link on '/invalid-xml' page")
      InvalidXmlPage.clickOnLink(InvalidXmlPage.uploadAnotherFileId)

      And("the Organisation user uploads data error file on '/upload-file' page")
      UploadFilePage.fileUpload("data-error-carf.xml")

      And("the Organisation user clicks 'Upload the updated file' link on '/data-errors' page")
      DataErrorsPage.clickOnLink(DataErrorsPage.uploadAnotherFileId)

      And("the Organisation user uploads rcasp not matching file on '/upload-file' page")
      UploadFilePage.fileUpload("no-rcasp-id.xml")

      And("the Organisation user clicks 'Upload the updated file' link on '/rcasp-not-matching' page")
      RcaspNotMatchingPage.clickOnLink(RcaspNotMatchingPage.uploadAnotherFileId)

      And("the Organisation user uploads virus file on '/upload-file' page")
      UploadFilePage.fileUpload("virus-carf.xml")

      And("the Organisation user clicks 'Continue' on '/check-your-file-details' page")
      CheckYourFileDetailsPage.onPageContinueById()

      And("the Organisation user click 'Confirm and send' on '/send-your-file' page")
      SendYourFilePage.onPageSubmitById()
      SendYourFilePage.loadingSpinnerDisappear(150)

      And("the Organisation user clicks 'Upload the updated file' link on '/virus-found' page")
      VirusFoundPage.clickOnLinkWithUploadIdPage(VirusFoundPage.uploadAnotherFileId)

      And("the Organisation user uploads rejected slow file on '/upload-file' page")
      UploadFilePage.fileUpload("rejected-slow-carf.xml")

      And("the Organisation user clicks 'Continue' on '/check-your-file-details' page")
      CheckYourFileDetailsPage.onPageContinueById()

      And("the Organisation user click 'Confirm and send' on '/send-your-file' page")
      SendYourFilePage.onPageSubmitById()
      SendYourFilePage.loadingSpinnerDisappear(150)

      And("the Organisation user clicks '/Refresh for updates' button on '/still-checking-your-file' page")
      StillCheckingYourFilePage.refreshUntilRedirected(StillCheckingYourFilePage.refreshForUpdatesButton, 150)

      And("the Organisation user click 'Check errors' button on '/file-failed-checks' page")
      FileFailedChecksPage.onPageContinueById()

      And("the Organisation user clicks 'Upload the updated file' link on '/rules-errors' page")
      RuleErrorsPage.clickOnLinkWithUploadIdPage(RuleErrorsPage.uploadAnotherFileId)

      Then("the Organisation user is redirected to '/upload-file' page")
      UploadFilePage.onPage()
    }
  }
}
