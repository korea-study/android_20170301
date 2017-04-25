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
        Paint paint1;
        Paint paint2;
        Paint paint3;


        public CustomView(Context context) {
            super(context);
            paint1 = new Paint();
            paint1.setColor(Color.RED);

            paint2 = new Paint();
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setStrokeWidth(3);
            paint2.setColor(Color.GREEN);

            paint3 = new Paint();
            paint3.setColor(Color.BLUE);
            paint3.setStyle(Paint.Style.FILL);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawRect(100, 100, 200, 200, paint1);
            canvas.drawCircle(50, 160, 40, paint2);
            canvas.drawCircle(300, 400, 50, paint3);
        }
    }
}
