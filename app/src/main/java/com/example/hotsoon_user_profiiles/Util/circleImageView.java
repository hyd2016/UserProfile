package com.example.hotsoon_user_profiiles.Util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatImageView;

public class circleImageView extends ImageView {
    private Paint paint = new Paint();

    public circleImageView(Context context) {
        super(context);
    }

    public circleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public circleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable == null){
            return;
        }
        //拉伸图片，使宽高相等
        drawable.setBounds(0,0,getWidth(),getHeight());
        //创建图层
        int layer = canvas.saveLayer(0,0,getWidth(),getHeight(),null,Canvas.ALL_SAVE_FLAG);

        drawable.draw(canvas);
        //创建BitMap,绘制1图形
        Bitmap bitmap = Bitmap.createBitmap(getWidth(),getHeight(), Bitmap.Config.ARGB_8888);
        Canvas bitmapCanvas = new Canvas(bitmap);
        bitmapCanvas.drawCircle(getWidth()/2,getHeight()/2,getWidth()/2,paint);

        //设置xfermode
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));

        canvas.drawBitmap(bitmap,0,0,paint);

        canvas.restoreToCount(layer);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        //没有图片返回
        if(getDrawable() == null){
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        //若wrap_content,则宽度1取图片宽度，否则取传过来的值
        if(widthMode == MeasureSpec.AT_MOST){
            width = Math.min(getDrawable().getIntrinsicHeight(),width);
        }
        //同宽度处理
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        if (heightMode == MeasureSpec.AT_MOST){
            height = Math.min(getDrawable().getIntrinsicHeight(),height);
        }

        //取宽高最小，使两者等高
        setMeasuredDimension(Math.min(width,height),Math.min(width,height));

    }


}
