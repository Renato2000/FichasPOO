public class Triangulo{
	private Ponto p1, p2, p3;

	public Triangulo(){
		this.p1 = new Ponto(0, 0);
		this.p2 = new Ponto(0, 0);
		this.p3 = new Ponto(0, 0);
	}

	public Triangulo(Ponto cp1, Ponto cp2, Ponto cp3){
		this.p1 = cp1.clone();
		this.p2 = cp2.clone();
		this.p3 = cp3.clone();
	}

	public Triangulo(Triangulo t){
		this.p1 = t.getP1();
		this.p2 = t.getP2();
		this.p3 = t.getP3();
	}

	public void setP1(Ponto p){
		this.p1 = p.clone();
	}

	public void setP2(Ponto p){
		this.p2 = p.clone();
	}

	public void setP3(Ponto p){
		this.p3 = p.clone();
	}

	public Ponto getP1(){
		return (this.p1.clone());
	}

	public Ponto getP2(){
		return (this.p2.clone());
	}

	public Ponto getP3(){
		return (this.p3.clone());
	}

	public Triangulo clone(){
		return new Triangulo(this);
	}

	public boolean equals(Triangulo t){
		return(this.p1.distancia(this.p2) == t.getP1().distancia(t.getP2())
			&& this.p2.distancia(this.p3) == t.getP2().distancia(t.getP3())
			&& this.p3.distancia(this.p1) == t.getP3().distancia(t.getP1())); 
	}

	public double area(){
		double area;
		double p = this.perimetro() / 2;
		double l1 = this.p1.distancia(this.p2);
		double l2 = this.p2.distancia(this.p3);
		double l3 = this.p3.distancia(this.p1);
		area = Math.sqrt(p * (p - l1) * (p - l2) * (p - l3));
		return area;
	}

	public double perimetro(){
		double l1, l2, l3;
		l1 = this.p1.distancia(this.p2);
		l2 = this.p2.distancia(this.p3);
		l3 = this.p3.distancia(this.p1);
		return (l1 + l2 + l3);
	}

	private Ponto menorCordenada(){
		if(this.p1.getY() < this.p2.getY() && this.p1.getY() < this.p3.getY())
			return this.p1;
		else{
			if(this.p2.getY() < this.p1.getY() && this.p2.getY() < this.p3.getY())
				return this.p2;
			else return this.p3;
		}
	}

	private Ponto maiorCoordenada(){
		if(this.p1.getY() > this.p2.getY() && this.p1.getY() > this.p3.getY())
			return this.p1;
		else{
			if(this.p2.getY() > this.p1.getY() && this.p2.getY() > this.p3.getY())
				return this.p2;
			else return this.p3;
		}
	}

	public double altura(){
		Ponto p1, p2;
		p1 = this.menorCordenada();
		p2 = this.maiorCoordenada();
		return (p1.distancia(p2));
	}
}