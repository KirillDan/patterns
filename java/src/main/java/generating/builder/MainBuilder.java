package generating.builder;

class Headphone {
	private String type;
	private String loudspeakerType;
	private String bodyType;
	private String wireType;
	
	public Headphone(String type, String loudspeakerType, String bodyType, String wireType) {
		this.type = type;
		this.loudspeakerType = loudspeakerType;
		this.bodyType = bodyType;
		this.wireType = wireType;
	}
	
	@Override
	public String toString() {
		return "Headphone [type=" + type + ", loudspeakerType=" + loudspeakerType + ", bodyType=" + bodyType
				+ ", wireType=" + wireType + "]";
	}
}

interface HeadphoneParts {
	public HeadphoneParts setType();
	public HeadphoneParts setLoudspeaker(String loudspeakerType);
	public HeadphoneParts setBody(String bodyType);
	public HeadphoneParts setWire(String wireType);
	public Headphone build();
}

class HiFiHeadphoneParts implements HeadphoneParts {
	private String type;
	private String loudspeakerType;
	private String bodyType;
	private String wireType;
	
	@Override
	public HeadphoneParts setType() {
		this.type = "Hi-Fi";
		return this;
	}

	@Override
	public HeadphoneParts setLoudspeaker(String loudspeakerType) {
		this.loudspeakerType = loudspeakerType;
		return this;
	}

	@Override
	public HeadphoneParts setBody(String bodyType) {
		this.bodyType = bodyType;
		return this;
	}

	@Override
	public HeadphoneParts setWire(String wireType) {
		this.wireType = wireType;
		return this;
	}
	
	@Override
	public Headphone build() {
		return new Headphone(type, loudspeakerType, bodyType, wireType);
	}
}

class HiEndHeadphoneParts implements HeadphoneParts {
	private String type;
	private String loudspeakerType;
	private String bodyType;
	private String wireType;
	
	@Override
	public HeadphoneParts setType() {
		this.type = "Hi-End";
		return this;
	}

	@Override
	public HeadphoneParts setLoudspeaker(String loudspeakerType) {
		this.loudspeakerType = loudspeakerType;
		return this;
	}

	@Override
	public HeadphoneParts setBody(String bodyType) {
		this.bodyType = bodyType;
		return this;
	}

	@Override
	public HeadphoneParts setWire(String wireType) {
		this.wireType = wireType;
		return this;
	}
	
	@Override
	public Headphone build() {
		return new Headphone(type, loudspeakerType, bodyType, wireType);
	}
}

class Engineer {
	private HeadphoneParts headphoneParts;

	public Engineer(HeadphoneParts headphoneParts) {
		this.headphoneParts = headphoneParts;
	}
	
	public Headphone buildHeadphone() {
		if (this.headphoneParts instanceof HiFiHeadphoneParts) {
			return this.headphoneParts
					.setType()
					.setLoudspeaker("First class")
					.setBody("First class")
					.setWire("First class")
					.build();
		} else if (this.headphoneParts instanceof HiEndHeadphoneParts) {
			return this.headphoneParts
					.setType()
					.setLoudspeaker("Premium class")
					.setBody("Premium class")
					.setWire("Premium class")
					.build();
		} else {
			return null;
		}
	}
}

public class MainBuilder {
	public static void main(String[] args) {
		Engineer engineer1 = new Engineer(new HiFiHeadphoneParts());
		Headphone hifi = engineer1.buildHeadphone();
		System.out.println(hifi);
		Engineer engineer2 = new Engineer(new HiEndHeadphoneParts());
		Headphone hiend = engineer2.buildHeadphone();
		System.out.println(hiend);
	}
}
