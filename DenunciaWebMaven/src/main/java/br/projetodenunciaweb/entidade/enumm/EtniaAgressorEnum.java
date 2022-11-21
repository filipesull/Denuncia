
package br.projetodenunciaweb.entidade.enumm;

public enum EtniaAgressorEnum {
	BRANCO("Branco"),NEGRO("Negro"),PARDO("Pardo");
	private String descricao;

	EtniaAgressorEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return this.getDescricao();
	}

	public static EtniaAgressorEnum getEnum(String value) {
		if (value == null)
			throw new IllegalArgumentException();
		for (EtniaAgressorEnum v : values())
			if (value.equalsIgnoreCase(v.getDescricao()))
				return v;
		throw new IllegalArgumentException();
	}

}
