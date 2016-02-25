package com.ngaini.arttherpy;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class DrawActivity extends AppCompatActivity {

//    //for drawing path
//    private Path drawPath;
//    // for adding style color etc to our shape
//    private Paint drawPaint, canvasPaint;
//    // initial color
//    private int paintColor= 0xAA60A00;
//
//    //canvas
//    private Canvas drawCanvas;
//    //canvas bitmap
//    private Bitmap canvasBitmap;
//
//    public DrawActivity(Context context)
//    {
//        super(context);
//    }
//
//    public DrawActivity(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        setUpDrawing();
//    }
//
//
//    @Override
//    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
//        super.onSizeChanged(w, h, oldw, oldh);
//        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
//        drawCanvas = new Canvas(canvasBitmap);
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
////        super.onDraw(canvas);
//
//        canvas.drawBitmap(canvasBitmap,0,0,canvasPaint);
//
//        // draw the path based on the paint mentioned above
//        canvas.drawPath(drawPath, drawPaint);
//    }
//
//    //register user touches as drawing operations
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
////        return super.onTouchEvent(event);
//
//        //retrieve x-y co ordinates of the users touch interactions
//        float touchX = event.getX();
//        float touchY = event.getY();
//
//        switch(event.getAction())
//        {
//            case MotionEvent.ACTION_DOWN:
//                drawPath.moveTo(touchX, touchY);
//                break;
//
//            case MotionEvent.ACTION_MOVE:
//                drawPath.lineTo(touchX,touchY);
//                break;
//
//            case MotionEvent.ACTION_UP:
//                drawCanvas.drawPath(drawPath, drawPaint);
//                drawPath.reset();
//                break;
//            default:
//                return false;
//        }
//
//        // invalidate method will cause onDraw to execute
//        invalidate();
//        return true;
//    }
//
//    /**
//     *
//     */
//    private void setUpDrawing() {
//
//
//        //instantiate drawing variables
//        drawPath = new Path();
//        drawPaint= new Paint();
//
//        //Setting initial path properties
//
//        /**
//         * anti-alias, stroke join and cap styles
//         * allow the users drawing to appear smoother
//         */
//        //for smoothing edges of what is being drawn
//        drawPaint.setAntiAlias(true);
//        drawPaint.setStrokeWidth(20);
//        drawPaint.setStyle(Paint.Style.STROKE);
//        drawPaint.setStrokeJoin(Paint.Join.ROUND);
//        drawPaint.setStrokeCap(Paint.Cap.ROUND);
//
//        canvasPaint = new Paint(Paint.DITHER_FLAG);
//
//
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
