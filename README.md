## 📘웹 쇼핑몰 장바구니 프로젝트
SuperCoding 부트캠프 Back-End 개발자 과정에서 진행한 프로젝트 주차 대비를 위한 1:1 프로젝트 입니다.

## 📖 프로젝트 개요
Java, SpringBoot, JPA 기술을 학습하기 위한 학습용 1인 프로젝트입니다. 

웹 쇼핑몰 장바구니의 정렬, 필터링 기능을 핵심적으로 구현하였습니다.

## 🖥️ 개발환경
* __IDE__ : Intellij IDE
* __Language__ : Java17
* __Framework__ : SpringBoot ver 3.3.3
* __DB__ : H2 Database
* __Version Control__ : Github
* __WAS__ : Tomcat
* __API Test__ : postman
  
## ⚙️ 기술
Spring Web, Spring Data JPA, Lombok, MapStruct 

## 📖 주요 기능
* 장바구니에 상품 담기
* 장바구니 조회
  * 장바구니 안의 상품들을 기준에 따라 정렬한 후 조회할 수 있습니다.
  * 장바구니 안의 상품들을 이름으로 검색할 수 있습니다.
  * 장바구니 안의 상품들을 원하는 카테고리에 따라 조회할 수 있습니다.
  * ...

## 📖 프로젝트 구성 : 다이어그램
* __개체 관계도__
<img width="418" alt="image" src="https://github.com/user-attachments/assets/b678fe3b-db92-43de-b7aa-abbe5f961b34">

* __엔티티 관계도__
<img width="523" alt="image" src="https://github.com/user-attachments/assets/0f732f22-8e27-48da-9aa6-fc0307955435">

* __ERD__

## 📖 프로젝트 구성 : API
* 사용자 등록 : [POST] http://localhost:8080/user/signup
* 사용자 전체 조회 : [GET] http://localhost:8080/user/view/all
* ...

