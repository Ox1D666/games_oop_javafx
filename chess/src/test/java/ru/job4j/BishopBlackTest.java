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
    public void whenMoveFigureUpAndRight() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] cell = bishopBlack.way(Cell.C1, Cell.G5);
        Cell[] expect = {Cell.D2,Cell.E3,Cell.F4,Cell.G5};
        assertThat(cell, is(expect));
    }
    @Test
    public void whenMoveFigureUpAndLeft() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F1);
        Cell[] cell = bishopBlack.way(Cell.F1, Cell.D3);
        Cell[] expect = {Cell.E2,Cell.D3};
        assertThat(cell, is(expect));
    }
    @Test
    public void whenMoveFigureDownAndRight() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D3);
        Cell[] cell = bishopBlack.way(Cell.D3, Cell.F1);
        Cell[] expect = {Cell.E2,Cell.F1};
        assertThat(cell, is(expect));
    }
    @Test
    public void whenMoveFigureDownAndLeft() {
        BishopBlack bishopBlack = new BishopBlack(Cell.G5);
        Cell[] cell = bishopBlack.way(Cell.G5, Cell.C1);
        Cell[] expect = {Cell.F4, Cell.E3, Cell.D2, Cell.C1};
        assertThat(cell, is(expect));
    }
    @Test
    public void whenMoveNotDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        boolean expect = bishopBlack.isDiagonal(Cell.C1, Cell.C3);
        assertThat(expect, is(false));
    }
}
