-- 회원 테이블
CREATE TABLE MEMBER (
                        MBR_ID VARCHAR2(20) PRIMARY KEY,
                        CUST_CO_CD VARCHAR2(10) NOT NULL,
                        NAME VARCHAR2(100),
                        EMAIL VARCHAR2(100),
                        PHONE VARCHAR2(20),
                        BIRTH_DATE DATE,
                        GENDER CHAR(1),
                        JOIN_DATE DATE DEFAULT SYSDATE,
                        STATUS CHAR(1) DEFAULT 'A',
                        LAST_LOGIN_DATE TIMESTAMP,
                        TEAM_ID VARCHAR2(10),
                        DEPT_ID VARCHAR2(10),
                        DIV_ID VARCHAR2(10),
                        CREATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP,
                        UPDATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP
);

-- 팀 테이블
CREATE TABLE TEAM (
                      TEAM_ID VARCHAR2(10) PRIMARY KEY,
                      TEAM_NAME VARCHAR2(100) NOT NULL,
                      DEPT_ID VARCHAR2(10),
                      MANAGER_ID VARCHAR2(20),
                      CREATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP,
                      UPDATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP
);

-- 부서 테이블
CREATE TABLE DEPARTMENT (
                            DEPT_ID VARCHAR2(10) PRIMARY KEY,
                            DEPT_NAME VARCHAR2(100) NOT NULL,
                            DIV_ID VARCHAR2(10),
                            MANAGER_ID VARCHAR2(20),
                            CREATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP,
                            UPDATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP
);

-- 본부 테이블
CREATE TABLE DIVISION (
                          DIV_ID VARCHAR2(10) PRIMARY KEY,
                          DIV_NAME VARCHAR2(100) NOT NULL,
                          MANAGER_ID VARCHAR2(20),
                          CREATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP,
                          UPDATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP
);

-- 외주업체(벤더사) 테이블
CREATE TABLE VENDOR (
                        VENDOR_ID VARCHAR2(10) PRIMARY KEY,
                        VENDOR_NAME VARCHAR2(100) NOT NULL,
                        BUSINESS_NO VARCHAR2(20),
                        CONTACT_PERSON VARCHAR2(100),
                        CONTACT_EMAIL VARCHAR2(100),
                        CONTACT_PHONE VARCHAR2(20),
                        ADDRESS VARCHAR2(200),
                        CONTRACT_START_DATE DATE,
                        CONTRACT_END_DATE DATE,
                        STATUS CHAR(1) DEFAULT 'A',
                        CREATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP,
                        UPDATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP
);

-- 프로젝트 테이블
CREATE TABLE PROJECT (
                         PROJECT_ID VARCHAR2(10) PRIMARY KEY,
                         PROJECT_NAME VARCHAR2(100) NOT NULL,
                         TEAM_ID VARCHAR2(10) NOT NULL,
                         VENDOR_ID VARCHAR2(10),
                         START_DATE DATE,
                         END_DATE DATE,
                         BUDGET NUMBER(15,2),
                         STATUS VARCHAR2(10) DEFAULT 'ACTIVE',
                         DESCRIPTION CLOB,
                         PM_MBR_ID VARCHAR2(20),
                         CREATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP,
                         UPDATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP
);

-- 상품 카테고리 테이블
CREATE TABLE PRODUCT_CATEGORY (
                                  CATEGORY_ID VARCHAR2(10) PRIMARY KEY,
                                  CATEGORY_NAME VARCHAR2(100) NOT NULL,
                                  PARENT_CATEGORY_ID VARCHAR2(10),
                                  CREATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP,
                                  UPDATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP
);

-- 상품 테이블
CREATE TABLE PRODUCT (
                         PRODUCT_ID VARCHAR2(20) PRIMARY KEY,
                         PRODUCT_NAME VARCHAR2(200) NOT NULL,
                         CATEGORY_ID VARCHAR2(10),
                         PRICE NUMBER(15,2) NOT NULL,
                         DISCOUNT_RATE NUMBER(5,2) DEFAULT 0,
                         STOCK_QUANTITY NUMBER(10) DEFAULT 0,
                         DESCRIPTION CLOB,
                         STATUS CHAR(1) DEFAULT 'A',
                         PROJECT_ID VARCHAR2(10),
                         CREATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP,
                         UPDATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP
);

-- 주문 마스터 테이블
CREATE TABLE ORDER_MASTER (
                              ORDER_ID VARCHAR2(20) PRIMARY KEY,
                              MBR_ID VARCHAR2(20) NOT NULL,
                              ORDER_DATE TIMESTAMP DEFAULT SYSTIMESTAMP,
                              TOTAL_AMOUNT NUMBER(15,2) NOT NULL,
                              DISCOUNT_AMOUNT NUMBER(15,2) DEFAULT 0,
                              SHIPPING_FEE NUMBER(10,2) DEFAULT 0,
                              FINAL_AMOUNT NUMBER(15,2) NOT NULL,
                              STATUS VARCHAR2(10) DEFAULT 'PENDING',
                              SHIPPING_ADDRESS VARCHAR2(200),
                              SHIPPING_CONTACT VARCHAR2(20),
                              DELIVERY_REQUEST CLOB,
                              CREATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP,
                              UPDATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP
);

