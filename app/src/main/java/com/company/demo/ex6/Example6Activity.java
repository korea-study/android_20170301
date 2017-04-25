package com.company.demo.ex6;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.company.demo.R;

public class Example6Activity extends AppCompatActivity {

    LinearLayout canvasLayout = null;
    Canvas canvas = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example6);

        canvasLayout = (LinearLayout) findViewById(R.id.canvas_layout);
        canvas = new Canvas();

        CustomView customView = new CustomView(this);
        setContentView(customView);
    }


    class CustomView extends View {
        Paint paint;
        public CustomView(Context context) {
            super(context);
            paint = new Paint();
            paint.setColor(Color.RED);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawRect(100, 100, 200, 200, paint);
        }
    }
}
