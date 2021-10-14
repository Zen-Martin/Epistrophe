@Web
Feature: Re-Test Cases for Epistrophe Website without account Access
  Background:
    Given I am on the homePage

  @bug_1653
  @severity=minor
  Scenario: Incorrect redirection url : instagram or goole+
    When Click on the logo *g* of Google+ located at the header
    Then A redirection is made to the Instagram page of the Epistrophe site

  @bug_1659
  @severity=minor
  Scenario: The text are not in the right tag
    When In the carousel, overlay the black text on the slides
    Then Text are placed in <a> tags instead of <p>

  @bug_1664
  @severity=minor
  Scenario: Unnecessary space
    When In the navigation bar, put the cursor on *Messagerie Pro* and click on *Google Workspace*
    Then There is an empty space between the title and the list of applications presented below

#  @recommandation_1671
#  @severity=minor
#  Scenario: Do not use Google form for the order
#    And In the navigation bar, put the cursor on *Nom de domaine* and click on *commandez votre nom de domaine*
#    When Fill in all the form fields with *@@@@@* and send
#    Then The form is sent successfully although the values are incorrect

  @bug_1706
  @severity=minor
  Scenario: Link to a non-secure site
    When In the navigation bar, put the cursor on *Nom de domaine* and click on *Domaine en .Africa*
    Then A redirection is made to the site *epistrophe.africa*, that is not secure

  @bug_1709
  @severity=minor
  Scenario: Non-aligned elements
    When In the navigation bar, put the cursor on *Certificats SSL* and click on *Offres standard Epistrophe*
    Then The SSL Certificates page is displayed
    And It is noted that the size of the package presentation components is disproportionate

  @bug_1716
  @severity=minor
  Scenario: Lack of redirection link
    When In the navigation bar, put the cursor on *Contacts & infos* and click on *Press book*
    Then No reaction, the link is not associated with any url

#  @bug_1726
#  @severity=minor
#  Scenario: Button display problem
#    When Under the navigation bar, there are elements presenting some of the services offered by Epistrophe
#    Then The outlines of *DECOUVRIR* and *COMMANDEZ* buttons are not fully visible

  @bug_1729
  @severity=minor
  Scenario: Content alignment
    When Scroll down to the offers
    Then Note that the elements are note aligned

  @bug_1732
  @severity=minor
  Scenario: Incorrect url : twitter fake redirection
    When Scroll down to the section *Nos références*, at the panel level *Contactez-nous* click on the Twitter link
    Then A redirection is made to Twitter with a message mentioning that the page does not exist

#  @bug_1740
#  @severity=blocker
#  Scenario: No file are accepted
#    When In the navigation bar, click on "Contacts & infos"
#    And Scroll down and click on "poser sa candidature"
#    And Fill in the fields and select a word file for the cover letter and a PDF for the CV and click on "Envoyer"
#    Then Errors are mentionned underneath CVs and cover letter saying that the files are not allowed

#  @recommandation_1741
#  @severity=minor
#  Scenario: Make the CV and cover letter fields mandatory
#    And In the navigation bar, click on "Contacts & infos"
#    When Scroll down and click on "poser sa candidature"
#    And Fill in the fields without selecting a file for the CV and the cover letter
#    And Click on "Envoyer"
#    Then Make the CV and cover letter fields mandatory
#    But The application has been send normally

#  @recommandation_1746
#  @severity=minor
#  Scenario: Adding an anchor
#    When In the navigation bar, put the cursor on *Nom de domaine* and click on *Domaine en .Africa*
#    And A redirection is made to the site "epistrophe.africa", scroll down to the form
#    And Fill in and validate
#    Then Adding an anchor to the sending confirmation message
#    But The cursor remains at the buttom of the page giving the impression that the page is empty.

#  @recommandation_1747
#  @severity=minor
#  Scenario: Justify the text
#    When In the navigation bar, put the cursor on *Nom de domaine* and click on *Domaine en .Africa*
#    And A redirection is made to the site "epistrophe.africa", scroll down to the form
#    Then Text should be justify
#    But Text is not justify but left aligned

  @bug_1750
  @severity=minor
  Scenario: 404 error
    When In the navigation bar, put the cursor on *Site* and click on *Portfolio Site Web*
    And Page opens click on one item, in the breadcrumb trail below the title click on *Portfolio item*
    Then A 404 error page is displayed

  @bug_1759
  @severity=minor
  Scenario: Links returning an error
    When In the navigation bar, put the cursor on *Site* and click on *Portfolio Site Web*
    And Page opens click on the image with the text *La location et la vente*
    And The page opens, click on *voir le site*
    Then Displaying the page with a site unreachable error

  @bug_1762
  @severity=minor
  Scenario: Translation error
    When In the navigation bar, put the cursor on *Site* and click on *Portfolio Site Web*
    Then Page opens, some texts on the page are in English including *select category* and *next page*