CREATE DATABASE IF NOT EXISTS Bank;
USE Bank;

CREATE TABLE Customers (
    CustomerID INT PRIMARY KEY,
    Name VARCHAR(100),
    DOB DATE,
    Balance INT,
    LastModified DATE
);

CREATE TABLE Accounts (
    AccountID INT PRIMARY KEY,
    CustomerID INT,
    AccountType VARCHAR(20),
    Balance INT,
    LastModified DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Transactions (
    TransactionID INT PRIMARY KEY,
    AccountID INT,
    TransactionDate DATE,
    Amount INT,
    TransactionType VARCHAR(10),
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);

CREATE TABLE Loans (
    LoanID INT PRIMARY KEY,
    CustomerID INT,
    LoanAmount INT,
    InterestRate INT,
    StartDate DATE,
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Employees (
    EmployeeID  INT PRIMARY KEY,
    Name VARCHAR(100),
    Position VARCHAR(50),
    Salary INT,
    Department VARCHAR(50),
    HireDate DATE
); 


INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (1, 'John Doe', DATE('1985-05-15'), 10000, DATE('2025-06-25'));

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified) VALUES
(3, 'Amit Verma', '1955-04-12', 150000, '2025-06-20'),
(4, 'Riya Sharma', '1988-09-22', 200000, '2025-06-21'),
(5, 'John Dsouza', '1948-12-01', 120000, '2025-06-18'),
(6, 'Meena Kapoor', '1975-03-30', 175000, '2025-06-22'),
(7, 'Rahul Nair', '1960-07-15', 190000, '2025-06-24');


INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (2, 'Jane Smith', DATE('1990-07-20'), 1500, DATE('2025-05-25'));

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (1, 1, 'Savings', 1000, DATE('2025-06-25'));

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (2, 2, 'Checking', 1500, DATE('2025-05-25'));

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified) VALUES
(3, 3, 'Savings', 50000, '2025-06-20'),
(4, 4, 'Current', 80000, '2025-06-21'),
(5, 5, 'Savings', 30000, '2025-06-18'),
(6, 6, 'Current', 60000, '2025-06-22'),
(7, 7, 'Savings', 90000, '2025-06-24');


INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (1, 1, DATE('2025-06-25'), 200, 'Deposit');

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (2, 2, DATE('2025-05-25'), 300, 'Withdrawal');

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType) VALUES
(3, 3, '2025-06-01', 5000, 'Credit'),
(4, 4, '2025-06-05', 10000, 'Debit'),
(5, 5, '2025-06-10', 2000, 'Credit'),
(6, 6, '2025-06-15', 3000, 'Debit'),
(7, 7, '2025-06-20', 4000, 'Credit');


INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (1, 1, 5000, 5, DATE('2025-06-30'), DATE('2025-08-30') );

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate) VALUES
(2, 3, 150000, 9, '2023-05-15', '2028-05-15'),
(3, 5, 200000, 8, '2024-07-01', '2029-07-01'),
(4, 2, 100000, 11, '2025-03-01', '2030-03-01'),
(5, 4, 180000, 12, '2023-11-01', '2028-11-01');


INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', DATE('2015-06-15'));

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (2, 'Bob Brown', 'Developer', 60000, 'IT', DATE('2017-03-20'));

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate) VALUES
(3, 'Sunil Kumar', 'Manager', 75000, 'Loans', '2020-01-15'),
(4, 'Priya Mehta', 'Clerk', 40000, 'Accounts', '2021-05-10'),
(5, 'Rajesh Patel', 'Analyst', 60000, 'Finance', '2022-09-01'),
(6, 'Anita Rao', 'Assistant Manager', 65000, 'Customer Service', '2019-12-20'),
(7, 'David Fernandes', 'Cashier', 35000, 'Teller', '2023-03-05');


 -- example 1-- 
 
DELIMITER $$

CREATE PROCEDURE ApplySeniorLoanDiscount()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE v_customer_id INT;
    DECLARE v_dob DATE;
    DECLARE v_age INT;

    DECLARE cur CURSOR FOR
        SELECT CustomerID, DOB FROM Customers;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN cur;

    read_loop: LOOP
        FETCH cur INTO v_customer_id, v_dob;
        IF done THEN
            LEAVE read_loop;
        END IF;

        -- Calculate age
        SET v_age = TIMESTAMPDIFF(YEAR, v_dob, CURDATE());

        IF v_age > 60 THEN
            -- Apply 1% discount to loans for senior customers
            UPDATE Loans
            SET InterestRate = InterestRate * 0.99
            WHERE CustomerID = v_customer_id;
        END IF;
    END LOOP;

    CLOSE cur;
END$$

DELIMITER ;

call ApplySeniorLoanDiscount();


-- Step 1: Add the column (if needed)
ALTER TABLE Customers ADD COLUMN IsVIP BOOLEAN DEFAULT FALSE;

-- Step 2: Stored Procedure to set VIPs

DELIMITER $$

CREATE PROCEDURE PromoteVIPCustomers()
BEGIN
    UPDATE Customers
    SET IsVIP = TRUE
    WHERE Balance > 10000;
END$$

DELIMITER ;


-- Call it
CALL PromoteVIPCustomers();


DELIMITER $$

CREATE PROCEDURE SendLoanDueReminders()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE v_customer_id INT;
    DECLARE v_end_date DATE;
    DECLARE cur CURSOR FOR
        SELECT CustomerID, EndDate
        FROM Loans
        WHERE EndDate BETWEEN CURDATE() AND CURDATE() + INTERVAL 30 DAY;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN cur;

    read_loop: LOOP
        FETCH cur INTO v_customer_id, v_end_date;
        IF done THEN
            LEAVE read_loop;
        END IF;

        -- Simulate a message output (in real apps, log or email)
        SELECT CONCAT('Reminder: Customer ', v_customer_id,
                      ' has a loan due on ', v_end_date) AS Reminder;
    END LOOP;

    CLOSE cur;
END$$

DELIMITER ;

-- Call it
CALL SendLoanDueReminders();





DELIMITER $$

CREATE PROCEDURE ProcessMonthlyInterest()
BEGIN
    UPDATE Accounts
    SET Balance = Balance * 1.01
    WHERE AccountType = 'Savings';
END$$

DELIMITER ;

DELIMITER $$

CALL ProcessMonthlyInterest();

DELIMITER $$
CREATE PROCEDURE UpdateEmployeeBonus(
    IN dept_name VARCHAR(50),
    IN bonus_percent DECIMAL(5,2) -- e.g., pass 5 for 5%
)
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * bonus_percent / 100)
    WHERE Department = dept_name;
END$$

DELIMITER ;

CALL UpdateEmployeeBonus('Loans', 5);  

DELIMITER $$
CREATE PROCEDURE TransferFunds(
    IN source_account_id INT,
    IN target_account_id INT,
    IN amount INT
)
BEGIN
    DECLARE source_balance INT;

    -- Get the current balance of the source account
    SELECT Balance INTO source_balance
    FROM Accounts
    WHERE AccountID = source_account_id;

    -- Check if balance is sufficient
    IF source_balance >= amount THEN
        -- Deduct from source
        UPDATE Accounts
        SET Balance = Balance - amount
        WHERE AccountID = source_account_id;

        -- Add to target
        UPDATE Accounts
        SET Balance = Balance + amount
        WHERE AccountID = target_account_id;

    ELSE
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Insufficient balance in source account';
    END IF;
END$$

DELIMITER ;

CALL TransferFunds(3, 2, 5000);  
	

