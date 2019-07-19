package com.viber.svg.jni;

import android.graphics.Canvas;
import android.graphics.Picture;
import java.util.ArrayList;

public class PictureRenderer extends AndroidSvgRenderer
{
  private Picture curPicture;
  private Canvas origCanvas;
  ArrayList<Picture> pictures = new ArrayList();

  public PictureRenderer(int paramInt)
  {
    super(paramInt);
  }

  protected void beginPicture()
  {
    try
    {
      this.curPicture = new Picture();
      this.origCanvas = this.canvas;
      if (this.canvas != null);
      for (this.canvas = this.curPicture.beginRecording(this.canvas.getWidth(), this.canvas.getHeight()); ; this.canvas = this.curPicture.beginRecording(1024, 1024))
      {
        this.pictures.add(this.curPicture);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      throw new RuntimeException(localThrowable);
    }
  }

  protected void endPicture()
  {
    this.curPicture.endRecording();
    this.canvas = this.origCanvas;
  }

  protected void renderPicture(int paramInt)
  {
    this.canvas.drawPicture((Picture)this.pictures.get(paramInt));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.svg.jni.PictureRenderer
 * JD-Core Version:    0.6.2
 */