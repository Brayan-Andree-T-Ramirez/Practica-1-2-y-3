package com.upiiz.practica_1_2_3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.upiiz.practica_1_2_3.Adapters.ImageSliderAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_inicio#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_inicio extends Fragment {

    private ViewPager2 viewPagerImages;
    private SpringDotsIndicator dotsIndicator;
    private ImageSliderAdapter adapter;
    private final Handler sliderHandler = new Handler();
    private Runnable sliderRunnable;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_inicio() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_inicio.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_inicio newInstance(String param1, String param2) {
        fragment_inicio fragment = new fragment_inicio();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,@Nullable
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio, container, false);
    }
    @Override
    public void onViewCreated(@NonNull  View view,@Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);

        //Vincular los elementos del XML usando la vista (view)
        viewPagerImages = view.findViewById(R.id.viewPagerImages);
        dotsIndicator = view.findViewById(R.id.dotsIndicator);

        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.prueba);
        images.add(R.drawable.prueba);
        images.add(R.drawable.prueba);
        images.add(R.drawable.prueba);

        //Configurar el adaptador y asignarlo al ViewPager2
        adapter = new ImageSliderAdapter(images);
        viewPagerImages.setAdapter(adapter);

        //Conectar los puntos indicadores automáticamente
        dotsIndicator.setViewPager2(viewPagerImages);

        //Configurar la lógica de auto-play
        sliderRunnable = new Runnable() {
            @Override
            public void run() {
                if (viewPagerImages == null || adapter == null || adapter.getItemCount() == 0) return;

                int currentItem = viewPagerImages.getCurrentItem();
                int totalItems = adapter.getItemCount();

                if (currentItem < totalItems - 1) {
                    viewPagerImages.setCurrentItem(currentItem + 1, true);
                } else {
                    viewPagerImages.setCurrentItem(0, true);
                }
                sliderHandler.postDelayed(this, 3000);
            }
        };

        //Evento para reiniciar el tiempo si el usuario desliza con el dedo manualmente
        viewPagerImages.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable,3000);
            }
        });


    }

    @Override
    public void onStart(){
        super.onStart();
        sliderHandler.postDelayed(sliderRunnable,3000);
    }

    @Override
    public void onStop(){
        super.onStop();
        sliderHandler.removeCallbacks(sliderRunnable);
    }
}