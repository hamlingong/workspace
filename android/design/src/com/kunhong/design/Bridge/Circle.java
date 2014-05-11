package com.kunhong.design.Bridge;

public class Circle implements Shape {
	private Drawing drawing;

	public Circle(Drawing drawing) {
		this.drawing = drawing;
	}

	@Override
	public void doDraw() {
		drawing.draw();

	}

}
