/*
 * This file is part of GrALoG FX, Copyright (c) 2016 LaS group, TU Berlin.
 * License: https://www.gnu.org/licenses/gpl.html GPL version 3 or later.
 */
package gralog.gralogfx.views;

import gralog.gralogfx.StructurePane;

/**
 *
 * @param <T> The object to display.
 */
public interface View<T> {
    void setObject(T obj);
    void setStructurePane(StructurePane structurePane);
}
