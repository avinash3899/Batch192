-- create table mp192stud(empno number, name varchar(30), address varchar2(30), dob date, phone number);
-- INSERT INTO mp192stud VALUES (101, 'Avinash Sinha', 'Bihar', '03-aug-1999', 9473421105);
-- INSERT INTO mp192stud VALUES (102, 'Ujjwal Kesri', 'UP', '05-sep-1998', 7007284316);
SELECT * FROM CUSTOMERS ORDER BY CUSTOMER_ID;
select months_between('28-mar-2019','28-feb-2020') from dual;
select last_day(sysdate)from dual;
select last_day('02-feb-2019')from dual;
select to_char(sysdate,'DD Month yyyy HH:MI:SS AM AD') from dual;

SELECT * FROM EMPLOYEE;

DECLARE
ACC_NO EMPLOYEE.ACCNO%TYPE := 1011;
SAL EMPLOYEE.SALARY%TYPE;
BEGIN
SELECT SALARY INTO SAL FROM EMPLOYEE WHERE ACCNO = ACC_NO;
IF(SAL<50000) THEN
UPDATE EMPLOYEE SET SALARY = SALARY +30000 WHERE ACCNO=ACC_NO;
COMMIT;
END IF;
END;

DECLARE
X NUMBER := 10;
BEGIN
LOOP
DBMS_OUTPUT.PUT_LINE(X);
X:=X+10;
IF X>60 THEN
EXIT;
END IF;
END LOOP;
DBMS_OUTPUT.PUT_LINE('AFTER EXIT X IS: '||X);
END;

DECLARE
X NUMBER :=10;
BEGIN
WHILE X<=60 LOOP
DBMS_OUTPUT.PUT_LINE(X /*IN VARCHAR2*/);
X:=X+10;
END LOOP;
END;

DECLARE
A NUMBER;
BEGIN
FOR A IN 10..60 LOOP
DBMS_OUTPUT.PUT_LINE('VALUE OF A IS : '||A /*IN VARCHAR2*/);
END LOOP;
END;

DECLARE 
   i number(30); 
   j number(30); 
BEGIN 
   i := 2; 
   LOOP 
      j:= 2; 
      LOOP 
         exit WHEN ((mod(i, j) = 0) or (j = i)); 
         j := j +1; 
      END LOOP; 
   IF (j = i ) THEN 
      dbms_output.put_line(i || ' is prime'); 
   END IF; 
   i := i + 1; 
   exit WHEN i = 100; 
   END LOOP; 
END; 



DECLARE 
   a number(2) := 10; 
BEGIN 
   -- while loop execution  
   WHILE a < 20 LOOP 
   IF a = 15 THEN 
         -- skip the loop using the CONTINUE statement 
         a := a + 1; 
         CONTINUE; 
      END IF;
      dbms_output.put_line ('value of a: ' || a); 
      a := a + 1; 
       
   END LOOP; 
END; 









CREATE OR REPLACE TRIGGER TRIGGER1
BEFORE INSERT ON MP192STUDENT
BEGIN
IF((TO_CHAR(SYSDATE, 'DY')IN('SAT','SUN')) OR (TO_CHAR(SYSDATE,'HH24')NOT BETWEEN '09' AND '18')) THEN
RAISE_APPLICATION_ERROR('-20200','YOU CAN ONLY INSERT BETWEEN BUSINESS HOURS');
END IF;
END;

INSERT INTO MP192STUDENT VALUES (106,'UTTKARSH','PATNA','24-JUL-1999',9009787878);

SELECT TO_CHAR(to_date('1998/12/31:06:00:00PM', 'yyyy/mm/dd:hh:mi:ssam'),'MON') FROM DUAL;

   SELECT * FROM MP192STUDENT ORDER BY EMPNO ASC;
DELETE FROM MP192STUDENT WHERE EMPNO=111;

insert into mp192student(name) values ('Savita');

   select * from EMPLOYEE;



DECLARE
N NUMBER;
BEGIN
N:=10/0;
EXCEPTION
WHEN ZERO_DIVIDE THEN
DBMS_OUTPUT.PUT_LINE('ZERO DIVIDE ERROR' /*IN VARCHAR2*/);
END;

