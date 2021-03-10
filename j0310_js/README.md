# 검색 조건(Select Option.ver) / list&read 페이지 21/03/10

Step1. PageDTO 수정
		
		1. type / keyword 선언
		
		2. getArr() 메서드 작성

Step2. 검색 where 조건문 xml 작성
	
		1. <where>문
	
		2. <if>문 null 체크
	
		3. <foreach>
	
		4. <sql>로 따로 빼기
		
		5. <select>문에 <include>

//getList()
Step3. Mapper 인터페이스 파라미터 수정

Step4. Mapper Test

Step5. Service 인터페이스 & ServiceImple 파라미터 수정

Step6. Service Test

//getTotal()
Step7.  xml 수정

Step8. Mapper 인터페이스 파라미터 수정

Step9. Mapper Test

Step10. Service & ServiceImple 파라미터 수정

Step11. Service Test

//list 페이지
Step12. list 페이지에 select Box 추가

		1. div Tag
		
		2. select Tag
		
		3. option Tag
		
		4. input Tag
		
		5. button Tag
		
		6. actionForm
		
Step13. searchBtn으로 actionForm 검색조건 처리

//SelectOne()
Step14. Mapper 인터페이스에 추가

Step15. Mapper xml에 SQL문 추가

Step16. Mapper Test

Step16. Service 인터페이스에 toDTO() 추가

Step17. Service 인터페이스 & ServiceImple에 readOne() 추가

Step18. Service Test

//read 페이지
Step19. 기본 base list 페이지

Step15. 목록가기 / 수정&삭제 하기 버튼 추가

Step16. 목록가기 / 수정&삭제 버튼으로 actionForm 처리

		1. listBtn

		2. modBtn - input Tag(bno)
