package REGEX;

public class ValidaCampos {

    public static boolean validaNome(String nome) {
        return nome.matches("\\p{Upper}[\\p{IsLatin}[ ]]+");
    }

    public static boolean validaEndereco(String endereco) {
        return endereco.matches("\\p{Upper}[\\p{IsLatin}\\p{Alnum}[ ][,-]]+");
    }

    public static boolean validaEmail(String email) {
        return email.matches("([\\p{Alnum}\\._-])+@([\\p{Alnum}])+(\\.([\\p{Alnum}])+)*");
    }

    public static boolean validaFone(String fone) {
        return fone.matches("\\(\\p{Digit}{2}\\)\\p{Digit}{4,5}-\\p{Digit}{4}");
    }
    
    public static boolean validaCPF(String cpf) {
        return cpf.matches("[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}\\-?[0-9]{2}");
    }
     public static boolean validaCargo(String cargo) {
        return cargo.matches("\\p{Upper}[\\p{IsLatin}\\p{Alnum}[ ][,-]]+");
    }
    
}
