package SVGoCoffee.SVGoCoffee.exceptions;

import java.time.Instant;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ManipuladorDeExcecoes {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErroResposta> entityNotFound(EntityNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErroResposta erro = new ErroResposta();
        erro.setTimestamp(Instant.now());
        erro.setStatus(status.value());
        erro.setError("Recurso não encontrado");
        erro.setMessage(e.getMessage());
        erro.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(erro);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErroResposta> illegalArgumentException(IllegalArgumentException e,
            HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErroResposta erro = new ErroResposta();
        erro.setTimestamp(Instant.now());
        erro.setStatus(status.value());
        erro.setError("Argumentos Inválidos");
        erro.setMessage(e.getMessage());
        erro.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(erro);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErroResposta> dataIntegrityViolationException(DataIntegrityViolationException e,
            HttpServletRequest request) {
        HttpStatus status = HttpStatus.CONFLICT;
        ErroResposta erro = new ErroResposta();
        erro.setTimestamp(Instant.now());
        erro.setStatus(status.value());
        erro.setError("Conflito de dados");
        erro.setMessage(e.getMessage());
        erro.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(erro);
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<ErroResposta> duplicateKeyException(DuplicateKeyException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.CONFLICT;
        ErroResposta erro = new ErroResposta();
        erro.setTimestamp(Instant.now());
        erro.setStatus(status.value());
        erro.setError("Campo deve ser único");
        erro.setMessage(e.getMessage());
        erro.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(erro);
    }
}