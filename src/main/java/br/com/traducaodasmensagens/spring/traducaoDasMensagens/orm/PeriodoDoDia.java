package br.com.traducaodasmensagens.spring.traducaoDasMensagens.orm;

public enum PeriodoDoDia {
	MANHÃ, TARDE, NOITE;
	
	@Override
    public String toString() {
        return Character.toUpperCase(name().charAt(0)) + name().toLowerCase().substring(1);
    }
}
