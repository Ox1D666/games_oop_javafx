package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        try {
            if (isFree(source, dest)) {
                rst = true;
                this.figures[this.findBy(source)] = this.figures[this.findBy(source)].copy(dest);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rst;
    }

    private boolean isFree(Cell source, Cell dest) throws ImpossibleMovementException {
        boolean wayFree = false;
        int index = this.findBy(source);
        Cell[] steps = this.figures[index].way(source, dest);
            for (int i = 0; i < steps.length; i++) {
                if (this.findBy(steps[i]) != -1) {
                    break;
                } else
                    wayFree = true;
            }
            if (!wayFree) {
                throw new ImpossibleMovementException("The way is blocked.");
            }
        return wayFree;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    @Override
    public String toString() {
        return "Logic{" +
                "figures=" + Arrays.toString(this.figures) +
                '}';
    }
}
