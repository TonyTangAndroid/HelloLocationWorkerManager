package com.krunal.locationexample.Database;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.krunal.locationexample.Utility.AppExecutor;
import java.util.List;

public class Repository {

  private LiveData<List<LogsEntity>> mLogsList;
  private AppDatabase mAppDatabase;
  private AppExecutor mAppExecutor;

  public Repository(Context context) {
    this.mAppExecutor = new AppExecutor();
    this.mAppDatabase = AppDatabase.getInstance(context);
    this.mLogsList = mAppDatabase.getLogsDao().getLogsList();
  }

  public void Insert(LogsEntity logsEntity) {
    mAppExecutor
        .diskIO()
        .execute(
            () -> {
              mAppDatabase.getLogsDao().Insert(logsEntity);
            });
  }

  public LiveData<List<LogsEntity>> getLogsList() {
    return mLogsList;
  }
}
