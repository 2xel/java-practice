package next.optional;

import java.util.Optional;

public class Computer {
	private Optional<Soundcard> soundcard;

	public Computer(Soundcard soundcard) {
		this.soundcard = Optional.ofNullable(soundcard);
	}
	
	public Optional<Soundcard> getSoundcard() {
		return soundcard;
	}
	
	public static class Soundcard {
		private Optional<USB> usb;

		public Soundcard(USB usb) {
			super();
			this.usb = Optional.ofNullable(usb);
		}
		
		public Optional<USB> getUsb() {
			return usb;
		}
	}

	public static class USB {
		private String version;
		
		public USB(String version) {
			super();
			this.version = version;
		}

		public String getVersion() {
			return this.version;
		}
	}
}
