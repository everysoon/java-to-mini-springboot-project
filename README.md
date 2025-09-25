# 자바로 구현하는 스프링부트 개념

#### 설명
스프링 부트에서 제공하는 기능들을(목차 참고) 순수 자바 프로젝트로 시작하여
gradle 설정부터 기능 구현까지 직접 해보려합니다.

## 구현 목차
1. 애플리케이션 부트 스트랩
2. 의존성 주입 (DI) & IoC 컨테이너
3. 설정/환경 관리
4. 웹 서버 (Tomcat 대체)
5. 요청 / 응답 처리
6. AOP
7. 데이터 접근(JPA)
8. 트랜잭션 관리
   9.예외 처리 및 글로벌 핸들러
10. 스케줄링 & 비동기
11. 보안 (Spring Security)
12. 테스트 지원


### 1. 애플리케이션 부트 스트랩
#### 목표  :  `public static void main`으로 애플리케이션 실행
1) ApplicationContext 직접 구현 -> 객체 생성 및 의존성 주입
2) 설정 클래스 (`@Configuration`) 흉내내기
3) Bean 등록/조회 가능 (`@Bean`)

### 2. 의존성 주입 (DI) & Ioc 컨테이너
#### 목표 : `@Autowired`, `@ComponentScan` 직접 구현
1) 리플랙션으로 @Component 스캔
2) 인스턴스 생성 후 싱글톤 컨테이너에 보관
3) 생성자 주입/필드 주입 지원

### 3. 설정 / 환경 관리
#### 목표 : `.properties` / `.yml` 파서 구현으로 `@Value` 어노테이션 구현
1) 공통 인터페이스를 통한 (`PropertiesSource.java`) .properties / .yml 파서 구현 (`PropertiesParser.java`,`YmlParser.java`)
2) @Value("${...}") 흉내내서 값 주입
3) ValueInjector 구현 (환경 파일을 읽어 @Value 어노테이션에 있는 값을 필드에 주입)

- ymlParser를 구현할때 gradle init을 통해 gradle 설정 
- gradle 설정하며 gitignore 설정
- 패키지를 사용하지 않고 src/Main.java를 기본으로 설정

### 4. 웹서버 (Tomcat 대체)
#### 