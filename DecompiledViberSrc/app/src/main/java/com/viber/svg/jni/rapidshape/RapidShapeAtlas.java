package com.viber.svg.jni.rapidshape;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

class RapidShapeAtlas
{
  protected int atlasWidth;
  protected int atomsPerRow;
  protected Bitmap bitmap;
  protected int curAtomX;
  protected int curAtomY;
  private Rect dest = new Rect();
  private Rect src = new Rect();

  public RapidShapeAtlas(Bitmap paramBitmap)
  {
    this.bitmap = paramBitmap;
    this.atlasWidth = paramBitmap.getWidth();
    this.atomsPerRow = (this.atlasWidth / 8);
  }

  private void drawAtom(int paramInt1, int paramInt2, int paramInt3, Canvas paramCanvas, Paint paramPaint)
  {
    this.src.left = this.curAtomX;
    this.src.top = this.curAtomY;
    this.src.right = (8 + this.curAtomX);
    this.src.bottom = (8 + this.curAtomY);
    this.dest.left = paramInt2;
    this.dest.top = paramInt3;
    this.dest.right = (paramInt2 + 8);
    this.dest.bottom = (paramInt3 + 8);
    paramCanvas.drawBitmap(this.bitmap, this.src, this.dest, paramPaint);
    this.curAtomX = (8 + this.curAtomX);
    if (this.curAtomX == this.atlasWidth)
    {
      this.curAtomX = 0;
      this.curAtomY = (1 + this.curAtomY);
    }
  }

  public void drawRegion(int paramInt1, int paramInt2, int paramInt3, Canvas paramCanvas, Paint paramPaint)
  {
    if (paramInt1 == 8)
      drawAtom(paramInt1, paramInt2, paramInt3, paramCanvas, paramPaint);
    while (true)
    {
      return;
      int i = paramInt2 + paramInt1;
      int j = paramInt3 + paramInt1;
      for (int k = paramInt3; k < j; k += 8)
        for (int m = paramInt2; m < i; m += 8)
          drawAtom(paramInt1, m, k, paramCanvas, paramPaint);
    }
  }

  public void setCurrentShape(RapidShapeDescriptor paramRapidShapeDescriptor)
  {
    this.curAtomX = (paramRapidShapeDescriptor.atlasStartIndex % this.atomsPerRow);
    this.curAtomY = (paramRapidShapeDescriptor.atlasStartIndex / this.atomsPerRow);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.svg.jni.rapidshape.RapidShapeAtlas
 * JD-Core Version:    0.6.2
 */