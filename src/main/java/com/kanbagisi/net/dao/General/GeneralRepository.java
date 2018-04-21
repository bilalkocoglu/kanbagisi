package com.kanbagisi.net.dao.General;

import com.kanbagisi.net.entity.User;

public interface GeneralRepository {
    public boolean save(Object data);

    public <T> T findById(Class<T> clazz, int id);

}
