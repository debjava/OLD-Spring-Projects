package strategy;

import model.Document;

import org.springframework.stereotype.Component;

@Component("A5Portrait")
public class PrintA5PortraitStrategy implements IPrintStrategy{

	@Override
	public void print(Document document) {
		System.out.println("Doing stuff to print an A5 portrait document");
	}

}
