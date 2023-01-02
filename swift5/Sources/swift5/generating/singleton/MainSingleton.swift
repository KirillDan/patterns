import Foundation

fileprivate class Singleton {
    private static var instance: Singleton? = nil;
    private let value: Int = Int.random(in: 1..<Int.max)
    private init() {}
    public static func getInstance() -> Singleton {
        if (self.instance == nil) {
            let lock = NSLock()
            lock.lock()
            if (self.instance == nil) {
                self.instance = Singleton()
            }
            lock.unlock()
        }
        return instance!
    }
    public func getValue() -> Int {
        return self.value
    }
}

public class MainSingleton {
    public static func main() {
        let singleton1: Singleton = Singleton.getInstance();
        let singleton2: Singleton = Singleton.getInstance();
        print(singleton1.getValue())
        print(singleton2.getValue())
    }
}