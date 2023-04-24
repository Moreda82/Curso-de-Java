package training.lab8.junit;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class CocheTest {
	
	static Coche instance; //Instancia del Objeto Coche
	
	public CocheTest() {
		
	}

	@BeforeAll
	public static void setUpClass() throws Exception {
		
		instance=new Coche ("Audi A3", 10000);
		Coche.impuesto=20f;
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
		
		System.out.println("precioFinal_coche con descuento");
		float descuento= 10.0F; //valor del descuento
		float expResult = 10800; //precio final
		float result = instance.precioFinal(descuento); //pasa el valor del descuento para calcular al método
		
		assertEquals(expResult, result); //El metodo assertEquals compara si dos objetos 
		//son iguales, utiliza el metodo equals().
		
	}
	
	@Test
	//Aqui calcula el precio final si el precio del auto es menor a 5000
	public void PrecioFinal_2() throws Exception{
		
		System.out.println("precioFinal_coche barato sin descuento");
		
		float descuento = 10.0F; //valor del descuento
		instance.precioBase=1000f; //precio base
		float expResult = 1200; //precio final
		float result= instance.precioFinal (descuento); //pasa el valor del descuento
		
		assertEquals (expResult, result); //devuelve el resultado
	}	
		@Test
		//Aqui muestra el mensaje si el valor del descuento es mayor a 100
		public void PrecioFinal_3() throws Exception{
			
		System.out.println("precioFinal_coche con descuento incorrecto");
		
		//asserThrows lanza el error(mensaje: Descuento incorrecto"		
		assertThrows(Exception.class, new Executable() {
			float descuento=110.0f; // valor del descuento
			
			@Override
			public void execute() throws Throwable{
				float result = instance.precioFinal(descuento);
			}});
			}
	}
	


