package de.aittr.g_31_2_shop.exception_handling.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 2  способ размещение аннотации в калссе не можем
// отправить клиету инфо сообщение,
// глобальный обработчик реагирует на ошибки викинутые в любом месте приложения

@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
public class SecondTestException extends RuntimeException{

    public SecondTestException(String message) {
        super(message);
    }
}
