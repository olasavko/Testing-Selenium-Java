public class InterviewQA {
    /*
    1. How would you handle UI dropdowns?
    - by using Select class
    2. What methods does Select class have?
    - select option from dropdown using text/index/value attribute/
    - select multiple options

    3. How do you handle alerts?
    - driver.switchTo().alert()
    - methods: accept()/dismiss()/getText()

    4. How do you handle checkboxes?
    - isSelected() method

    5. Radio buttons
    - if 2 radio buttons have the same object id attributes:
     use findElements() method -> how many radio buttons are present in that section size() ->
    - if you need to handle all radio buttons (click on each):
     find the size of group -> keep it in a loop for{} and use get(i) method
     - want to get specific value:
     add if{} condition into loop for{} and use equal() method
     - want to get attribute "value" of each radio button: use get(i).getAttribute("value")

     6. Tab and click Enter
     driver.findElement(By.???()).sendKeys(Keys.TAB);
     driver.findElement(By.???()).sendKeys(Keys.ENTER);

     */
}
