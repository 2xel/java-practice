package next.optional;

import next.optional.Computer.Soundcard;
import next.optional.Computer.USB;

import java.util.Optional;

public class ComputerStore {
	public static final String UNKNOWN_VERSION = "UNKNOWN";
	
	public static String getVersion(Computer computer) {
		return getVersionOptional(computer)
				.flatMap(Computer::getSoundcard)
				.flatMap(Soundcard::getUsb)
				.map(USB::getVersion)
				.orElse(UNKNOWN_VERSION);
	}
	
	public static Optional<Computer> getVersionOptional(Computer computer) {
		return Optional.ofNullable(computer);
	}
}
