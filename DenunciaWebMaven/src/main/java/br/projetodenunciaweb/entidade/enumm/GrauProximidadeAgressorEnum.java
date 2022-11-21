package br.projetodenunciaweb.entidade.enumm;

public enum GrauProximidadeAgressorEnum {
	DESCONHECIDO("Desconhecido"), PARENTE("Parente"), AMIGO("Amigo"), CONJUGE("Conjuge");
	
	private String descricao;

	GrauProximidadeAgressorEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return this.getDescricao();
	}

	public static GrauProximidadeAgressorEnum getEnum(String value) {
		if (value == null)
			throw new IllegalArgumentException();
		for (GrauProximidadeAgressorEnum v : values())
			if (value.equalsIgnoreCase(v.getDescricao()))
				return v;
		throw new IllegalArgumentException();
	}
}
