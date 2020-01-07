package ru.job4j;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.RookBlack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

public class LogicTest {
    @Test
    public void whenWeCanMoveFigure() {
        Logic logic = new Logic();
        Figure bishop = new BishopBlack(Cell.C1);
        logic.add(bishop);
        boolean expect = logic.move(Cell.C1, Cell.G5);
        assertEquals(expect, true);
    }

    @Test
    public void whenWeCantMoveFigure() {
        Logic logic = new Logic();
        Figure bishop = new BishopBlack(Cell.C1);
        Figure rook = new RookBlack(Cell.D2);
        logic.add(rook);
        logic.add(bishop);
        boolean expect = logic.move(Cell.C1, Cell.G5);
        assertEquals(expect, false);
    }
}
