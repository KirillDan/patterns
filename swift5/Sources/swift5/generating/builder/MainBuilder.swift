
fileprivate class Headphone : CustomStringConvertible {
    private let type: String
    private let loudspeakerType: String
    private let bodyType: String
    private let wireType: String

    init(type: String, loudspeakerType: String, bodyType: String, wireType: String) {
        self.type = type
        self.loudspeakerType = loudspeakerType
        self.bodyType = bodyType
        self.wireType = wireType
    }

    var description: String {
        return ("Headphone [type=" + type + ", loudspeakerType=" + loudspeakerType + ", bodyType=" + bodyType
                + ", wireType=" + wireType + "]")
    }
}

fileprivate protocol HeadphoneParts {
    func setType() -> HeadphoneParts
    func setLoudspeaker(_ loudspeakerType: String) -> HeadphoneParts
    func setBody(_ bodyType: String) -> HeadphoneParts
    func setWire(_ wireType: String) -> HeadphoneParts
    func build() -> Headphone
}

fileprivate class HiFiHeadphoneParts : HeadphoneParts {
    private var type: String?
    private var loudspeakerType: String?
    private var bodyType: String?
    private var wireType: String?

    func setType() -> HeadphoneParts {
        self.type = "Hi-Fi"
        return self
    }

    func setLoudspeaker(_ loudspeakerType: String) -> HeadphoneParts {
        self.loudspeakerType = loudspeakerType
        return self
    }

    func setBody(_ bodyType: String) -> HeadphoneParts {
        self.bodyType = bodyType
        return self
    }

    func setWire(_ wireType: String) -> HeadphoneParts {
        self.wireType = wireType
        return self
    }

    func build() -> Headphone {
        return Headphone(type: self.type!, loudspeakerType: self.loudspeakerType!, bodyType: self.bodyType!, wireType: self.wireType!)
    }
}

fileprivate class HiEndHeadphoneParts : HeadphoneParts {
    private var type: String?
    private var loudspeakerType: String?
    private var bodyType: String?
    private var wireType: String?

    func setType() -> HeadphoneParts {
        self.type = "Hi-End"
        return self
    }

    func setLoudspeaker(_ loudspeakerType: String) -> HeadphoneParts {
        self.loudspeakerType = loudspeakerType
        return self
    }

    func setBody(_ bodyType: String) -> HeadphoneParts {
        self.bodyType = bodyType
        return self
    }

    func setWire(_ wireType: String) -> HeadphoneParts {
        self.wireType = wireType
        return self
    }

    func build() -> Headphone {
        return Headphone(type: self.type!, loudspeakerType: self.loudspeakerType!, bodyType: self.bodyType!, wireType: self.wireType!)
    }
}

fileprivate class Engineer {
	private var headphoneParts: HeadphoneParts?;

	public init(headphoneParts: HeadphoneParts) {
		self.headphoneParts = headphoneParts;
	}
	
	public func buildHeadphone() -> Headphone? {
		if (self.headphoneParts is HiFiHeadphoneParts) {
			return self.headphoneParts!
					.setType()
					.setLoudspeaker("First class")
					.setBody("First class")
					.setWire("First class")
					.build();
		} else if (self.headphoneParts is HiEndHeadphoneParts) {
			return self.headphoneParts!
					.setType()
					.setLoudspeaker("Premium class")
					.setBody("Premium class")
					.setWire("Premium class")
					.build();
		} else {
			return nil;
		}
	}
}

public class MainBuilder {
	public static func main() {
		let engineer1: Engineer = Engineer(headphoneParts: HiFiHeadphoneParts());
		let hifi = engineer1.buildHeadphone()!;
		print(hifi);
		let engineer2: Engineer = Engineer(headphoneParts: HiEndHeadphoneParts());
		let hiend = engineer2.buildHeadphone()!;
		print(hiend);
	}
}
