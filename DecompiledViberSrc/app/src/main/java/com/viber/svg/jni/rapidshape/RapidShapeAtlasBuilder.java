package com.viber.svg.jni.rapidshape;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.viber.svg.jni.Logger;

class RapidShapeAtlasBuilder
  implements RapidShapeTraverser.Visitor
{
  private static Logger L = Logger.create(RapidShapeAtlasBuilder.class.getSimpleName());
  private Bitmap atlasBitmap;
  private Canvas atlasCanvas;
  private int atlasWidth;
  private int atomCount;
  private int curAtomX;
  private int curAtomY;
  private Rect dest = new Rect();
  private RapidShape[] shapes;
  private Rect src = new Rect();
  private Bitmap stagingBitmap;
  private Canvas stagingCanvas;

  public RapidShapeAtlasBuilder(int paramInt1, int paramInt2, int paramInt3, int paramInt4, RapidShape[] paramArrayOfRapidShape)
  {
    this.atlasWidth = paramInt1;
    Bitmap.Config localConfig = Bitmap.Config.ALPHA_8;
    this.atlasBitmap = Bitmap.createBitmap(paramInt1, paramInt2, localConfig);
    this.atlasCanvas = new Canvas(this.atlasBitmap);
    this.stagingBitmap = Bitmap.createBitmap(paramInt3, paramInt4, localConfig);
    this.stagingCanvas = new Canvas(this.stagingBitmap);
    this.shapes = paramArrayOfRapidShape;
  }

  private void extractAtom(int paramInt1, int paramInt2, int paramInt3)
  {
    this.src.left = paramInt2;
    this.src.top = paramInt3;
    this.src.right = (paramInt2 + 8);
    this.src.bottom = (paramInt3 + 8);
    this.dest.left = this.curAtomX;
    this.dest.top = this.curAtomY;
    this.dest.right = (8 + this.curAtomX);
    this.dest.bottom = (8 + this.curAtomY);
    this.atlasCanvas.drawBitmap(this.stagingBitmap, this.src, this.dest, null);
    this.atomCount = (1 + this.atomCount);
    this.curAtomX = (8 + this.curAtomX);
    if (this.curAtomX == this.atlasWidth)
    {
      this.curAtomX = 0;
      this.curAtomY = (1 + this.curAtomY);
    }
  }

  public RapidShapeAtlas build(RapidShapeStagingDrawDelegate paramRapidShapeStagingDrawDelegate)
  {
    paramRapidShapeStagingDrawDelegate.drawShapesForStaging(new RapidShapeStagingDrawInterface()
    {
      private int curShapeIndex = 0;

      public Paint beginShape(Paint paramAnonymousPaint)
      {
        RapidShape localRapidShape = RapidShapeAtlasBuilder.this.shapes[this.curShapeIndex];
        RapidShapeAtlasBuilder.this.stagingCanvas.save();
        RapidShapeAtlasBuilder.this.stagingCanvas.translate(-localRapidShape.getDescriptor().stagingOffsetX, -localRapidShape.getDescriptor().stagingOffsetY);
        return RapidShapeSet.getStagingPaint(paramAnonymousPaint);
      }

      public void endShape()
      {
        RapidShapeAtlasBuilder.this.stagingCanvas.restore();
        RapidShape[] arrayOfRapidShape = RapidShapeAtlasBuilder.this.shapes;
        int i = this.curShapeIndex;
        this.curShapeIndex = (i + 1);
        arrayOfRapidShape[i].traverse(RapidShapeAtlasBuilder.this, 0, 0);
      }

      public Canvas getCanvas()
      {
        return RapidShapeAtlasBuilder.this.getStagingCanvas();
      }
    });
    int i = 8 * (8 * this.atomCount);
    L.debug("build atomCount:" + this.atomCount + " memory usage:" + i);
    return new RapidShapeAtlas(Bitmap.createBitmap(this.atlasBitmap));
  }

  public Canvas getStagingCanvas()
  {
    return this.stagingCanvas;
  }

  public void visitBitmap(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 8)
      extractAtom(paramInt1, paramInt2, paramInt3);
    while (true)
    {
      return;
      int i = paramInt2 + paramInt1;
      int j = paramInt3 + paramInt1;
      while (paramInt3 < j)
      {
        for (int k = paramInt2; k < i; k += 8)
          extractAtom(paramInt1, k, paramInt3);
        paramInt3 += 8;
      }
    }
  }

  public void visitOpaque(int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void visitTransparent(int paramInt1, int paramInt2, int paramInt3)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.svg.jni.rapidshape.RapidShapeAtlasBuilder
 * JD-Core Version:    0.6.2
 */