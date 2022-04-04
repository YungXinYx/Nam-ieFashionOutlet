CREATE TABLE "CUSTOMER" (
    "CUSTOMERID" VARCHAR(15) NOT NULL PRIMARY KEY,
    "CUSTOMERNAME" VARCHAR(30) NOT NULL,
    "CUSTOMERIC" VARCHAR(15) NOT NULL UNIQUE,
    "ADDRESS1" VARCHAR(20) NOT NULL,
    "ADDRESS2" VARCHAR(20),
    "POSTCODE" INTEGER NOT NULL,
    "COUNTRY" VARCHAR(20) NOT NULL
);

CREATE TABLE "STAFF" (
    "STAFFID" VARCHAR(15) not null primary key,
    "STAFFNAME" VARCHAR(50),
    "STAFFIC" VARCHAR(50)  unique,
    "ADDRESSLINE1" VARCHAR(40),
    "ADDRESSLINE2" VARCHAR(40),
    "POSTCODE" INTEGER,
    "COUNTRY" VARCHAR(30) not null
);

CREATE TABLE "ORDERS" (
    "ORDERID" VARCHAR(15) NOT NULL PRIMARY KEY,
    "ORDERDATETIME" TIMESTAMP NOT NULL,
    "CUSTOMERID" VARCHAR(15) NOT NULL,
    FOREIGN KEY ("CUSTOMERID") references "CUSTOMER"("CUSTOMERID")
);

CREATE TABLE "CATEGORY" (
    "CATEGORYID" CHAR(1) not null primary key,
    "CATEGORYNAME" VARCHAR(30) not null
);

CREATE TABLE "PRODUCT" (
	"PRODUCTID"	VARCHAR(15) NOT NULL PRIMARY KEY,
	"PRODUCTNAME"	VARCHAR(100) NOT NULL,
	"PRODUCTPRICE"	REAL,
    "PRODUCTIMAGE1" BLOB NOT NULL,
    "PRODUCTIMAGE2" BLOB NOT NULL,
	"QUANTITY"	INTEGER NOT NULL,
    "CATEGORYID" CHAR(1) not null,
	FOREIGN KEY ("CATEGORYID") references "CATEGORY"("CATEGORYID")
);


CREATE TABLE "ORDER_DETAILS" (
    "ORDERID" VARCHAR(15) NOT NULL,
    "PRODUCTID" VARCHAR(15) NOT NULL,
    "PRODUCTQUANTITY" INTEGER NOT NULL,
    PRIMARY KEY (ORDERID, PRODUCTID),
    FOREIGN KEY ("ORDERID") references "ORDERS"("ORDERID"),
    FOREIGN KEY ("PRODUCTID") references "PRODUCT"("PRODUCTID")
);

CREATE TABLE "PAYMENT" (
	"PAYMENTID" VARCHAR(15) NOT NULL PRIMARY KEY,
	"CREDITCARDNUMBER" VARCHAR(16) NOT NULL,
	"CREDITCARDCVV"	   VARCHAR(3) NOT NULL,
	"CREDITCARDEXPIREDDATE" DATE,
	"PAYMENTDATETIME" TIMESTAMP,
	"PAYMENTAMOUNT"	REAL,
	"PAYMENTSTATUS"	VARCHAR(20),
	"DELIVERYFEE"	REAL,
	"ORDERID"		VARCHAR(15) NOT NULL,
	FOREIGN KEY ("ORDERID") references "ORDERS"("ORDERID")
);

CREATE TABLE "CUSTOMER_ACCOUNT" (
	"USERNAME" VARCHAR(10) not null primary key,
	"PASSWORD" VARCHAR(8) not null,
	"EMAIL" VARCHAR(255) not null,
	"CUSTOMERID" VARCHAR(15) not null unique,
	FOREIGN KEY("CUSTOMERID") REFERENCES "CUSTOMER"("CUSTOMERID")
);

CREATE TABLE "STAFF_ACCOUNT" (
	"USERNAME" VARCHAR(10) not null primary key,
	"PASSWORD" VARCHAR(8) not null,
	"EMAIL" VARCHAR(255) not null,
	"STAFFID" VARCHAR(15) not null unique,
	FOREIGN KEY("STAFFID") REFERENCES "STAFF"("STAFFID")
);

CREATE TABLE "DELIVERY" (
	"DELIVERYID"		VARCHAR(15) NOT NULL PRIMARY KEY,
	"DELIVERYDATETIME"	TIMESTAMP,
	"DELIVERYSTATUS"	VARCHAR(20),
	"RECEIVERNAME"		VARCHAR(30)	NOT NULL,
        "ADDRESSLINE1" 		VARCHAR(20) NOT NULL,
        "ADDRESSLINE2" 		VARCHAR(20),
        "POSTCODE"		INTEGER NOT NULL,
        "COUNTRY"		VARCHAR(20) NOT NULL,
	"RECEIVERPHONENUMBER"	VARCHAR(11) NOT NULL,
	"ORDERID"		VARCHAR(15) NOT NULL,
	FOREIGN KEY ("ORDERID") references "ORDERS"("ORDERID")
);

CREATE TABLE "FEEDBACK" (
    "FEEDBACKCODE" VARCHAR(15) NOT NULL PRIMARY KEY,
    "RATING" INTEGER NOT NULL,
    "COMMENTS" VARCHAR(100),
    "STAFFREPLY" VARCHAR(100),
    "CUSTOMERID" VARCHAR(15) NOT NULL,
    "PRODUCTID" VARCHAR(15) NOT NULL,
    FOREIGN KEY ("CUSTOMERID") references "CUSTOMER"("CUSTOMERID"),
    FOREIGN KEY ("PRODUCTID") references "PRODUCT"("PRODUCTID")
);

INSERT INTO CATEGORY VALUES ('D', 'Dresses');
INSERT INTO CATEGORY VALUES ('T', 'Tops');
INSERT INTO CATEGORY VALUES ('B', 'Bottoms');
INSERT INTO CATEGORY VALUES ('H', 'Hoodies & Sweatshirts');
INSERT INTO CATEGORY VALUES ('J', 'Jumpsuits & Two-piece');