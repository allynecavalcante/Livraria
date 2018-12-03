import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class LoginTest {

LoginTest cs;
	
	@Before
	public void setUp() throws Exception {
		cs = new LoginTest();
	}

	@Test
	public void testValidarFotografoCorreto() {
		Assert.assertEquals(true, cs.validarCliente("João", "Silva"));
	}
	

	private Object validarCliente(String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	public void testValidarFotografoMinusculo() {
		Assert.assertEquals(false, cs.validarCliente("joão", "silva"));
	}
	
	@Test
	public void testValidarFotografoEmBranco() {
		Assert.assertEquals(false, cs.validarCliente("", ""));
	}
	
	@Test
	public void testValidarFotografoComEspaco() {
		Assert.assertEquals(false, cs.validarCliente(" ", " "));
	}
}
