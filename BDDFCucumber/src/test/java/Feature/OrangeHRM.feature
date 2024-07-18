Feature: Test OrangeHRM appication

  @tag1
  Scenario: Validate login functionality
    Given Enter given username and password
    When Click on login button
    Then Validate login title

  Scenario: Validate Home functionality
    When validate title of Home fun
    Then Validate URL of Home fun

  @tag2
  Scenario Outline: Validate PIM Functionality
    Given Click on PIM,click on Add employee
    When Enter "<firstname>","<lastname>","<middlename>",Capture employee id
    And Click on Save button
    And Enter "<country>" and Select "<gender>",Click on Save Button
    When click on emplyoee list, enter employee id
    And Click on Search button
    Then delete employee and confirm delete

    Examples: 
      | firstname | lastname | middlename | country | gender |
      | sukhada   | naiks     | gajanan    | Indian  | Female |
       | Shyam   | sawant     | Manoj    | Indian  | Male |

    
