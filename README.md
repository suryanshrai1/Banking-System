# 🏦 Simple Banking System (Java)

This project is a **console-based Banking System** developed in **Java** using only **Arrays** and **Lists** (no database).  
It allows customers to **create accounts**, **deposit money**, **withdraw funds**, **check balances**, and **view transaction history** with proper **validation** and **exception handling**.

---

## ✨ Features
- Create accounts (Savings, Current, Business)
- Deposit money into account
- Withdraw money with balance validation:
  - ❌ No overdraft for Savings accounts
  - ✅ Overdraft up to ₹10,000 for Current/Business accounts
- Check account balance
- View transaction history
- Unique Account Number validation (Primary Key)
- Minimum balance enforcement:
  - ₹1000 for Savings
  - ₹5000 for Current/Business
- Proper exception handling for invalid inputs
- Maintains data using **Java Lists/Arrays**

---

## 📂 File Structure
```bash
├── Main.java
```
- `BankAccount` class: stores customer details and transactions
- `BankingSystem` class: handles the user interface and operations

---

## 🛠 Technologies Used
- Java
- Arrays & ArrayLists
- Exception Handling (try-catch)

---

## 🚀 How to Run
1. Clone this repository:
   ```bash
   git clone https://github.com/suryanshrai1/banking-system-java.git
   ```
2. Navigate to the project directory:
   ```bash
   cd banking-system-java
   ```
3. Compile and run:
   ```bash
   javac Main.java
   java BankingSystem
   ```

---

## 📸 Screenshots

| Create Account | Deposit | Withdraw | View Transactions |
|:--------------:|:-------:|:--------:|:-----------------:|
| ![Create Account](#) | ![Deposit](#) | ![Withdraw](#) | ![Transactions](#) |

*(Add screenshots if you want!)*

---

## 🧪 Test Cases
| Scenario | Expected Result |
|:---------|:----------------|
| Create savings account with ₹800 | ❌ Error: Minimum ₹1000 required |
| Withdraw ₹2000 from Savings with ₹1500 balance | ❌ Error: Insufficient funds |
| Withdraw ₹9000 from Current with ₹5000 balance | ✅ Allowed with overdraft |
| View transaction history | ✅ Show past deposits/withdrawals |

---

## 🎯 Future Improvements
- Add user authentication (login/logout)
- Interest calculation for Savings accounts
- GUI-based frontend (JavaFX / Swing)

---

## 🙌 Acknowledgments
- Inspired by real-world banking operations.
- Built for academic learning and Java practice!

---
