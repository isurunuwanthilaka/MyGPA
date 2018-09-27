package isumalab.entc.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import isumalab.entc.R;
import isumalab.entc.activity.EditModuleActivity;
import isumalab.entc.activity.InfoActivity;
import isumalab.entc.activity.SemesterOneActivity;
import isumalab.entc.entity.ModuleEntity;

import static android.content.ContentValues.TAG;

public class ModuleListAdapter extends RecyclerView.Adapter<ModuleListAdapter.ModuleViewHolder> {

    class ModuleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView moduleItemView;
        private final TextView moduleCode;
        private final TextView moduleGpa;
        private final TextView moduleCredit;
        private final TextView moduleScore;

        //testing
        private String mName;
        private String mCode;
        private boolean mGpa;
        private double mCredits;
        private double mScore;
        private int id;


        private ModuleViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            moduleItemView = itemView.findViewById(R.id.textView);
            moduleCode = itemView.findViewById(R.id.textViewModuleCodeEdit);
            moduleGpa = itemView.findViewById(R.id.textViewGPAEdit);
            moduleCredit = itemView.findViewById(R.id.textViewCreditEdit);
            moduleScore = itemView.findViewById(R.id.textViewScoreEdit);
        }

        public void setmName(String item) {
            mName = item;
        }

        public void setId(int item) {
            id = item;
        }

        public void setmCode(String item){
            mCode = item;
        }

        public void setmGpa(boolean item){
            mGpa = item;
        }

        public void setmCredit(double item){
            mCredits = item;
        }

        public void setmScore(double mScore) {
            this.mScore = mScore;
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(),"Module name "+mName, Toast.LENGTH_LONG).show();

            Bundle bundle = new Bundle();
            Intent intent = new Intent(view.getContext(), EditModuleActivity.class);
            bundle.putInt("id",id);
            bundle.putString("name",mName);
            bundle.putString("code",mCode);
            bundle.putBoolean("gpa",mGpa);
            bundle.putFloat("credit",Float.parseFloat(String.valueOf(mCredits)));
            bundle.putFloat("score",Float.parseFloat(String.valueOf(mScore)));
            intent.putExtras(bundle);
            view.getContext().startActivity(intent);
            System.out.print("Succesfully leave activity");
        }

    }

    private final LayoutInflater mInflater;
    private List<ModuleEntity> mModules; // Cached copy of words

    public ModuleListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public ModuleListAdapter.ModuleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new ModuleListAdapter.ModuleViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ModuleListAdapter.ModuleViewHolder holder, int position) {
        ModuleEntity current = mModules.get(position);
        holder.moduleItemView.setText(current.getModule_name());
        holder.moduleCode.setText(current.getModule_code());
        holder.moduleGpa.setText(String.valueOf(current.isGpa()));
        holder.moduleCredit.setText(String.valueOf(current.getCredit()));
        holder.moduleScore.setText(String.valueOf(current.getScore()));

        holder.setmName(current.getModule_name());
        holder.setmCode(current.getModule_code());
        holder.setmGpa(current.isGpa());
        holder.setmCredit(current.getCredit());
        holder.setmScore(current.getScore());
        holder.setId(current.getId());
    }

    public void setModules(List<ModuleEntity> modules){
        mModules = modules;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mModules != null)
            return mModules.size();
        else return 0;
    }
}

