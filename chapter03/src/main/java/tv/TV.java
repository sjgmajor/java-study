package tv;

public class TV {
	 
	static int MIN_CHANNEL = 1;
	static int MAX_CHANNEL = 255;
	static int MIN_VOLUME = 0;
	static int MAX_VOLUME = 100;
	
	private int channel;//1~255
	private int volume;//1~100
	private boolean power;
	
	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}
	
	public void power(boolean on) {
		this.power = on;
	}

	public void channel(int channel) {
		if(power) {
			this.channel = checkRange(channel, MAX_CHANNEL, MIN_CHANNEL);
		}
		else {
			powerOff();
		}
	}
	
	public void channel(boolean up) {
			channel(channel + (up ? 1 : -1));

	}
	
	public void volume(int volume) {
		if(power) {
			this.volume = checkRange(volume, MAX_VOLUME, MIN_VOLUME);
		}
		else {
			powerOff();
		}

	}

	public void volume(boolean up) {
		volume(volume + (up ? 1 : -1));

	}
	
	public void status() {
		System.out.println("TV[power=" + (power ? "on" : "off") 
				+ " channel=" + channel
				+ " volume=" + volume 
				);
	}
	
	public int checkRange(int compare, int max, int min) {
		
		if(compare > max) {
			compare = min;
		}
		else if(compare < min){
			compare = max;
		}
		return compare;
	}
	
	public void powerOff() {
 		System.out.println("TV가 꺼저 있습니다.");
 	}













}
