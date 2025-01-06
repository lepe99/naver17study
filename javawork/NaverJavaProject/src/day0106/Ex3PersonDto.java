package day0106;
/*
Mysql 의 personb table 관리 프로그램 만들기

파일명:
    Ex3PersonTable
    PersonModel
    PersonDto

아까와 같은 구조로
    처음 시작시 table 에 person 데이타 출력
     (출력컬럼: num,name,age,hp,blood)


    상단에 이름,나이,혈액형,핸드폰 입력하고
    [직원추가] 버튼 클릭시 db 에 추가후 다시 전체 출력하기

    테이블의 데이타 클릭후 [직원삭제] 버튼 클릭시
    db 에서 해당직원 삭제후 다시 전체 출력하기기
 */
public class Ex3PersonDto {
    private int num;
    private String name;
    private String blood;
    private int age;
    private String hp;

    public Ex3PersonDto() {
    }

    public Ex3PersonDto(String name, String blood, int age, String hp) {
        this.name = name;
        this.blood = blood;
        this.age = age;
        this.hp = hp;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }
}
