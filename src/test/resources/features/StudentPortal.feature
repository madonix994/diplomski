Feature: Student portal website test feature

  @smoke
  Scenario: Student portal home page validations
    Given User navigates to Student Portal website
    Then All elements are present on the Portal page
    And All navbar elements are present on Portal page

  @smoke
  Scenario: Student portal - validate all pages
    Given User navigates to Student Portal website
    When User navigates and validates page Pocetna strana
    Then User navigates and validates page Vesti
    And User navigates and validates page Osvojeni ESPB
    And User navigates and validates page Upisani semestri
    And User navigates and validates page Polozeni ispiti
    And User navigates and validates page Prijave ispita
    And User navigates and validates page Upisani predmeti
    And User navigates and validates page Teme zavrsnih radova
    And User navigates and validates page Prijave kolokvijuma
    And User navigates and validates page E-prijava
    And User navigates and validates page Skolarina
    And User navigates and validates page Promene na racunu
    And User navigates and validates page Raspored casova
    And User navigates and validates page Pregled konsultacija
    And User navigates and validates page Ponuda za upis
    And User navigates and validates page Popunjavanje uplatnice

  @smoke
  Scenario: Student portal - Download PDFs
    Given User navigates to Student Portal website
    When User navigates and validates page Popunjavanje uplatnice
    Then User downloads both PDF files

  @smoke
  Scenario: Student portal - Validate all exams
    Given User navigates to Student Portal website
    When User navigates and validates page Polozeni ispiti
    Then Expected number of all exams is 43
    And User navigates to Passed exams
    And User navigates to Recognized exams
    And User navigates to Transferred exams
