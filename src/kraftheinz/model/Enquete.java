package kraftheinz.model;

public class Enquete {

	private int id;
	private String estado;
	private String cidade;
	private int freqMercado;
	private String produto;
	private String prodMaisGosta;

	public Enquete(int id, String estado, String cidade, int freqMercado, String produto, String prodMaisGosta) {
		super();
		this.id = id;
		this.estado = estado;
		this.cidade = cidade;
		this.freqMercado = freqMercado;
		this.produto = produto;
		this.prodMaisGosta = prodMaisGosta;
	}
	public Enquete() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public int getFreqMercado() {
		return freqMercado;
	}

	public void setFreqMercado(int freqMercado) {
		this.freqMercado = freqMercado;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getProdMaisGosta() {
		return prodMaisGosta;
	}

	public void setProdMaisGosta(String prodMaisGosta) {
		this.prodMaisGosta = prodMaisGosta;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
