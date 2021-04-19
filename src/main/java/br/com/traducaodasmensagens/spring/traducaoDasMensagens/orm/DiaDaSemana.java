package br.com.traducaodasmensagens.spring.traducaoDasMensagens.orm;

public enum DiaDaSemana {
	DOMINGO, SEGUNDA, TERÇA, QUARTA, QUINTA, SEXTA, SÁBADO;
	
	@Override
    public String toString() {
        return Character.toUpperCase(name().charAt(0)) + name().toLowerCase().substring(1);
    }
}
