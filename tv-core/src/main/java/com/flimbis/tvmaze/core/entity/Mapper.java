package com.flimbis.tvmaze.core.entity;

import java.util.List;

/**
 * Created by Fifi on 6/7/2018.
 */

public abstract class Mapper<E, T> {
    public abstract E toEntity(T model);

    public abstract List<E> toEntityList(List<T> modelList);

    public abstract T toModel(E entity);

    public abstract List<E> toModelList(List<T> entityList);
}
