# Hudl Login Tests

## Context

I have been writing test automation since 2014. This repo represents my first personal GitHub portfolio entry — written at a point in my career when my primary focus was pure QA automation in Java.

If you want to see how my approach has evolved — toward full-stack development, hybrid QE thinking, JavaScript-based tooling, and modern async patterns — take a look at my more recent project:

**[Club Match Companion](https://github.com/dj01305/club-match-companion)**
That project demonstrates full-stack development with React, Node.js, JWT authentication, Playwright E2E tests, Supertest API tests, and GitHub Actions CI — built with a hybrid QE + development mindset. It uses `async/await` throughout, no sleep calls, and tests that are designed to be portable and CI-ready from day one.


## What it is

A Java + Selenium WebDriver test suite that automates login scenarios against the Hudl web application. It covers standard login flows and basic validation cases.

## Tech stack

- Java
- Selenium WebDriver
- TestNG
- Maven

## What I'd do differently today

Looking back at this code with fresh eyes, a few things stand out:

- `Thread.sleep()` is used throughout for waits. At the time I knew about `WebDriverWait`, and it's even present in the code — but I leaned on sleeps as a safety net. Today I'd remove them entirely and rely on explicit waits with `ExpectedConditions` only.
- The properties file path is hardcoded to my local machine (`C:\\Users\\dj051670\\...`). This means the suite only runs on my computer. The fix is a relative path or environment variable — something I now treat as a baseline requirement.
- Two page object fields share the same XPath locator, which is a copy-paste error that would cause silent test confusion.
- Some page classes extend the base driver class when they should just receive it as a constructor argument. Inheritance was the wrong tool there.


