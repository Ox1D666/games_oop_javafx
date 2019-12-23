package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {
    @Test
    public void checkStartPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell cell = bishopBlack.position();
        assertThat(cell, is(Cell.C1));
    }
    @Test
    public void copyFigureInNewPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Figure expect = bishopBlack.copy(Cell.E3);
        Cell cell = expect.position();
        assertThat(cell, is(Cell.E3));
    }
    @Test
    public void whenMoveFigure() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] cell = bishopBlack.way(Cell.C1, Cell.G5);
        Cell[] expect = {Cell.D2,Cell.E3,Cell.F4,Cell.G5};
        assertThat(cell, is(expect));
    }
}
