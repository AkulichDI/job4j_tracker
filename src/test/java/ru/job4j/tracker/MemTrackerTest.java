package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.action.CreateAction;
import ru.job4j.tracker.action.DeleteAction;
import ru.job4j.tracker.action.ExitAction;
import ru.job4j.tracker.action.FindAllAction;
import ru.job4j.tracker.action.FindByIdAction;
import ru.job4j.tracker.action.FindByNameAction;
import ru.job4j.tracker.action.ReplaceAction;
import ru.job4j.tracker.action.UserAction;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.MockInput;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemTrackerTest {
    @Test
    void whenTestFindById() {
        MemTracker memTracker = new MemTracker();
        Item bug = new Item("Bug");
        Item item = memTracker.add(bug);
        Item result = memTracker.findById(item.getId());
        assertThat(result.getName()).isEqualTo(item.getName());
    }

    @Test
    void whenTestFindAll() {
        MemTracker memTracker = new MemTracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        memTracker.add(first);
        memTracker.add(second);
        Item result = memTracker.findAll().get(0);
        assertThat(result.getName()).isEqualTo(first.getName());
    }

    @Test
    void whenTestFindByNameCheckArrayLength() {
        MemTracker memTracker = new MemTracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        memTracker.add(first);
        memTracker.add(second);
        memTracker.add(new Item("First"));
        memTracker.add(new Item("Second"));
        memTracker.add(new Item("First"));
        List<Item> result = memTracker.findByName(first.getName());
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    void whenTestFindByNameCheckSecondItemName() {
        MemTracker memTracker = new MemTracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        memTracker.add(first);
        memTracker.add(second);
        memTracker.add(new Item("First"));
        memTracker.add(new Item("Second"));
        memTracker.add(new Item("First"));
        List<Item> result = memTracker.findByName(second.getName());
        assertThat(result.get(1).getName()).isEqualTo(second.getName());
    }

    @Test
    void whenReplaceItemIsSuccessful() {
        MemTracker memTracker = new MemTracker();
        Item item = new Item("Bug");
        memTracker.add(item);
        int id = item.getId();
        Item updateItem = new Item("Bug with description");
        memTracker.replace(id, updateItem);
        assertThat(memTracker.findById(id).getName()).isEqualTo("Bug with description");
    }

    @Test
    void whenReplaceItemIsNotSuccessful() {
        MemTracker memTracker = new MemTracker();
        Item item = new Item("Bug");
        memTracker.add(item);
        Item updateItem = new Item("Bug with description");
        boolean result = memTracker.replace(1000, updateItem);
        assertThat(memTracker.findById(item.getId()).getName()).isEqualTo("Bug");
        assertThat(result).isFalse();
    }
}

class StartUITest {
    @Test
    void whenInvalidExit() {
        Output output = new StubOutput();
        Input input = new MockInput(new String[] {"1", "0"});
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, memTracker, actions);
        assertThat(output.toString())
                .contains("0 .. 0")
                .contains("0.");
    }

    @Test
    void whenExit() {
        Output output = new StubOutput();
        Input input = new MockInput(new String[] {"0"});
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, memTracker, actions);
        assertThat(output.toString()).contains("0.").contains("===");
    }

    @Test
    void whenReplaceItemTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item one = memTracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input input = new MockInput(new String[] {"0", String.valueOf(one.getId()), replaceName, "1"});
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ReplaceAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, memTracker, actions);
        assertThat(memTracker.findById(one.getId()).getName()).isEqualTo(replaceName);
    }

    @Test
    void whenFindAllActionDisplaysItems() {
        Output output = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item first = memTracker.add(new Item("First"));
        Item second = memTracker.add(new Item("Second"));
        Input input = new MockInput(new String[] {"0", "1"});
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindAllAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, memTracker, actions);
        assertThat(output.toString())
                .contains(first.getName())
                .contains(second.getName());
    }

    @Test
    void whenFindByNameActionDisplaysMatchingItems() {
        Output output = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item first = memTracker.add(new Item("Test"));
        Item second = memTracker.add(new Item("Test"));
        memTracker.add(new Item("Other"));
        Input input = new MockInput(new String[] {"0", first.getName(), "1"});
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByNameAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, memTracker, actions);
        assertThat(output.toString())
                .contains("ID")
                .contains(String.valueOf(first.getId()))
                .contains(String.valueOf(second.getId()));
    }

    @Test
    void whenFindByIdActionDisplaysItem() {
        Output output = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Test"));
        Input input = new MockInput(new String[] {"0", String.valueOf(item.getId()), "1"});
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByIdAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, memTracker, actions);
        assertThat(output.toString())
                .contains(item.getName())
                .contains(String.valueOf(item.getId()));
    }
}

class ValidateInputTest {

    @Test
    void whenInvalidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenValidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenValidInputList() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"3", "4", "5"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        int selected1 = input.askInt("Enter menu:");
        int selected2 = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(3);
        assertThat(selected1).isEqualTo(4);
        assertThat(selected2).isEqualTo(5);
    }

    @Test
    void whenMinusValidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"-3"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-3);
    }
}
