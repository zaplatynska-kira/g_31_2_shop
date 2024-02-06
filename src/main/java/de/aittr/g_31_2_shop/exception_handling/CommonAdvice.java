package de.aittr.g_31_2_shop.exception_handling;

import de.aittr.g_31_2_shop.exception_handling.exceptions.FourTestException;
import de.aittr.g_31_2_shop.exception_handling.exceptions.ProductValidationException;
import de.aittr.g_31_2_shop.exception_handling.exceptions.ThirdTestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
// 3способ ошибок ловит любые исключения по всему проекту

// глобальный обработчик исключений controller advice
@ControllerAdvice
public class CommonAdvice {
    @ExceptionHandler(ThirdTestException.class)
    public ResponseEntity<Response>handleException(ThirdTestException e){
     Response response =new Response(e.getMessage());
     return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(FourTestException.class)
    public ResponseEntity<Response>handleException(FourTestException e){
        Response response =new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ProductValidationException.class)
    public ResponseEntity<ValidationResponse>handleException(ProductValidationException e){
        ValidationResponse response =new ValidationResponse(e.getMessage(),e.getCause().getMessage());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);

    }
}
