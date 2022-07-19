package com.krunal.locationexample.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.krunal.locationexample.Database.LogsEntity;
import com.krunal.locationexample.R;
import com.krunal.locationexample.Utility.LogsRecycleView;
import com.krunal.locationexample.ViewModel.LogsActivityViewModel;

import java.util.List;

public class LogsActivity extends AppCompatActivity {

    private RecyclerView mRecycleView;
    private LogsActivityViewModel mLogsActivityViewModel;
    private LogsRecycleView mLogsRecycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logs);

        setTitle("Logs");

        mRecycleView = findViewById(R.id.recyclerView);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));

        mLogsRecycleView = new LogsRecycleView(this);

        mLogsActivityViewModel = ViewModelProviders.of(this).get(LogsActivityViewModel.class);

        mLogsActivityViewModel.getpetslist().observe(this, new Observer<List<LogsEntity>>() {
            @Override
            public void onChanged(@Nullable List<LogsEntity> logsEntities) {
                mLogsRecycleView.add(logsEntities);
                mRecycleView.setAdapter(mLogsRecycleView);
            }
        });

    }
}
