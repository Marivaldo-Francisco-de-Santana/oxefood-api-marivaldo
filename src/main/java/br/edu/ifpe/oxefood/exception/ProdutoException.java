package br.edu.ifpe.oxefood.exception;

public class ProdutoException extends RuntimeException {

    public static final String MSG_VALOR_MINIMO_PRODUTO = "Não é permitido inserir produtos com valores inferiores a R$ 20 e maior que 100";

public ProdutoException(String msg) {
super(String.format(msg));

}
}