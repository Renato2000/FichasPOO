import java.lang.Math;

public class Circulo{
	private double x, y, raio;

	public Circulo(){
		this.x = 0.0;
		this.y = 0.0;
		this.raio = 1.0;
	}

	public Circulo(double cx, double cy, double craio){
		this.x = cx;
		this.y = cy;
		this.raio = craio;
	}

	public Circulo(Circulo cCirculo){
		this.x = cCirculo.getX();
		this.y = cCirculo.getY();
		this.raio = cCirculo.getRaio();
	}	

	public double getX(){
		return this.x;
	}

	public double getY(){
		return this.y;
	}

	public double getRaio(){
		return this.raio;
	}

	public void setX(double cx){
		this.x = cx;
	}

	public void setY(double cy){
		this.y = cy;
	}

	public void setRaio(double craio){
		this.raio = craio;
	}		

	public Circulo clone(){
		return new Circulo(this);
	}

	public boolean equals(Circulo c){
		return(this.x == c.getX() && this.y == c.getY() && this.raio == c.getRaio());
	}

	public String toString(){
		return("Circulo com centro em (" + this.x + "," + this.y + ") e raio " + this.raio);
	} 

	public void alteraCentro(double cx, double cy){
		this.x = cx;
		this.y = cy;
	}

	public double calculaArea(){
		return (Math.PI * Math.sqrt(this.raio));
	}

	public double calculaPerimetro(){
		return (2 * Math.PI * this.raio);
	}
}