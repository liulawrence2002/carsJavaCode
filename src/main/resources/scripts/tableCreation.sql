CREATE TABLE CARSUser (
    id INT PRIMARY KEY IDENTITY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE Institution (
    id INT PRIMARY KEY IDENTITY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE FundingOpportunity (
    id INT PRIMARY KEY IDENTITY,
    title VARCHAR(200) NOT NULL,
    description TEXT
);

CREATE TABLE GrantApplication (
    id INT PRIMARY KEY IDENTITY,
    proposalId VARCHAR(50) UNIQUE NOT NULL,
    projectTitle VARCHAR(200) NOT NULL,
    projectType VARCHAR(100) NOT NULL,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(200) NOT NULL,
    institutionId INT FOREIGN KEY REFERENCES Institution(id),
    abstract TEXT,
    goals TEXT,
    objectives TEXT,
    userId INT FOREIGN KEY REFERENCES CARSUser(id),
    status VARCHAR(50) DEFAULT 'DRAFT' -- DRAFT or SUBMITTED
);

CREATE TABLE ProjectBudget (
    id INT PRIMARY KEY IDENTITY,
    personnelCost DECIMAL(18, 2),
    fringeBenefit DECIMAL(18, 2),
    equipmentCost DECIMAL(18, 2),
    indirectCost DECIMAL(18, 2),
    grantApplicationId INT FOREIGN KEY REFERENCES GrantApplication(id)
);

CREATE TABLE SupportDocument (
    id INT PRIMARY KEY IDENTITY,
    fileName VARCHAR(200) NOT NULL,
    filePath VARCHAR(500) NOT NULL,
    grantApplicationId INT FOREIGN KEY REFERENCES GrantApplication(id)
);
/*
  insert into [dbo].[news_announcements] ([date],[description],[title])
  values (getdate(), 'New funding annaouced on 12-20-2024 to start RP26-1','CPRIT Started RP26-1')
insert into [dbo].[news_announcements] ([date],[description],[title])
  values (getdate(), 'New funding annaouced on 12-22-2024 to start RP26-2','CPRIT Started RP26-2')
insert into [dbo].[news_announcements] ([date],[description],[title])
  values (getdate(), 'New funding annaouced on 12-30-2024 to start RP26-3','CPRIT Started RP26-3')

*/