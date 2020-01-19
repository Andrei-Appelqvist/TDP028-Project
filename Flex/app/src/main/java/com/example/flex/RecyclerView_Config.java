package com.example.flex;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerView_Config {
    private Context mContext;
    private WorkoutsAdapter mWorkoutsAdapter;
    public void setConfig(RecyclerView recyclerView, Context context, List<Workout> workouts, List<String> keys){
        mContext = context;
        mWorkoutsAdapter = new WorkoutsAdapter(workouts, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mWorkoutsAdapter);
    }

    class WorkoutItemView extends RecyclerView.ViewHolder{
        private TextView mName;
        private TextView mDesc;

        private String key;
        public WorkoutItemView(ViewGroup parent){
            super(LayoutInflater.from(mContext).inflate(R.layout.workout_list_item, parent, false));

            mName = (TextView) itemView.findViewById(R.id.workout_name);
            mDesc = (TextView) itemView.findViewById(R.id.workout_description);
        }
        public void bind(Workout workout, String key){
            mName.setText(workout.getwName());
            mDesc.setText(workout.getwDesc());
            this.key = key;
        }
    }

    class WorkoutsAdapter extends RecyclerView.Adapter<WorkoutItemView>{
        private List<Workout> mWorkoutList;
        private List<String> mKeys;

        public WorkoutsAdapter(List<Workout> mWorkoutList, List<String> mKeys) {
            this.mWorkoutList = mWorkoutList;
            this.mKeys = mKeys;
        }

        public WorkoutsAdapter() {
            super();
        }

        @NonNull
        @Override
        public WorkoutItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new WorkoutItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull WorkoutItemView holder, int position) {
            holder.bind(mWorkoutList.get(position), mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            Log.d("shit",String.valueOf(mWorkoutList.size()));
            return mWorkoutList.size();
        }
    }
}
