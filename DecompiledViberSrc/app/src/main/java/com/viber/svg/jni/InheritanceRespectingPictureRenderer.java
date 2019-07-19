package com.viber.svg.jni;

import android.graphics.Canvas;
import android.graphics.Picture;
import java.util.ArrayList;
import java.util.Stack;

public class InheritanceRespectingPictureRenderer extends AndroidSvgRenderer
{
  Stack<Canvas> canvasStack;
  Stack<Picture> pictureStack;
  ArrayList<Picture> pictures = new ArrayList();

  public InheritanceRespectingPictureRenderer(int paramInt)
  {
    super(paramInt);
  }

  protected void beginPicture()
  {
    try
    {
      beginElement(1.0D);
      Picture localPicture = new Picture();
      this.pictures.add(localPicture);
      this.pictureStack.push(localPicture);
      this.canvasStack.push(this.canvas);
      this.canvas = localPicture.beginRecording(this.prepareViewportWidth, this.prepareViewportHeight);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      throw new RuntimeException(localThrowable);
    }
  }

  protected void beginPictures()
  {
    this.canvasStack = new Stack();
    this.canvasStack.push(this.canvas);
    this.canvas = new Canvas();
    this.pictureStack = new Stack();
  }

  protected void endPicture()
  {
    ((Picture)this.pictureStack.pop()).endRecording();
    this.canvas = ((Canvas)this.canvasStack.pop());
    endElement();
  }

  protected void endPictures()
  {
    this.canvas = ((Canvas)this.canvasStack.pop());
    this.canvasStack = null;
    this.pictureStack = null;
  }

  protected void renderPicture(int paramInt)
  {
    this.canvas.drawPicture((Picture)this.pictures.get(paramInt));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.svg.jni.InheritanceRespectingPictureRenderer
 * JD-Core Version:    0.6.2
 */