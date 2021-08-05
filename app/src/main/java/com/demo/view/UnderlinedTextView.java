package com.demo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;

import com.baselibrary.utils.ViewUtil;

import java.util.ArrayList;

public class UnderlinedTextView extends androidx.appcompat.widget.AppCompatTextView {

    /**
     * 默认的文字行上下间隔
     */
    private static final int paddingTop = 20;
    private static final int paddingBottom = 30;
    private static final int paddingLeft = 30;
    private static final int paddingRight = 30;

    /**
     * 控件的宽度与高度
     */
    private int mCanvasWidth;

    /**
     * 垂直偏移量
     */
    private int offsetY = 0;

    /**
     * 根据屏幕容量，每行内容截取的初始位置
     */
    private int mStartIndex = 0;

    /**
     * 文本数组
     */
    private ArrayList<String> dataStr = new ArrayList<String>();

    /**
     * 文本
     */

    private String mText;

    /**
     * 文本画笔
     */

    private Paint mPaint;

    /**
     * 分割线画笔
     */

    private Paint mLPaint;

    /**
     * 预估一行可以容纳的字符量
     */

    private int mEstNumber;

    /**
     * 字符串总长度
     */

    private int mTextLen;

    /**
     * 字体高度
     */

    private int mTextHeight;

    public UnderlinedTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public UnderlinedTextView(Context context) {
        super(context);
        init();
    }

    private void init() {
        mLPaint = new Paint();
        mLPaint.setColor(Color.parseColor("#FFF1EDE4"));
        mLPaint.setAntiAlias(true);
        mLPaint.setDither(true);
        mLPaint.setStrokeWidth(3);
    }

    @Override

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        mCanvasWidth = getWidth() - paddingLeft - paddingRight;
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (dataStr == null || dataStr.size() == 0) {
            mText = getText().toString();
            mPaint = getPaint();
            mPaint.setTextSize(ViewUtil.dip2px(14f));
            mPaint.setColor(Color.parseColor("#FF62331D"));
            // 以当前字体大小，衡量一个汉字的占位
            float mPerCharLength = mPaint.measureText("你");
            // 预估一行可显示多少个字符
            mEstNumber = (int) (mCanvasWidth % mPerCharLength == 0 ? mCanvasWidth / mPerCharLength : mCanvasWidth / mPerCharLength + 1);
            // 文本总长度
            mTextLen = mText.length();
             // 字体高度
            mTextHeight = getFontHeight();
            offsetY = mTextHeight + paddingTop;
            while (mStartIndex < mTextLen) {
                getSingleLine();
            }
        }
        if (dataStr != null) {
            for (int i = 0; i < dataStr.size(); i++) {
                drawLine(canvas, dataStr.get(i));
            }
        }
    }

    private void drawLine(Canvas canvas, String content) {
        if (!TextUtils.isEmpty(content)) {
            canvas.drawText(content, paddingLeft, offsetY, mPaint);
            offsetY += paddingBottom;
            canvas.drawLine(0, offsetY, mCanvasWidth, offsetY, mLPaint);
            offsetY += paddingTop + mTextHeight;
        }
    }

    /**
     * 根据预估，取出最合适的一行内容
     */

    private void getSingleLine() {

        // 每次文本截取的末尾位置
        int mTempLength = mStartIndex + mEstNumber;
        if (mTempLength > mTextLen) {
            String lastContent = mText.substring(mStartIndex);
            dataStr.add(lastContent);
            mStartIndex = mTextLen;
            return;
        }

        // 取出一行预估文本
        String content = mText.substring(mStartIndex, mTempLength);
        // 保存取出的本行内容
        dataStr.add(content);
        // 重置初始位置
        mStartIndex = mTempLength;
    }

    /**
     * 得到字体高度
     *
     * @return
     */

    private int getFontHeight() {
        Paint.FontMetrics fm = mPaint.getFontMetrics();
        return (int) Math.ceil(fm.descent - fm.ascent);
    }

}

