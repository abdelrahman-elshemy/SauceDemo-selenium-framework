# 🚀 SauceDemo Selenium Automation Framework

## 📌 Overview

Professional UI Automation Framework built for SauceDemo using:

- ☕ Java
- 🌐 Selenium WebDriver
- 🧪 TestNG
- 🥒 Cucumber BDD
- 📦 Maven
- 🧱 Page Object Model (POM)
- 🧠 Object-Oriented Programming (OOP)
- 🔁 Retry Analyzer
- 📊 Data Driven Testing

The framework is designed to be scalable, reusable, and easy to maintain following industry best practices.

---

# 🏗️ Framework Architecture

```text
Tests / Step Definitions
        ↓
Page Object Classes (POM)
        ↓
Base Classes & Utilities
        ↓
Selenium WebDriver
```

---

# 📂 Project Structure

```text
src
├── main/java
│   └── pages
│
├── test/java
│   ├── tests
│   ├── cucumber
│   ├── utilities
│   ├── listeners
│   └── data
│
├── testng.xml
├── testng-parallel-execution.xml
└── pom.xml
```

---

# 🧱 Design Patterns & Components

## ✅ Page Object Model (POM)

Each page contains:

- Web Elements
- Actions
- Validations
- Reusable Methods

### Benefits
- Better maintenance
- Cleaner code
- Reusability

---

## ⚙️ Base Classes

### `BasePage`
Contains reusable Selenium actions:
- Click
- Send Keys
- Waits
- Element Handling

### `BaseTest`
Responsible for:
- Driver setup
- Browser initialization
- Teardown

---

# 🥒 Cucumber BDD

Framework supports BDD using:
- Feature Files
- Step Definitions
- Hooks
- Runner Classes

Example:
```gherkin
Given User opens login page
When User enters valid credentials
Then User should login successfully
```

---

# 🔁 Retry Analyzer

Custom Retry Analyzer automatically retries failed tests to reduce flaky failures and improve execution stability.

---

# 📊 Data Driven Testing

Supports dynamic test data handling using external data readers for better test coverage and flexibility.

---

# ⚡ Parallel Execution

Parallel execution supported using:

```text
testng-parallel-execution.xml
```

Benefits:
- Faster execution
- Reduced runtime

---

# 📈 Reporting

Generated reports include:
- ✅ Passed Tests
- ❌ Failed Tests
- ⏭️ Skipped Tests

Location:
```text
target/surefire-reports
```

---

# 🛠️ Maven Dependencies

Main dependencies:
- Selenium Java
- TestNG
- Cucumber
- WebDriverManager
- Apache POI

Managed through:
```text
pom.xml
```

---

# ▶️ Run The Project

## 🥒 Run All Cucumber Runners

```bash
mvn test -P Cucumber-Runner -Drunner=CucumberRunner/*Runner -Dbrowser=edge
```

---

## ⚡ Run Sequential Execution

```bash
mvn test -P sequential-execution -Dbrowser=edge
```

---

## 🚀 Run Parallel Execution

```bash
mvn test -P parallel-execution -Dbrowser=edge
```

---

# ✨ Best Practices Applied

- OOP Principles
- POM Design Pattern
- Reusable Components
- Centralized Driver Management
- Clean Architecture
- BDD Implementation
- Retry Mechanism
- Parallel Execution

---

# 👨‍💻 Author

Professional Selenium Automation Framework developed to demonstrate real-world automation testing skills and framework design principles.

