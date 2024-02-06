package de.aittr.g_31_2_shop.exception_handling.exceptions;
// 3 способ ловит любые исключения по всему проекту
public class ThirdTestException extends RuntimeException{
    public ThirdTestException(String message) {
        super(message);
    }
}
