package com.rs.game;

import java.util.Iterator;
import java.util.Set;


public class EntityListIterator<E extends Entity> implements Iterator<E> {
    private Integer[] indicies;
    private Object[] entities;
    @SuppressWarnings("rawtypes")
	private EntityList entityList;
    private int curIndex = 0;

    public EntityListIterator(Object[] entities, Set<Integer> indicies,
                              @SuppressWarnings("rawtypes") EntityList entityList) {
        this.entities = entities;
        this.indicies = indicies.toArray(new Integer[indicies.size()]);
        this.entityList = entityList;
    }

    @Override
	public boolean hasNext() {
        return indicies.length != curIndex;
    }

    @Override
	@SuppressWarnings("unchecked")
	public E next() {
        Object temp = entities[indicies[curIndex]];
        curIndex++;
        return (E) temp;
    }

    @Override
	public void remove() {
        if (curIndex >= 1) {
            entityList.remove(indicies[curIndex - 1]);
        }
    }
}
