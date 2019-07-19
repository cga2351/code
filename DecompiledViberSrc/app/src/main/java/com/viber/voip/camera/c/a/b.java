package com.viber.voip.camera.c.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

@SuppressLint({"ViewConstructor"})
public class b extends SurfaceView
  implements a
{
  private static final String a = com.viber.voip.camera.e.a.a(b.class);
  private com.viber.voip.camera.c.b b = null;
  private int[] c = new int[2];

  public b(Context paramContext, Bundle paramBundle, com.viber.voip.camera.c.b paramb)
  {
    super(paramContext);
    this.b = paramb;
    getHolder().addCallback(paramb);
    getHolder().setType(3);
  }

  public View getView()
  {
    return this;
  }

  public void onDraw(Canvas paramCanvas)
  {
    this.b.a(paramCanvas);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.b.a(this.c, paramInt1, paramInt2);
    super.onMeasure(this.c[0], this.c[1]);
  }

  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.b.a(paramMotionEvent);
  }

  public void setPreviewDisplay(com.viber.voip.camera.a.a parama)
  {
    try
    {
      parama.a(getHolder());
      return;
    }
    catch (com.viber.voip.camera.a.b localb)
    {
    }
  }

  public void setTransform(Matrix paramMatrix)
  {
    throw new RuntimeException();
  }

  public void setVideoRecorder(MediaRecorder paramMediaRecorder)
  {
    paramMediaRecorder.setPreviewDisplay(getHolder().getSurface());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camera.c.a.b
 * JD-Core Version:    0.6.2
 */