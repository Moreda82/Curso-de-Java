package training.lab8.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class FrutaTest {

static Fruta instance; //Instancia del Objeto Fruta
	
	public FrutaTest() {
		
	}

	@BeforeAll
	public static void setUpClass() throws Exception {
		
		instance=new Fruta ("Naranja", 22);
		Fruta.impuesto=21f;
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("-------------Comienzo del test-----------");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Hora:"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS")));
	}

	@Test
	public void PrecioFinal_1() throws Exception {
		
		System.out.println("precioFinal_Fruta con descuento");
		float descuento= 20.0F; //valor del descuento
		double expResult = 21.296; //precio final
		double result = instance.precioFinal(descuento); //pasa el valor del descuento para calcular al método
		
		assertEquals(expResult, result, 0.00001); //El metodo assertEquals compara si dos objetos 
		//son iguales, utiliza el metodo equals().
		
	}
	
	@Test
	//Aqui calcula el precio final si el precio de la fruta es menor a 20
	public void PrecioFinal_2() throws Exception{
		
		System.out.println("precioFinal_Fruta no llega para aplicar descuento");
		
		float descuento = 10.0F; //valor del descuento
		instance.precioBase=18f; //precio base
		double expResult = 21.78; //precio final
		double result= instance.precioFinal (descuento); //pasa el valor del descuento
		
		assertEquals (expResult, result,0.00001); //devuelve el resultado
	}	
		@Test
		//Aqui muestra el mensaje si el valor del descuento es mayor a 100
		public void PrecioFinal_3() throws Exception{
			
		System.out.println("precioFinal_Fruta con descuento incorrecto al ser mayor que 100");
		
		//asserThrows lanza el error(mensaje: Descuento incorrecto"		
		assertThrows(Exception.class, new Executable() {
			float descuento=110.0f; // valor del descuento
			
			@Override
			public void execute() throws Throwable{
				double result = instance.precioFinal(descuento);
			}});
			}
	}
	