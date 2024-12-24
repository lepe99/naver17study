package day1223;
// jdk8에서 추가된 기능. 디폴트 인스턴스 메서드를 통해서 인터페이스 내 메서드에 기능 구현이 가능하다

interface RemoteControl {
	// 상수 선언
	int MAX_VOL = 10;
	int MIN_VOL = 0;
	
	//추상 메서드
	public void turnOn();
	public void turnOff();
	public void setVol(int vol);
	
	//디폴트 인스턴스 메서드 사용하여 기능 구현
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음 처리합니다");
			setVol(MIN_VOL);
		} else {
			System.out.println("무음 해제합니다");
		}
	}
}


class Television implements RemoteControl {
	int vol;
	
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다");
	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다");
	}

	@Override
	public void setVol(int vol) {
		this.vol = vol;
		System.out.println("볼륨 설정 : " + this.vol);
		
	}
	
}


public class Ex5DefaultInterface {

	public static void main(String[] args) {
//		RemoteControl rc1 = null; // new 로 생성 못함 (인터페이스)
//		rc1.setMute(false); // NullPointerException 발생
		
		RemoteControl tv = new Television();
		tv.turnOn();
		tv.turnOff();
		tv.setMute(true); // 인터페이스에서 구현된 메서드는 이를 구현한 클래스를 통해서만 호출 가능하다
		tv.setMute(false);


	}

}
