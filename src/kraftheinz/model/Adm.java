package kraftheinz.model;

public class Adm {

	private int idAdm;
	private String codigoAdm;
	private int senhaAdm;

	public Adm(int idAdm, String codigoAdm, int senhaAdm) {
		super();
		this.idAdm = idAdm;
		this.codigoAdm = codigoAdm;
		this.senhaAdm = senhaAdm;
	}

	public Adm() {

	}

	public int getIdAdm() {
		return idAdm;
	}

	public void setIdAdm(int idAdm) {
		this.idAdm = idAdm;
	}

	public String getCodigoAdm() {
		return codigoAdm;
	}

	public void setCodigoAdm(String codigoAdm) {
		this.codigoAdm = codigoAdm;
	}

	public int getSenhaAdm() {
		return senhaAdm;
	}

	public void setSenhaAdm(int senhaAdm) {
		this.senhaAdm = senhaAdm;
	}

}
