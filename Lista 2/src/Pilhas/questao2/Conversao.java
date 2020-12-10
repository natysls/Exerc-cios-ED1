package Pilhas.questao2;

import Pilhas.questao1.Pilha;

public class Conversao extends Pilha{
	int potencia = 0;
	int decimal = 0;

	public void conversao(String base, Pilha pilha) {
		Object[] elementosNovos = new Object[getElementos().length];
		
		if(base.equalsIgnoreCase("binario")) {
			for(int i = pilha.getElementos().length - 1; i>=0; i--) {
				for(int j=0; j<pilha.getElementos().length; j++) {
					decimal += Math.pow(2, potencia) * Character.getNumericValue(i);
					pilha.getElementos()[j] = decimal;
					elementosNovos[j] = pilha.getElementos()[j];
				}
				//pilha.getElementos() = elementosNovos; //não da certo isso
				potencia++;
			}
			pilha.getElementos().equals(elementosNovos);
		}
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[");
		
		for(int i=0; i<getTamanho()-1;i++) {
			s.append(getElementos()[i]);
			s.append(", ");
		}
		if(getTamanho() > 0) {
			s.append(getElementos()[getTamanho() -1]);
		}
		
		s.append("]");
		
		return s.toString();
	}
	
}
