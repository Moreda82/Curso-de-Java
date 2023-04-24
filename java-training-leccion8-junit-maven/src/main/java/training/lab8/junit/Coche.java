package training.lab8.junit;

public class Coche {
	
	public String modelo;
	public float precioBase;
	public static float impuesto; //porcentaje entre 0 y 100
	
	public Coche (String modelo, float precioBase) {
		this.modelo = modelo;
		this.precioBase = precioBase;
	}	
	
	//Método para calcular el precio final, el descuento se da si el precio es mayor a 5000
	public float precioFinal(float descuento) throws Exception {
		
		float precioConDescuento = this.precioBase;
		
		if (descuento < 0 || descuento > 100) //El descuento esta entre 0 y 100
			
			throw new RuntimeException("Descuento erroneo");
		
		if (precioBase >= 5000) { // si es mayor a 5000 se calcula el descuento
			
			precioConDescuento = this.precioBase - (this.precioBase * descuento/100f);
			
		}
		
		//Se calcula el precio final
		return precioConDescuento + precioConDescuento * this.impuesto/100f;
	}

}


