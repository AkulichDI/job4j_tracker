package ru.job4j.tracker.input;

import ru.job4j.tracker.output.Output;

public class ValidateInput extends ConsoleInput {

    private final Output output;
    private final Input input;

    public ValidateInput(Output output, Input input) {
        this.output = output;
        this.input = input;
    }

    @Override
    public String askStr(String question) {
        return super.askStr(question);
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = - 1;
        do {
            try{
                value = super.askInt(question);
                invalid = false;

            }catch (NumberFormatException nfe ){
                System.out.println("Пожалуста, введите корректные данные");
            }
        }while (invalid);
        return value;
    }
}
