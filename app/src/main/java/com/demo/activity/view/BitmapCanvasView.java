package com.demo.activity.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


public class BitmapCanvasView extends View {
    private Paint mPaint;

    public BitmapCanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap mBmp = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas mBmpCanvas = new Canvas(mBmp);
        mPaint.setTextSize(100);
        mBmpCanvas.drawText("bitmap 自定义text", 0, 100, mPaint);
        //要用onDraw传进来的canvas才能画到当前view上
        canvas.drawBitmap(mBmp, 0, 0, mPaint);
    }
}