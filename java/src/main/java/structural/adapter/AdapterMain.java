package structural.adapter;

class OldService {
	public String requestOld(String valueOld) {
		return "result with old value = " + valueOld;
	}
}

interface NewService {
	public String requestNew(Integer valueNew);
}

class AdapterFromNewToOld implements NewService {
	private OldService oldService;
	
	public AdapterFromNewToOld(OldService oldService) {
		this.oldService = oldService;
	}

	@Override
	public String requestNew(Integer valueNew) {
		return this.oldService.requestOld(this.convertValueFromNewToOld(valueNew));
	}
	
	private String convertValueFromNewToOld(Integer valueNew) {
		return valueNew.toString();
	}
}

public class AdapterMain {
	public static void main(String[] args) {
		OldService oldService = new OldService();
		AdapterFromNewToOld adapterFromNewToOld = new AdapterFromNewToOld(oldService);
		String result = adapterFromNewToOld.requestNew(11);
		System.out.println(result);
	}
}
