package com.krunal.locationexample.Database;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface LogsDao {


    @Query("select * from Logs_tbl")
    LiveData<List<LogsEntity>> getLogsList();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void Insert(LogsEntity logsEntity);


}
