package structural.compositeObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

interface Element {
	public String render();
}

class Text implements Element {
	private Integer id = new Random().nextInt();
	private String text;
	
	public Text(String text) {
		this.text = text;
	}

	@Override
	public String render() {
		return this.text;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Text other = (Text) obj;
		return Objects.equals(id, other.id);
	}
}

class View implements Element {
	private Integer id = new Random().nextInt();
	private List<Element> elements = new ArrayList<Element>();
	
	@Override
	public String render() {
		String result = "";
		for (Element element : this.elements) {
			result += element.render() + "\n";
		}
		return result;
	}
	
	public void add(Element element) {
		this.elements.add(element);
	}
	
	public void remove(Element element) {
		this.elements.remove(element);
	}
	
	public List<Element> getChilds() {
		return this.elements;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		View other = (View) obj;
		return Objects.equals(id, other.id);
	}
}

public class CompositeObjectMain {
	public static void main(String[] args) {
		Text text1 = new Text("text1");
		Text text2 = new Text("text2");
		View view = new View();
		view.add(text1);
		view.add(text2);
		View view2 = new View();
		Text text3 = new Text("text3");
		view2.add(view);
		view2.add(text3);
		System.out.println(view2.render());
	}
}
