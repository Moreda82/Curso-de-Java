package training.lab8.junit;

public class Fruta {
	
	public String modelo;
	public double precioBase;
	public static float impuesto; //porcentaje entre 0 y 100
	
	public Fruta (String modelo, float precioBase) {
		this.modelo = modelo;
		this.precioBase = precioBase;
	}	
	
	//Método para calcular el precio final, el descuento se da si el precio es mayor a 20
	public double precioFinal(double descuento) throws Exception {
		
		double precioConDescuento = this.precioBase;
		
		if (descuento < 0 || descuento > 100) //El descuento esta entre 0 y 100
			
			throw new RuntimeException("Descuento erroneo");
		
		if (precioBase >= 20) { // si es mayor a 20 se calcula el descuento
			
			precioConDescuento = this.precioBase - (this.precioBase * descuento/100f);
			
		}
		
		//Se calcula el precio final
		return precioConDescuento + precioConDescuento * this.impuesto/100f;
	}

}




