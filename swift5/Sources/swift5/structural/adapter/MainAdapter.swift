
fileprivate class OldService {
	public func requestOld(_ valueOld: String) -> String {
		return "result with old value = " + valueOld;
	}
}

fileprivate protocol NewService {
	func requestNew(_ valueNew: Int) -> String;
}

fileprivate class AdapterFromNewToOld : NewService {
	private var oldService: OldService;
	
	public init(_ oldService: OldService) {
		self.oldService = oldService;
	}

	public func requestNew(_ valueNew: Int) -> String {
		return self.oldService.requestOld(self.convertValueFromNewToOld(valueNew));
	}
	
	private func convertValueFromNewToOld(_ valueNew: Int) -> String {
		return String(valueNew);
	}
}

public class AdapterMain {
	public static func main() {
		let oldService = OldService();
		let adapterFromNewToOld = AdapterFromNewToOld(oldService);
		let result = adapterFromNewToOld.requestNew(11);
		print(result);
	}
}