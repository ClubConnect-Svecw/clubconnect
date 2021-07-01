package com.connect.svecw;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends AppCompatActivity {



        Context context;
        LayoutInflater layoutInflater;

        public SliderAdapter(Context context) {
            this.context = context;
        }

        int images[] = {
                R.drawable.add_missing_place_icon,
                R.drawable.add_missing_place_icon,
                R.drawable.add_missing_place_icon,
                R.drawable.add_missing_place_icon,
        };

        int headings[] = {
                R.string.first_slide_title,
                R.string.first_slide_title,
                R.string.first_slide_title,
                R.string.first_slide_title,

        };

        int descriptions[] = {
                R.string.first_slide_desc,
                R.string.first_slide_desc,
                R.string.first_slide_desc,
                R.string.first_slide_desc,


        };


        @Override
        public int getCount() {
            return headings.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == (ConstraintLayout) object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {

            layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.slides_layout, container, false);


            //Hooks
            ImageView imageView = view.findViewById(R.id.slider_image);
            TextView heading = view.findViewById(R.id.slider_heading);
            TextView desc = view.findViewById(R.id.slider_desc);

            imageView.setImageResource(images[position]);
            heading.setText(headings[position]);
            desc.setText(descriptions[position]);

            container.addView(view);

            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((ConstraintLayout) object);
        }
    }

}
