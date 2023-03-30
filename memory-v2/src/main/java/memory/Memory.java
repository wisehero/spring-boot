package memory;

public class Memory {
	private long used;
	private long max;

	public Memory(long used, long max) {
		this.used = used;
		this.max = max;
	}

	public long getUsed() {
		return used;
	}

	public long getMax() {
		return max;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Memory{");
		sb.append("used=").append(used);
		sb.append(", max=").append(max);
		sb.append('}');
		return sb.toString();
	}
}
