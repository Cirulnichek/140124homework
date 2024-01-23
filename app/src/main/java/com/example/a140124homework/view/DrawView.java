package com.example.a140124homework.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import com.example.a140124homework.thread.DrawThread;

public class DrawView extends SurfaceView implements SurfaceHolder.Callback {
    private Context context;
    private DrawThread drawThread;

    private SurfaceHolder holder;
    public DrawView(Context context) {
        super(context);
        getHolder().addCallback(this);
        this.context = context;
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getHolder().addCallback(this);
        this.context = context;
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        this.holder = holder;
        drawThread = new DrawThread(context, holder);
        drawThread.start();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
        //При изменении view
    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
        drawThread.requestStop();
    }

    public void destroyThread() {
        if (holder != null) {
            this.surfaceDestroyed(this.holder);
        }
    }
}
