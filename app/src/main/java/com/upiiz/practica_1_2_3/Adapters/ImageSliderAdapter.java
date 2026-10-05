package com.upiiz.practica_1_2_3.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.upiiz.practica_1_2_3.R;

import java.util.List;

public class ImageSliderAdapter extends RecyclerView.Adapter<ImageSliderAdapter.SliderViewHolder> {

    private List<Integer> imageList;

    public ImageSliderAdapter(List<Integer> imageList){
        this.imageList=imageList;
    }

    @NonNull
    @Override
    public ImageSliderAdapter.SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageSliderAdapter.SliderViewHolder holder, int position) {
        //Carga la imagen en el ImageView
        holder.imageView.setImageResource(imageList.get(position));
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public static class SliderViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;

        public SliderViewHolder(@NonNull View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewSlide);
        }
    }
}
