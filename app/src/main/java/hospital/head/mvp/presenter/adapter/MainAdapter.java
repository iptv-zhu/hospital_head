package hospital.head.mvp.presenter.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

import hospital.head.R;
import hospital.head.mvp.view.DocActivity;
import hospital.head.utils.Logs;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    private Context context;
    private List<String> list;

    public MainAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_list, parent, false);
//        View view = LayoutInflater.from(context).inflate(R.layout.adapter_list2, parent, false);
        return new ViewHolder(view);
    }

    int[] doc_ico = {R.drawable.doc_1, R.drawable.doc_3, R.drawable.doc_5};
    int[] nur_ico = {R.drawable.doc_2, R.drawable.doc_4, R.drawable.doc_6};

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        try {
            if (position == 0) {
//                line1.setVisibility(View.GONE);
//                line2.setVisibility(View.VISIBLE);
            } else {
//                line1.setVisibility(View.VISIBLE);
//                line2.setVisibility(View.GONE);
                bed_no.setText(position + "");
                name.setText("患者" + position);
                doc_name.setText("医生" + position);

                nur_name.setText("护士" + position);


                doc_icon.setBackgroundResource(doc_ico[(position - 1) % 3]);
                nur_icon.setImageResource(nur_ico[(position - 1) % 3]);


            }
            doc_icon.setTag(list.get(position));
            nur_icon.setTag(list.get(position));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

//    @Override
//    public long getItemId(int position) {
//        return position;
//    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


    private TextView bed_no, name;
    private ImageView doc_icon, nur_icon;
    private TextView doc_name, nur_name;
    private LinearLayout line1, line2;


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
            bed_no = itemView.findViewById(R.id.bed_no);
            name = itemView.findViewById(R.id.name);
            doc_name = itemView.findViewById(R.id.doc_name);
            nur_name = itemView.findViewById(R.id.nur_name);
            doc_icon = itemView.findViewById(R.id.doc_icon);
            doc_icon.setOnClickListener(MainAdapter.this);
            nur_icon = itemView.findViewById(R.id.nur_icon);
            nur_icon.setOnClickListener(MainAdapter.this);
//            line1 = itemView.findViewById(R.id.line1);
//           line2 = itemView.findViewById(R.id.line2);
        }
    }

    @Override
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("key", (Serializable) view.getTag());
        context.startActivity(new Intent(context, DocActivity.class).putExtras(bundle));
    }


}
