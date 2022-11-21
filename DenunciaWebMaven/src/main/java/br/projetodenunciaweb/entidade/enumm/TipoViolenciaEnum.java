package br.projetodenunciaweb.entidade.enumm;

public enum TipoViolenciaEnum {
	DOMESTICA("Domestica"), SEXUAL("Sexual"), FISICA("Fisica"), MORAL("Moral"), PATRIMONIAL("Patrimonial"), PSICOLOGICA("Psicologica");
	
	private String descricao;

	TipoViolenciaEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return this.getDescricao();
	}

	public static TipoViolenciaEnum getEnum(String value) {
		if (value == null)
			throw new IllegalArgumentException();
		for (TipoViolenciaEnum v : values())
			if (value.equalsIgnoreCase(v.getDescricao()))
				return v;
		throw new IllegalArgumentException();
	}
}
