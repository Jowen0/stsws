# 21/03/19 Board 서비스 개발 - 1

Step1. 3/8(월) Spring 세팅 프로젝트에 board 패키지 구성

	board 패키지 - config, domain, dto, mapper, service, controller
		
Step2. Config/domain/dto 패키지에 Class 생성

	Config - BoardConfig - CommonConfig.class 추가
	domain - Board
	dto	   - BoardDTO
		
Step3. MySQL에 tbl_board 테이블 생성
		
	//컬럼명(타입 - 제약조건 / Default 값)
	컬럼: bno(INT - FK, NN, AI),
		title(VARCHAR(200) - NN),
		content(TEXT - NN),
		writer(VARCHAR(45) - NN),
		regdate(TIMESTAMP -  / now())
		updatedate(TIMESTAMP - / now())

Step4. Toy 데이터 생성

	MySQL문:	insert into tbl_board (title, content, writer)
			values('테스트', '내용 테스트', 'user00');
				
			insert into tbl_board (title, content, writer)
			(select title, content, writer from tbl_board);

Step5. Mapper 인터페이스 생성
		
	List<Board> getList() 추상 메서드 선언 - //@Select 방법도 있지만 XML 방식을 사용하기로 했다.
		
Step6. Mapper XML 파일 생성
	
	<select id="getList" resultType="Board">
		select * from tbl_board order by bno desc
	</select>
		
Step7. Mapper Test

	src/test/java 폴더에 board.mapper 패키지 생성 후 Mapper Test
		
Step8. Service 인터페이스 생성
		
	1. List<BoardDTO> getList() 메서드 선언 - //리턴값을 DTO로 한 이유: VO를 DTO로 바꾸기 위함
		
	2. dto를 vo로 바꾸는 toDomain Default 메서드 생성 - //Default 메서드는 인터페이스에서 일반 메서드처럼 선언 가능하며,
				            	             Override 되지 않는다.
				                          //지금 사용하지는 않지만 나중에 dto를 vo로 바꿀 때 사용예정

Step9. ServiceImple 인터페이스 구현

	1. Mapper DI
		
	2. List<BoardDTO> getList() 메서드 작성

Step10. Service Test

	src/test/java 폴더에 board.service 패키지 생성 후 Service Test
		
Step11. Controller 생성

	1. ServletConfig - BoardController.class 추가

	2. Service 인터페이스 DI
		
	3. public String getList(Model model) 메서드 작성 - //List를 받기 위한 
		
Step12. Controller Test

	src/test/java 폴더에 board.controller 패키지 생성 후 Controller Test
	//MockMVC 사용해서 페이지 이동 & Model 값 Test
		
Step13. list 페이지 생성

	1. 페이지 확인 //h Tag 사용
		
	2. 데이터 확인 //EL 사용
		
Step14. Pagination 처리

	1. common.dto 패키지에 PageDTO 클래스 생성 - PageDTO 초기값 설정 - getPage()메서드 작성
		
	2. BoardMapper.xml - SQL문 수정:
		select * from tbl_board order by bno desc limit #{page}, #{perSheet}
		
	3. Mapper 인터페이스 - getList()에 PageDTO 파라미터 주입
		
	4. Mapper Test
		
	5. Service 인터페이스 - getList()에 PageDTO 파라미터 주입
		
	 
