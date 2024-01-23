package com.example.a140124homework.thread;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;

public class DrawThread extends Thread {
    private SurfaceHolder holder;
    private boolean working;
    private Context context;
    private Paint paint;
    private float x, y;
    private int x_dur, y_dur;

    public DrawThread(Context context, SurfaceHolder surfaceHolder) {
        this.holder = surfaceHolder;
        this.context = context;
        this.working = true;

        x = 150;
        y = 150;

        x_dur = 1;
        y_dur = 1;

        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
    }

    @Override
    public void run() {
        while (working) {
            Canvas canvas = holder.lockCanvas();
            if (canvas != null) {
                int width = canvas.getWidth();
                int height = canvas.getHeight();
                try {
                    canvas.drawColor(Color.WHITE);
                    canvas.drawCircle(x, y, 150, paint);
                    x += 10 * this.x_dur;
                    y += 10 * this.y_dur;
                    if (x < 150 || x > width - 150) {
                        x_dur *= -1;
                    }
                    if (y < 150 || y > height - 150) {
                        y_dur *= -1;
                    }
                } finally {
                    holder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }

    public void requestStop() {
        working = false;
    }
}
