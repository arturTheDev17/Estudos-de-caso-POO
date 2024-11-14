package estudodecaso03;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

/**
 * Essa classe serve verificar os dados de agendamento de uma manutençao.
 * @author Saymon Oliveira de Castro e Artur Neves Höpner
 */

public class Manutencao {
	
	private String operario;
	private String maquina;
	private Operario manutentor;
	private Maquina maquinator;
	
	private Integer id;
	private String data;
	private String hora;
	
	/**
	 *  Essa função serve para verificar se a data existe.
	 * @param data.
	 * @return data.
	 */
	
	public Manutencao ( String nome , String maquina , String data ) {
		setOperario ( nome );
		setMaquina( maquina );
		setData ( data );
	}
	
	public Manutencao ( String nome , String maquina ) {
		setOperario ( nome );
		setMaquina  ( maquina );
	}
	
	public Manutencao () {
		
	}
	
	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}
	
	public Object getMaquina() {
		return maquina;
	}
	
	public void setOperario(String object) {
		this.operario = object;
	}
	
	public Object getOperario() {
		return operario;
	}
	
	public boolean setData ( String data ) { //verifica se a data existe
		/*String dateFormat = "dd/MM/yyyy";

	    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern ( dateFormat ).withResolverStyle ( ResolverStyle.STRICT );
	    try {
	        LocalDate date = LocalDate.parse ( data, dateTimeFormatter );
	        this.data = data;
	        return true;
	    } 
	    
	    catch ( DateTimeParseException e ) {
	    System.out.println ( "Data inválida" );
	        return false;
	   
	     
	        
	    }*/
		if ( data.length() > 0 ) {
			this.data = data;
			return true;
		}
		else return false;
	}
	
	/**
	 * Essa função serve para verificar se a hora é valída.
	 * @param hora.
	 * @return hora.
	 */
	
	public boolean setHora ( String hora ) {
		int contadorNumeros = 0;
		for ( int i = 0 ; i < hora.length() ; i++ ) {
			if ( Character.isDigit ( hora.charAt( i ) ) ) {
				contadorNumeros++;
			}
		}
		if ( hora.charAt ( 2 ) == ':' ) {
			if ( hora.length() == 5 && hora.contains( ":" ) && contadorNumeros == 4 ) {
				
				String[] hm = hora.split(":");
				
				int horass = Integer.parseInt ( hm [0] );
				int minutos = Integer.parseInt ( hm [1] );
				
				if( horass < 24 && horass > 0 && minutos < 60 && minutos > 0 ) {
					this.hora = hora;
					return true;
				
				}
				
				
			} 
		}
		System.out.println ( "Horário inválido" );
		return false;
		
	}
	
	/**
	 * Essa função serve para resgatar a data de agendamento.
	 * @return data.
	 */
	
	public String getData() {
		return data;
		
	}
	
	/**
	 * Essa função serve para resgatar a hora do agendamento.
	 * @return hora.
	 */
	
	public String getHora() {
		return hora;
		
		
		
	}

	/**
	 * Essa função serve para guardar o ID.
	 * @param id.
	 */
	
	public void setId ( Integer id ) {
		this.id = id;
		
		
	}

	/**
	 * Essa função serve para resgatar os dados do operarío.
	 * @return manutentor.
	 */
	
	public Operario getManutentor() {
		return manutentor;
		
		
		
	}
	
	/**
	 * Essa função serve para guardar os dados do usúario.
	 * @param manutentor.
	 */
	
	public void setManutentor(Operario manutentor) {
		this.manutentor = manutentor;
			
	
	}
	
	/**
	 * Essa função serve para guardar a os dados da máquina.
	 * @param maquinator.
	 */
	
	public void setMaquinator(Maquina maquinator) {
		this.maquinator = maquinator;
		
	
	}
	
	/**
	 * Essa função serve para resgatar os dados da máquina.
	 * @return maquinator.
	 */
	
	public Maquina getMaquinator() {
		return maquinator;
		
	}

	public Integer getId () {
		return id;
	
	}
}