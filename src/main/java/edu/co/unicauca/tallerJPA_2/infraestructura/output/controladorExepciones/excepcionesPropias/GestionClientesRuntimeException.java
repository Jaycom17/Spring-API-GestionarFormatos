package edu.co.unicauca.tallerJPA_2.infraestructura.output.controladorExepciones.excepcionesPropias;

import edu.co.unicauca.tallerJPA_2.infraestructura.output.controladorExepciones.estructuraExcepciones.CodigoError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public abstract class GestionClientesRuntimeException extends RuntimeException {

  protected CodigoError codigoError;

  public abstract String formatException();
}

