
fileprivate protocol Element : Equatable {
    func render() -> String
    func getId() -> Int
}

fileprivate class Text : Element {
    private let id: Int = Int.random(in: 1..<Int.max)
    private var text: String
    init(_ text: String) { 
        self.text = text
    }
    func getId() -> Int {
        return self.id
    }
    public func render() -> String {
        return text
    }
    static func == (lhs: Text, rhs: Text) -> Bool {
        return lhs.id == rhs.id
    }
}

fileprivate class View : Element {
    private let id: Int = Int.random(in: 1..<Int.max)
    private var elements: Array<any Element> = Array()
    public func render() -> String {
        var result = ""
        for element in elements {
            result += "" + element.render() + "\n"
        }
        return result
    }
    func getId() -> Int {
        return self.id
    }
    func add(_ element: any Element) {
        elements.append(element)
    }

    func remove(_ element: any Element) {
        self.elements = elements.filter{$0.getId() != element.getId()}
    }

    public func getChilds() -> Array<any Element> {
		return self.elements;
	}
    static func == (lhs: View, rhs: View) -> Bool {
        return lhs.id == rhs.id
    }
}

class CompositeObjectMain {
    static func main() {
        let text1 = Text("text1")
        let text2 = Text("text2")
        let view = View()
        view.add(text1)
        view.add(text2)
        let view2 = View()
        let text3 = Text("text3")
        view2.add(view)
        view2.add(text3)
        print(view2.render())
    }
}
