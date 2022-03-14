package fr.everwin.open.api.model.core;

import java.util.List;

public interface BasicListInterface<T extends BasicObject> {

    List<T> getItems();

    void setItems(List<T> items);

}
