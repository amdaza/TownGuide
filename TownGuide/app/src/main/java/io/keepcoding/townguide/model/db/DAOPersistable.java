package io.keepcoding.townguide.model.db;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

public interface DAOPersistable<T> {
    long insert(@NonNull T data);
    void update(long id, @NonNull T data);
    void delete(long id);
    void deleteAll();
    @Nullable
    Cursor queryCursor();
    T query(long id);
    @Nullable
    List<T> query();
}
