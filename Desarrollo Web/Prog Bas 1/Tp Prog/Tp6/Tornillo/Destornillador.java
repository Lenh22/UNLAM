public class Destornillador {
	private final char TIPO_DE_PUNTA;
	
	public Destornillador(final char tipoDePunta){
	this.TIPO_DE_PUNTA=tipoDePunta;
	}
	public char getTipoDePunta(){
	return this.TIPO_DE_PUNTA;
	}
	public void destornillar (Tornillo tornillo){
	char sentidoDeGiro='A';
	char tipoDeTornillo=tornillo.getTipodeCabeza();
	if (tipoDeTornillo==TIPO_DE_PUNTA){
		tornillo.girar(sentidoDeGiro);
		
		}
	}
	public void atornillar(Tornillo tornillo){
	char sentidoDeGiro='H';
	char tipoDeTornillo=tornillo.getTipodeCabeza();
	if (tipoDeTornillo==TIPO_DE_PUNTA){
		tornillo.girar(sentidoDeGiro);
		}
	}
	
	public void destornillar (Tornillo tornillo, Tarugo tarugo){
	char sentidoDeGiro='A';
	char tipoDeTornillo=tornillo.getTipodeCabeza();
	int longitudTornillo=tornillo.getLongitud();
	int longitudTarugo=tarugo.getLongitud();
	if (tipoDeTornillo==TIPO_DE_PUNTA&&longitudTarugo==longitudTornillo)
	tornillo.girar(sentidoDeGiro);
	
	}
	public void atornillar (Tornillo tornillo, Tarugo tarugo){
	char sentidoDeGiro='H';
	char tipoDeTornillo=tornillo.getTipodeCabeza();
	int longitudTornillo=tornillo.getLongitud();
	int longitudTarugo=tarugo.getLongitud();
	if (tipoDeTornillo==TIPO_DE_PUNTA&&longitudTarugo==longitudTornillo)
	tornillo.girar(sentidoDeGiro);
	
	}
}
