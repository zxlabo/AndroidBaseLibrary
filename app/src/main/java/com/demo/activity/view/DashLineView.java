package com.demo.activity.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DashLineView extends View {


    private Paint mPaint;
    private Paint mPaint2;

    private Path mPath;

    public DashLineView(Context context) {
        this(context,null);
    }



    public DashLineView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DashLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint2 = new Paint(Paint.ANTI_ALIAS_FLAG);

        mPaint.setColor(Color.RED);
        mPaint2.setColor(Color.RED);

        // 需要加上这句，否则画不出东西

        mPaint.setStyle(Paint.Style.STROKE);

        mPaint.setStrokeWidth(3);

        mPaint.setPathEffect(new DashPathEffect(new float[] {15, 5}, 0));

        mPath = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int centerY = getHeight() / 2;

        mPath.reset();

        mPath.moveTo(0, centerY);

        mPath.lineTo(getWidth(), centerY);

        canvas.drawPath(mPath, mPaint);

        canvas.drawLine(100f,200f,400f,200f,mPaint2);
        canvas.drawLine(200f,0f,200f,600f,mPaint2);
        canvas.drawText("hello",200f,200f,mPaint2);
    }

}