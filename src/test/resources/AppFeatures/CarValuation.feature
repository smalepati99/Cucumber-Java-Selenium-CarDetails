Feature: Check the Car details in Cazoo

  As a used car buyer
  I want to check the value & details of the cars list I have are correct from a 3rd party (Cazoo)
  So that I know car details I hold are correct

  @smoke @carDetailsComparison
  Scenario: Compare the Car details between the Cazoo and below datatable by extracting the Car Registration Numbers from Input File
    Given I navigate to carzoo value my car page
    When I see title of the page is "Value your car with our free car valuation calculator | Cazoo"
    And I see header of the page is "Value my car"
    Then I input the registration numbers in the "inputFilePath" and check the displayed car details are correct as follow
      | REGISTRATION | MAKE       | MODEL                                                                   |
      | AD58VNF      | BMW        | 1 Series 2.0 120d M Sport Coupe 2dr Diesel Manual (128 g/km, 177 bhp)   |
      | BW57BOF      | Toyota     | Yaris 1.0 VVT-i T2 Hatchback 3dr Petrol Manual (127 g/km, 67 bhp)       |
      | KT17DLX      | SKODA      | Superb 2.0 TDI SportLine Estate 5dr Diesel DSG Auto 6Spd (s/s) (190 ps) |
      | SG18HTN      | Volkswagen | Golf 1.5 TSI EVO SE Nav Hatchback 5dr Petrol (s/s) (130 ps)             |
