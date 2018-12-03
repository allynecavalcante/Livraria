import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;



import Test.TestCadastro;

public class CadastroTest {
	
TestCadastro sv;
	
	@Before
	public void setUp() throws Exception {
		sv = new TestCadastro();
	}

	@Test
	public void testValidarUsuarioCorreto() {
		assertEquals(true, sv.validarUsuario("asdf@sdfg.com", "12345678"));
	}

	@Test
	public void testValidarUsuarioSemArroba() {
		assertEquals(false, sv.validarUsuario("asdsdfg.com", "!@#$%¨&*"));
	}
	
	@Test
	public void testValidarUsuarioSemPonto() {
		assertEquals(false, sv.validarUsuario("asdf@sdfgcom", "asdfqwer"));
	}
	
	@Test
	public void testValidarUsuarioVazio() {
		assertEquals(false, sv.validarUsuario("", ""));
	}
	
	@Test
	public void testValidarUsuarioEspaco() {
		assertEquals(false, sv.validarUsuario(" ", " "));
	}
	
	@Test
	public void testValidarUsuarioIformacoesInvertidas() {
		assertEquals(false, sv.validarUsuario("asdf.asd@adf", "12345678"));
	}
}
