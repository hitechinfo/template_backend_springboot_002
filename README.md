# template_backend_springboot_002
Mybatis를 활용하여 REST 기능만 구현한 템플릿 입니다.

### 사전준비
- GIT 설치
- JDK 설치
- Maria DB 설치
- STS 설치
- Restlet Client 설치

### 실행방법
1. Git Bash 실행 후 git clone https://github.com/hitechinfo/template_backend_springboot_002.git
2. STS 실행 후 import > Maven > Existing Maven Projects 선택
3. (DB 설정이 되어 있지 않다면) HeidiSQL 실행 후 .sql 스크립트 실행
4. STS 에서 프로젝트 우클릭 후 Run As > Spring Boot App 선택
5. Restlet 실행 후 GET method로 http://localhost:3005/sample 요청
6. 200 Status와 함께 Sample 목록이 조회되면 성공!