-- 주문 상세 테이블
CREATE TABLE ORDER_DETAIL (
                              ORDER_DETAIL_ID VARCHAR2(20) PRIMARY KEY,
                              ORDER_ID VARCHAR2(20) NOT NULL,
                              PRODUCT_ID VARCHAR2(20) NOT NULL,
                              QUANTITY NUMBER(10) NOT NULL,
                              UNIT_PRICE NUMBER(15,2) NOT NULL,
                              DISCOUNT_AMOUNT NUMBER(15,2) DEFAULT 0,
                              LINE_AMOUNT NUMBER(15,2) NOT NULL,
                              CREATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP,
                              UPDATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP
);

-- 결제 수단 테이블
CREATE TABLE PAYMENT_MEAN (
                              MEAN_ID VARCHAR2(10) PRIMARY KEY,
                              MEAN_NAME VARCHAR2(50) NOT NULL,
                              DESCRIPTION VARCHAR2(200),
                              CREATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP,
                              UPDATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP
);

-- 결제 수단 상세 테이블
CREATE TABLE PAYMENT_MEAN_DTL (
                                  MEAN_DTL_ID VARCHAR2(10) PRIMARY KEY,
                                  MEAN_ID VARCHAR2(10) NOT NULL,
                                  DTL_NAME VARCHAR2(50) NOT NULL,
                                  DESCRIPTION VARCHAR2(200),
                                  CREATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP,
                                  UPDATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP
);

-- 결제 마스터 테이블
CREATE TABLE PAYMENT (
                         PAYMENT_ID VARCHAR2(20) PRIMARY KEY,
                         ORDER_ID VARCHAR2(20) NOT NULL,
                         PAYMENT_DATE TIMESTAMP DEFAULT SYSTIMESTAMP,
                         PAYMENT_AMOUNT NUMBER(15,2) NOT NULL,
                         STTL_NO VARCHAR2(30) NOT NULL,
                         MEAN_DTL_ID VARCHAR2(10) NOT NULL,
                         STATUS VARCHAR2(10) DEFAULT 'COMPLETED',
                         CREATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP,
                         UPDATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP
);

-- 현금 결제 테이블
CREATE TABLE PAYMENT_CASH (
                              STTL_NO VARCHAR2(30) PRIMARY KEY,
                              PAYMENT_ID VARCHAR2(20) NOT NULL,
                              BANK_CODE VARCHAR2(10),
                              ACCOUNT_NO VARCHAR2(30),
                              ACCOUNT_HOLDER VARCHAR2(100),
                              CREATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP,
                              UPDATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP
);

-- 카드 결제 테이블
CREATE TABLE PAYMENT_CARD (
                              STTL_NO VARCHAR2(30) PRIMARY KEY,
                              PAYMENT_ID VARCHAR2(20) NOT NULL,
                              CARD_TYPE VARCHAR2(20),
                              CARD_NO VARCHAR2(16),
                              CARD_HOLDER VARCHAR2(100),
                              APPROVAL_NO VARCHAR2(30),
                              INSTALLMENT_MONTHS NUMBER(2) DEFAULT 0,
                              CREATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP,
                              UPDATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP
);

-- 쿠폰 결제 테이블
CREATE TABLE PAYMENT_COUPON (
                                STTL_NO VARCHAR2(30) PRIMARY KEY,
                                PAYMENT_ID VARCHAR2(20) NOT NULL,
                                COUPON_CODE VARCHAR2(30),
                                COUPON_TYPE VARCHAR2(20),
                                DISCOUNT_AMOUNT NUMBER(15,2),
                                CREATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP,
                                UPDATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP
);

-- 포인트 마스터 테이블
CREATE TABLE POINT_MASTER (
                              POINT_ID VARCHAR2(20) PRIMARY KEY,
                              MBR_ID VARCHAR2(20) NOT NULL,
                              POINT_TYPE VARCHAR2(10) NOT NULL,
                              POINT_AMOUNT NUMBER(10) NOT NULL,
                              PAYMENT_ID VARCHAR2(20),
                              EXPIRE_DATE DATE,
                              STATUS CHAR(1) DEFAULT 'A',
                              DESCRIPTION VARCHAR2(200),
                              CREATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP,
                              UPDATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP
);

-- 회사별 포인트 배정년도 테이블
CREATE TABLE COMPANY_POINT_ALLOCATION (
                                          ALLOCATION_ID VARCHAR2(20) PRIMARY KEY,
                                          CUST_CO_CD VARCHAR2(10) NOT NULL,
                                          ASSN_YR NUMBER(4) NOT NULL,
                                          TOTAL_POINT NUMBER(15) NOT NULL,
                                          REMAINING_POINT NUMBER(15) NOT NULL,
                                          START_DATE DATE,
                                          END_DATE DATE,
                                          STATUS CHAR(1) DEFAULT 'A',
                                          CREATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP,
                                          UPDATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP
);

