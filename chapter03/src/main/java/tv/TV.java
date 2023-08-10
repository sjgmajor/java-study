package tv;

public class TV {
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

	public void channel(boolean up) {
	}

	public void channel(int channel) {
		this.channel = channel;
	}
	
	public void volume(int volume) {
		this.volume = volume;
	}

	public void volume(boolean b) {
	}
	
	public void status() {
		System.out.println("TV[power=" + (power ? "on" : "off") 
				+ "channel=" + channel
				+ "volume=" + volume 
				);
	}
	













}
