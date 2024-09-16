create table challan
(
    cId      int auto_increment
        primary key,
    cDate    date        null,
    cRemarks text        null,
    cAmount  varchar(25) null
);

create table owners
(
    oId         int auto_increment
        primary key,
    oName       varchar(255) null,
    oCnic       varchar(20)  null,
    oFatherName varchar(255) null,
    oRemarks    text         null
);

create table vehicle
(
    vId         int auto_increment
        primary key,
    vRegister   varchar(50)  null,
    vMake       varchar(100) null,
    vEngineType varchar(50)  null,
    vFuelType   varchar(50)  null,
    vColor      varchar(30)  null
);

