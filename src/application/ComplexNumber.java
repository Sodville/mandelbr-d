package application;

public class ComplexNumber {
	private double re;
	private double im;
	
	public ComplexNumber(double a, double b) {
		re = a;
		im = b;
	}
	
	public ComplexNumber add(double a, double b) {
		return new ComplexNumber(re + a, im + b);
	}
	
	public ComplexNumber add(ComplexNumber c) {
		return this.add(c.getRe(), c.getIm());
	}
	
	public ComplexNumber prod(double a, double b) {
		return new ComplexNumber(re*a - im*b, im*a + re*b);
	}
	
	public ComplexNumber prod(ComplexNumber c) {
		return this.prod(c.getRe(), c.getIm());
	}
	
	public ComplexNumber sqr() {
		return this.prod(re, im);
	}
	
	public double abs() {
		return Math.sqrt(Math.pow(re, 2) + Math.pow(im, 2));
	}
	
	public double getRe() {
		return re;
	}
	
	public double getIm() {
		return im;
	}
}
