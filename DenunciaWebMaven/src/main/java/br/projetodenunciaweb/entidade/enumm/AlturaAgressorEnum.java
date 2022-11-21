
package br.projetodenunciaweb.entidade.enumm;

public enum AlturaAgressorEnum {
	ALTO("Alto"), MEDIO("Medio"), BAIXO("Baixo");
	private String descricao;

	AlturaAgressorEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return this.getDescricao();
	}

	public static AlturaAgressorEnum getEnum(String value) {
		if (value == null)
			throw new IllegalArgumentException();
		for (AlturaAgressorEnum v : values())
			if (value.equalsIgnoreCase(v.getDescricao()))
				return v;
		throw new IllegalArgumentException();
	}
}
