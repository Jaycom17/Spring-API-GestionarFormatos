package edu.co.unicauca.tallerJPA_2.aplicacion.output;

public interface FormateadorResultadosIntPort {
    public void retornarRespuestaErrorEntidadExiste(String mensaje);

    public void retornarRespuestaErrorEntidadNoExiste(String mensaje);

    public void retornarRespuestaErrorReglaDeNegocio(String mensaje);
}
