package isumalab.entc.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import isumalab.entc.R;
import isumalab.entc.entity.ModuleEntity;

public class ModuleListAdapter extends RecyclerView.Adapter<ModuleListAdapter.ModuleViewHolder> {

    class ModuleViewHolder extends RecyclerView.ViewHolder {
        private final TextView moduleItemView;
        private final TextView moduleCode;
        private final TextView moduleGpa;
        private final TextView moduleCredit;
        private final TextView moduleScore;

        private ModuleViewHolder(View itemView) {
            super(itemView);
            moduleItemView = itemView.findViewById(R.id.textView);
            moduleCode = itemView.findViewById(R.id.textViewModuleCodeEdit);
            moduleGpa = itemView.findViewById(R.id.textViewGPAEdit);
            moduleCredit = itemView.findViewById(R.id.textViewCreditEdit);
            moduleScore = itemView.findViewById(R.id.textViewScoreEdit);
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

