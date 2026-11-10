package br.edu.ifpe.oxefood.exception;

public class ClienteException extends RuntimeException {
        public static final String MSG_PREFIXO_TELEFONE = "Não é permitido que sejam inserido cliente com um telefone que não tenha o prefixo 81";

public ClienteException(String msg) {
super(String.format(msg));

}
}