-- 회원별 포인트 배정 테이블
CREATE TABLE MEMBER_POINT_ALLOCATION (
                                         MBR_POINT_ID VARCHAR2(20) PRIMARY KEY,
                                         ALLOCATION_ID VARCHAR2(20) NOT NULL,
                                         MBR_ID VARCHAR2(20) NOT NULL,
                                         ALLOCATED_POINT NUMBER(10) NOT NULL,
                                         USED_POINT NUMBER(10) DEFAULT 0,
                                         REMAINING_POINT NUMBER(10),
                                         CREATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP,
                                         UPDATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP
);

-- 포인트 사용 이력 테이블
CREATE TABLE POINT_USAGE_HISTORY (
                                     USAGE_ID VARCHAR2(20) PRIMARY KEY,
                                     MBR_POINT_ID VARCHAR2(20) NOT NULL,
                                     PAYMENT_ID VARCHAR2(20),
                                     USAGE_AMOUNT NUMBER(10) NOT NULL,
                                     USAGE_DATE TIMESTAMP DEFAULT SYSTIMESTAMP,
                                     DESCRIPTION VARCHAR2(200),
                                     CREATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP,
                                     UPDATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP
);

-- 환불 테이블
CREATE TABLE REFUND (
                        REFUND_ID VARCHAR2(20) PRIMARY KEY,
                        PAYMENT_ID VARCHAR2(20) NOT NULL,
                        REFUND_DATE TIMESTAMP DEFAULT SYSTIMESTAMP,
                        REFUND_AMOUNT NUMBER(15,2) NOT NULL,
                        REFUND_REASON CLOB,
                        STATUS VARCHAR2(10) DEFAULT 'PENDING',
                        CREATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP,
                        UPDATED_DATE TIMESTAMP DEFAULT SYSTIMESTAMP
);

-- 멘토-멘티 매핑 테이블 생성
CREATE TABLE MEMBER_MENTOR (
                               MENTEE_ID VARCHAR2(20),
                               MENTOR_ID VARCHAR2(20),
                               START_DATE DATE,
                               END_DATE DATE,
                               STATUS CHAR(1) DEFAULT 'A',
                               PRIMARY KEY (MENTEE_ID, MENTOR_ID)
);

-- 실적 기여도 테이블 생성
CREATE TABLE PROJECT_CONTRIBUTION (
                                      PROJECT_ID VARCHAR2(10),
                                      MBR_ID VARCHAR2(20),
                                      CONTRIBUTION_RATE NUMBER(5,2),
                                      ROLE VARCHAR2(50),
                                      PRIMARY KEY (PROJECT_ID, MBR_ID)
);

-- 인덱스 생성
CREATE INDEX IDX_MEMBER_TEAM ON MEMBER(TEAM_ID);
CREATE INDEX IDX_MEMBER_DEPT ON MEMBER(DEPT_ID);
CREATE INDEX IDX_MEMBER_DIV ON MEMBER(DIV_ID);
CREATE INDEX IDX_MEMBER_CUSTCO ON MEMBER(CUST_CO_CD);
CREATE INDEX IDX_TEAM_DEPT ON TEAM(DEPT_ID);
CREATE INDEX IDX_DEPT_DIV ON DEPARTMENT(DIV_ID);
CREATE INDEX IDX_PROJECT_TEAM ON PROJECT(TEAM_ID);
CREATE INDEX IDX_PRODUCT_CATEGORY ON PRODUCT(CATEGORY_ID);
CREATE INDEX IDX_PRODUCT_PROJECT ON PRODUCT(PROJECT_ID);
CREATE INDEX IDX_ORDER_MEMBER ON ORDER_MASTER(MBR_ID);
CREATE INDEX IDX_ORDER_DETAIL_ORDER ON ORDER_DETAIL(ORDER_ID);
CREATE INDEX IDX_ORDER_DETAIL_PRODUCT ON ORDER_DETAIL(PRODUCT_ID);
CREATE INDEX IDX_PAYMENT_ORDER ON PAYMENT(ORDER_ID);
CREATE INDEX IDX_PAYMENT_STTL_NO ON PAYMENT(STTL_NO);
CREATE INDEX IDX_PAYMENT_MEAN_DTL ON PAYMENT(MEAN_DTL_ID);
CREATE INDEX IDX_POINT_MEMBER ON POINT_MASTER(MBR_ID);
CREATE INDEX IDX_POINT_PAYMENT ON POINT_MASTER(PAYMENT_ID);
CREATE INDEX IDX_COMPANY_POINT_CUSTCO ON COMPANY_POINT_ALLOCATION(CUST_CO_CD, ASSN_YR);
CREATE INDEX IDX_MEMBER_POINT_MBR ON MEMBER_POINT_ALLOCATION(MBR_ID);
CREATE INDEX IDX_POINT_USAGE_MBR_POINT ON POINT_USAGE_HISTORY(MBR_POINT_ID);
CREATE INDEX IDX_REFUND_PAYMENT ON REFUND(PAYMENT_ID);

COMMIT;