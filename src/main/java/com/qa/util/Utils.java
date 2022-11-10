package com.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class Utils {
    WebDriver driver;

    public Utils(WebDriver driver) {
        this.driver = driver;
    }

    public boolean existsElement(String id) {
        try {
            driver.findElement(By.id(id));
        } catch (NoSuchElementException noSuchElementException) {
            return false;
        }
        return true;
    }
}