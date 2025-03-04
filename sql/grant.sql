-- venepiano 사용자 생성 (비밀번호는 'password'로 설정 - 필요에 맞게 변경하세요)
CREATE USER venepiano IDENTIFIED BY oracle;

-- 해당 사용자에게 로그인 권한 부여
GRANT CREATE SESSION TO venepiano;

-- 테이블스페이스 사용 권한 부여
GRANT UNLIMITED TABLESPACE TO venepiano;

-- 테이블 생성 권한 부여
GRANT CREATE TABLE TO venepiano;

-- 필요한 경우 프로시저 생성 권한 부여
GRANT CREATE PROCEDURE TO venepiano;

-- 필요한 경우 시퀀스 생성 권한 부여
GRANT CREATE SEQUENCE TO venepiano;

-- 필요한 경우 뷰 생성 권한 부여
GRANT CREATE VIEW TO venepiano;

---------------------------

-- 테이블스페이스 쿼터 설정 (필요한 경우)
ALTER USER venepiano QUOTA UNLIMITED ON USERS;  -- 또는 다른 테이블스페이스 이름

-- 리소스 권한 부여 (테이블, 시퀀스, 프로시저 등을 생성할 수 있는 권한 묶음)
GRANT RESOURCE TO venepiano;

-- 필요한 경우 DBA 권한 부여 (개발 환경에서만 권장)
-- GRANT DBA TO venepiano;  -- 주의: 실제 운영 환경에서는 보안상 권장하지 않음

---------------------------

--
-- 테이블스페이스 쿼터 설정 (필요한 경우)
ALTER USER venepiano QUOTA UNLIMITED ON USERS;  -- 또는 다른 테이블스페이스 이름

-- 리소스 권한 부여 (테이블, 시퀀스, 프로시저 등을 생성할 수 있는 권한 묶음)
GRANT RESOURCE TO venepiano;

-- 필요한 경우 DBA 권한 부여 (개발 환경에서만 권장)
-- GRANT DBA TO venepiano;  -- 주의: 실제 운영 환경에서는 보안상 권장하지 않음

GRANT SELECT ANY DICTIONARY TO venepiano;
GRANT SELECT ANY TABLE TO venepiano;
GRANT SELECT_CATALOG_ROLE TO venepiano;

-- 시스템 뷰 조회 권한
GRANT SELECT ON SYS.ALL_VIEWS TO venepiano;
GRANT SELECT ON SYS.DBA_VIEWS TO venepiano;
GRANT SELECT ON SYS.USER_VIEWS TO venepiano;

-- 기타 메타데이터 조회 권한
GRANT SELECT ON SYS.ALL_TAB_COLUMNS TO venepiano;
GRANT SELECT ON SYS.ALL_TABLES TO venepiano;