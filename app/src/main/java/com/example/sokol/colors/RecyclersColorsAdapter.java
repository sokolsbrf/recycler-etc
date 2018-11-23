package com.example.sokol.colors;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.example.sokol.colors.ColorsAdapter.LIMIT;
import static com.example.sokol.colors.ColorsAdapter.STEP;

public class RecyclersColorsAdapter extends RecyclerView.Adapter<RecyclersColorsAdapter.Holder> {

    private List<String> colorsList = new ArrayList<>();

    public RecyclersColorsAdapter() {
        initColors();
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup recycler, int i) {
        LayoutInflater inflater = LayoutInflater.from(recycler.getContext());
        return new Holder(inflater.inflate(R.layout.item_color, recycler, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.bind(colorsList.get(position));
    }

    @Override
    public int getItemCount() {
        return colorsList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private void initColors() {
        for (int red = 0; red < LIMIT; red += STEP) {
            for (int green = 0;  green < LIMIT; green += STEP) {
                for (int blue = 0; blue < LIMIT; blue += STEP) {
                    String color = "#" + component(red) + component(green) + component(blue);
                    colorsList.add(color);
                }
            }
        }
    }

    private String component(int value) {
        String result = Integer.toHexString(value);
        return result.length() == 2? result : "0" + result;
    }

    public static class Holder extends RecyclerView.ViewHolder {
        private TextView colorName;
        private View preview;

        public Holder(@NonNull View itemView) {
            super(itemView);

            colorName = itemView.findViewById(R.id.color_name);
            preview = itemView.findViewById(R.id.preview);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    v.setBackgroundColor(Color.CYAN);
                }
            });
        }

        public void bind(String color) {
            colorName.setText(color);
            preview.setBackgroundColor(Color.parseColor(color));
        }
    }

}
