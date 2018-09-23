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

        private ModuleViewHolder(View itemView) {
            super(itemView);
            moduleItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater mInflater;
    private List<ModuleEntity> mModules; // Cached copy of words

    ModuleListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public ModuleListAdapter.ModuleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new ModuleListAdapter.ModuleViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ModuleListAdapter.ModuleViewHolder holder, int position) {
        ModuleEntity current = mModules.get(position);
        holder.moduleItemView.setText(current.getModule_name());
    }

    void setModules(List<ModuleEntity> modules){
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

