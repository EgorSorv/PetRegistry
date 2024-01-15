package programm_interface;

public class InputFunctionException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Введена неверная функция. Пожалуйста, введите номер функции из списка на экране.";
    }
}
