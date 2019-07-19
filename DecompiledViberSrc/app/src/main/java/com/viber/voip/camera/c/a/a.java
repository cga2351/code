package com.viber.voip.camera.c.a;

import android.graphics.Matrix;
import android.media.MediaRecorder;
import android.view.View;

public abstract interface a
{
  public abstract View getView();

  public abstract void setPreviewDisplay(com.viber.voip.camera.a.a parama);

  public abstract void setTransform(Matrix paramMatrix);

  public abstract void setVideoRecorder(MediaRecorder paramMediaRecorder);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camera.c.a.a
 * JD-Core Version:    0.6.2
 */