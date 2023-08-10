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
			this.channel = checkChannel(channel);
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
			this.volume = checkVolume(volume);
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
	
	public int checkChannel(int channel) {
		
		if(channel > MAX_CHANNEL) {
			channel = channel - MAX_CHANNEL + MIN_CHANNEL - 1;
		}
		else if(channel < MIN_CHANNEL){
			channel = MAX_CHANNEL + channel + MIN_CHANNEL - 1;
		}
		return channel;
	}

	public int checkVolume(int volume) {		

		if(volume > MAX_VOLUME) {
			volume = MAX_VOLUME;
		}
		else if(volume < MIN_VOLUME){
			volume = MIN_VOLUME;
		}
		return volume;
	}
	
	public void powerOff() {
 		System.out.println("TV가 꺼저 있습니다.");
 	}













}
