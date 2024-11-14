package exercicioEncapsulamento;

public class Endereco {
	private String rua;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep; 
	
	public boolean setNumero ( String numero ) {
		for ( int n = 0 ; n < numero.length() ; n++ ) {
			if ( !Character.isDigit ( numero.charAt(n) ) ) {
				System.out.println ( "ERRO. O numero deve ser apenas numeros..." );
				return false;
			}
		}
		this.numero = numero ;
		return true;
	} 
	public String getNumero () {
		return this.numero;
	}
	
	public boolean setRua ( String rua ) {
		if ( rua.isBlank ( ) ) {
			return false;
		}
		this.rua = rua ;
		return true;
	} 
	public String getRua () {
		return this.rua;
	}
	
	public boolean setComplemento ( String complemento ) {
		this.complemento = complemento ;
		return true;
	} 
	public String getComplemento () {
		return this.complemento;
	}
	
	public boolean setBairro ( String bairro ) {
		if ( bairro.isBlank ( ) ) {
			return false;
		}
		this.bairro = bairro ;
		return true;
	} 
	public String getBairro () {
		return this.bairro;
	}
	
	public boolean setCep ( String cep ) {
		if ( cep.isBlank ( ) ) {
			return false;
		}
		this.cep = cep ;
		return true;
	} 
	public String getCep () {
		return this.cep;
	}
}
