package com.viber.svg.jni;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.os.Environment;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Stack;

public class BitmapPictureRenderer extends AndroidSvgRenderer
{
  private static final boolean CACHE_RASTERIZATION_INFO = false;
  private static final int PREPARE_FLAG_PRERASTERIZE = 1;
  private static final int RASTERIZATION_VERSION = 1;
  private static final int RESERVED_SEARCH_RECT_PIXELS = 4;
  private static final int RESERVED_STAGING_PIXELS = 8;
  protected static final String bitmapDumpPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/svg-dump";
  protected static final boolean debugSearchRect;
  protected static final boolean dumpBitmaps;
  Delegate curDelegate;
  protected float[] matrixData = { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  private int paddedPrepareViewportHeight;
  private int paddedPrepareViewportWidth;
  protected Matrix tmpMatrix = new Matrix();

  public BitmapPictureRenderer(int paramInt)
  {
    super(paramInt);
  }

  private PictureRasterizationInfoStorage createStorage()
  {
    return new BinaryPictureRasterizationInfoStorage(this.svgId, 1, this.prepareViewportWidth, this.prepareViewportHeight);
  }

  protected static void dumpBitmap(Bitmap paramBitmap, String paramString)
  {
    String str = bitmapDumpPath + "/" + paramString + ".png";
    try
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(str);
      try
      {
        paramBitmap.compress(Bitmap.CompressFormat.PNG, 80, localFileOutputStream);
        return;
      }
      finally
      {
        localFileOutputStream.close();
      }
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }

  protected void beginElement(double paramDouble)
  {
    this.curDelegate.beginElement(paramDouble);
  }

  protected void beginLayer()
  {
    this.curDelegate.beginLayer();
  }

  protected void beginMask()
  {
    this.curDelegate.beginMask();
  }

  protected void beginPicture()
  {
    this.curDelegate.beginPicture();
  }

  protected void beginPictures()
  {
    this.curDelegate.beginPictures();
  }

  protected void beginRender()
  {
    this.curDelegate.beginRender();
  }

  protected void concatMatrix(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
  {
    this.curDelegate.concatMatrix(paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6);
  }

  protected void curveTo(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
  {
    this.curDelegate.curveTo(paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6);
  }

  protected void endElement()
  {
    this.curDelegate.endElement();
  }

  protected void endLayer()
  {
    this.curDelegate.endLayer();
  }

  protected void endMask()
  {
    this.curDelegate.endMask();
  }

  protected void endPicture()
  {
    this.curDelegate.endPicture();
  }

  protected void endPictures()
  {
    this.curDelegate.endPictures();
  }

  protected void endRender()
  {
    this.curDelegate.endRender();
  }

  public int getPrepareFlags(String paramString)
  {
    super.getPrepareFlags(paramString);
    createStorage();
    if (0 == 0)
    {
      this.curDelegate = new CalculateBoundingBoxesStage(null);
      return 1;
    }
    this.curDelegate = new RasterizePicturesStage(null);
    return 0;
  }

  protected Delegate getRasterizationStage(PictureRasterizationInfo[] paramArrayOfPictureRasterizationInfo)
  {
    return new RasterizePicturesStage(paramArrayOfPictureRasterizationInfo);
  }

  protected void lineTo(double paramDouble1, double paramDouble2)
  {
    this.curDelegate.lineTo(paramDouble1, paramDouble2);
  }

  protected void moveTo(double paramDouble1, double paramDouble2)
  {
    this.curDelegate.moveTo(paramDouble1, paramDouble2);
  }

  protected void quadraticCurveTo(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    this.curDelegate.quadraticCurveTo(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
  }

  protected void renderEllipse(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    this.curDelegate.renderEllipse(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
  }

  protected void renderLine(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    this.curDelegate.renderLine(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
  }

  protected void renderPath()
  {
    this.curDelegate.renderPath();
  }

  protected void renderPicture(int paramInt)
  {
    this.curDelegate.renderPicture(paramInt);
  }

  protected void renderRect(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
  {
    this.curDelegate.renderRect(paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6);
  }

  public void setPrepareViewportSize(int paramInt1, int paramInt2)
  {
    super.setPrepareViewportSize(paramInt1, paramInt2);
    this.paddedPrepareViewportWidth = (16 + this.prepareViewportWidth);
    this.paddedPrepareViewportHeight = (16 + this.prepareViewportHeight);
  }

  protected void setStrokeWidth(double paramDouble)
  {
    this.curDelegate.setStrokeWidth(paramDouble);
  }

  private static class Bounds
  {
    private double bottom;
    private double left;
    private double right;
    private double top;

    Bounds()
    {
      reset();
    }

    private void reset()
    {
      this.left = 10000000000.0D;
      this.top = 10000000000.0D;
      this.right = -10000000000.0D;
      this.bottom = -10000000000.0D;
    }

    public void addPoint(double paramDouble1, double paramDouble2)
    {
      if (paramDouble1 < this.left)
        this.left = paramDouble1;
      if (paramDouble1 > this.right)
        this.right = paramDouble1;
      if (paramDouble2 < this.top)
        this.top = paramDouble2;
      if (paramDouble2 > this.bottom)
        this.bottom = paramDouble2;
    }

    public double height()
    {
      return this.bottom - this.top;
    }

    public void toRect(Rect paramRect)
    {
      paramRect.left = ((int)Math.floor(this.left));
      paramRect.top = ((int)Math.floor(this.top));
      paramRect.right = ((int)Math.ceil(this.right));
      paramRect.bottom = ((int)Math.ceil(this.bottom));
    }

    public double width()
    {
      return this.right - this.left;
    }
  }

  private class CalculateBoundingBoxesStage extends BitmapPictureRenderer.Delegate
  {
    private BitmapPictureRenderer.PictureStat curPictureStat;
    private ArrayList<BitmapPictureRenderer.PictureStat> pictureStats = new ArrayList();

    private CalculateBoundingBoxesStage()
    {
      super();
    }

    public void beginPicture()
    {
      this.curPictureStat = new BitmapPictureRenderer.PictureStat(null);
      this.pictureStats.add(this.curPictureStat);
    }

    public void curveTo(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
    {
      this.curPictureStat.origBounds.addPoint(paramDouble1, paramDouble2);
      this.curPictureStat.origBounds.addPoint(paramDouble3, paramDouble4);
      this.curPictureStat.origBounds.addPoint(paramDouble5, paramDouble6);
      this.curPictureStat.points.add(new BitmapPictureRenderer.Point(paramDouble1, paramDouble2));
      this.curPictureStat.points.add(new BitmapPictureRenderer.Point(paramDouble3, paramDouble4));
      this.curPictureStat.points.add(new BitmapPictureRenderer.Point(paramDouble5, paramDouble6));
    }

    public void endPictures()
    {
      BitmapPictureRenderer.this.curDelegate = new BitmapPictureRenderer.CollectTransformsStage(BitmapPictureRenderer.this, this.pictureStats);
    }

    public void lineTo(double paramDouble1, double paramDouble2)
    {
      this.curPictureStat.origBounds.addPoint(paramDouble1, paramDouble2);
      this.curPictureStat.points.add(new BitmapPictureRenderer.Point(paramDouble1, paramDouble2));
    }

    public void moveTo(double paramDouble1, double paramDouble2)
    {
      this.curPictureStat.origBounds.addPoint(paramDouble1, paramDouble2);
      this.curPictureStat.points.add(new BitmapPictureRenderer.Point(paramDouble1, paramDouble2));
    }

    public void quadraticCurveTo(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
    {
      this.curPictureStat.origBounds.addPoint(paramDouble1, paramDouble2);
      this.curPictureStat.origBounds.addPoint(paramDouble3, paramDouble4);
      this.curPictureStat.points.add(new BitmapPictureRenderer.Point(paramDouble1, paramDouble2));
      this.curPictureStat.points.add(new BitmapPictureRenderer.Point(paramDouble3, paramDouble4));
    }

    public void renderEllipse(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
    {
      double d1 = paramDouble1 - paramDouble3;
      double d2 = paramDouble2 - paramDouble4;
      double d3 = paramDouble1 + paramDouble3;
      double d4 = paramDouble2 + paramDouble4;
      this.curPictureStat.origBounds.addPoint(d1, d2);
      this.curPictureStat.origBounds.addPoint(d3, d4);
      this.curPictureStat.points.add(new BitmapPictureRenderer.Point(d1, d2));
      this.curPictureStat.points.add(new BitmapPictureRenderer.Point(d3, d4));
    }

    public void renderLine(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
    {
      this.curPictureStat.origBounds.addPoint(paramDouble1, paramDouble2);
      this.curPictureStat.origBounds.addPoint(paramDouble3, paramDouble4);
      this.curPictureStat.points.add(new BitmapPictureRenderer.Point(paramDouble1, paramDouble2));
      this.curPictureStat.points.add(new BitmapPictureRenderer.Point(paramDouble3, paramDouble4));
    }

    public void renderPath()
    {
    }

    public void renderRect(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
    {
      double d1 = paramDouble1 + paramDouble3;
      double d2 = paramDouble2 + paramDouble4;
      this.curPictureStat.origBounds.addPoint(paramDouble1, paramDouble2);
      this.curPictureStat.origBounds.addPoint(d1, d2);
      this.curPictureStat.points.add(new BitmapPictureRenderer.Point(paramDouble1, paramDouble2));
      this.curPictureStat.points.add(new BitmapPictureRenderer.Point(d1, d2));
    }

    void setStrokeWidth(double paramDouble)
    {
      if (paramDouble > this.curPictureStat.maxStrokeWidth)
        this.curPictureStat.maxStrokeWidth = paramDouble;
    }
  }

  private class CollectTransformsStage extends BitmapPictureRenderer.Delegate
  {
    private Matrix curMatrix = new Matrix();
    private Stack<Matrix> matrixStack = new Stack();
    private ArrayList<BitmapPictureRenderer.PictureStat> pictureStats;

    public CollectTransformsStage()
    {
      super();
      Object localObject;
      this.pictureStats = localObject;
    }

    private void calcTransformedBounds(BitmapPictureRenderer.Bounds paramBounds1, Matrix paramMatrix, BitmapPictureRenderer.Bounds paramBounds2)
    {
      paramMatrix.getValues(BitmapPictureRenderer.this.matrixData);
      paramBounds2.reset();
      paramBounds2.addPoint(transformX(paramBounds1.left, paramBounds1.top), transformY(paramBounds1.left, paramBounds1.top));
      paramBounds2.addPoint(transformX(paramBounds1.right, paramBounds1.top), transformY(paramBounds1.right, paramBounds1.top));
      paramBounds2.addPoint(transformX(paramBounds1.right, paramBounds1.bottom), transformY(paramBounds1.right, paramBounds1.bottom));
      paramBounds2.addPoint(transformX(paramBounds1.left, paramBounds1.bottom), transformY(paramBounds1.left, paramBounds1.bottom));
    }

    private double calcTransformedDiagonal(BitmapPictureRenderer.Bounds paramBounds, Matrix paramMatrix)
    {
      paramMatrix.getValues(BitmapPictureRenderer.this.matrixData);
      double d1 = transformX(paramBounds.left, paramBounds.top);
      double d2 = transformY(paramBounds.left, paramBounds.top);
      double d3 = transformX(paramBounds.right, paramBounds.bottom);
      double d4 = transformY(paramBounds.right, paramBounds.bottom);
      double d5 = d3 - d1;
      double d6 = d4 - d2;
      return Math.sqrt(d5 * d5 + d6 * d6);
    }

    private double calcTransformedStrokeWidth(double paramDouble, Matrix paramMatrix)
    {
      paramMatrix.getValues(BitmapPictureRenderer.this.matrixData);
      double d1 = transformX(0.0D, 0.0D);
      double d2 = transformY(0.0D, 0.0D);
      double d3 = transformX(paramDouble, 0.0D);
      double d4 = transformY(paramDouble, 0.0D);
      double d5 = d1 - d3;
      double d6 = d2 - d4;
      return Math.sqrt(d5 * d5 + d6 * d6);
    }

    private void growBounds(BitmapPictureRenderer.Bounds paramBounds, double paramDouble)
    {
      BitmapPictureRenderer.Bounds.access$1802(paramBounds, paramBounds.left - paramDouble);
      BitmapPictureRenderer.Bounds.access$1902(paramBounds, paramDouble + paramBounds.right);
      BitmapPictureRenderer.Bounds.access$2002(paramBounds, paramBounds.top - paramDouble);
      BitmapPictureRenderer.Bounds.access$2102(paramBounds, paramDouble + paramBounds.bottom);
    }

    private void growRect(Rect paramRect, int paramInt)
    {
      paramRect.left -= paramInt;
      if (paramRect.left < 0)
        paramRect.left = 0;
      paramRect.right = (paramInt + paramRect.right);
      if (paramRect.right >= BitmapPictureRenderer.this.paddedPrepareViewportWidth)
        paramRect.right = (-1 + BitmapPictureRenderer.this.paddedPrepareViewportWidth);
      paramRect.top -= paramInt;
      if (paramRect.top < 0)
        paramRect.top = 0;
      paramRect.bottom = (paramInt + paramRect.bottom);
      if (paramRect.bottom >= BitmapPictureRenderer.this.paddedPrepareViewportHeight)
        paramRect.bottom = (-1 + BitmapPictureRenderer.this.paddedPrepareViewportHeight);
    }

    private void rotateForOptimalBoundingBox(BitmapPictureRenderer.Point[] paramArrayOfPoint, Matrix paramMatrix)
    {
      double d1 = 0.0D;
      double d2 = (90.0D - d1) / 30;
      Matrix localMatrix = new Matrix();
      BitmapPictureRenderer.Bounds localBounds = new BitmapPictureRenderer.Bounds();
      double d3 = 1.7976931348623157E+308D;
      double d4 = 0.0D;
      int i = 0;
      double d7;
      double d6;
      if (i < 30)
      {
        localMatrix.set(paramMatrix);
        localMatrix.preRotate((float)d1);
        localMatrix.getValues(BitmapPictureRenderer.this.matrixData);
        localBounds.reset();
        for (int j = 0; j < paramArrayOfPoint.length; j++)
        {
          BitmapPictureRenderer.Point localPoint = paramArrayOfPoint[j];
          localBounds.addPoint(transformX(localPoint.x, localPoint.y), transformY(localPoint.x, localPoint.y));
        }
        double d5 = localBounds.width() * localBounds.height();
        if (d5 >= d3)
          break label195;
        d7 = d5;
        d6 = d1;
      }
      while (true)
      {
        double d8 = d1 + d2;
        i++;
        d1 = d8;
        d3 = d7;
        d4 = d6;
        break;
        paramMatrix.preRotate((float)d4);
        return;
        label195: d6 = d4;
        d7 = d3;
      }
    }

    private double transformX(double paramDouble1, double paramDouble2)
    {
      return paramDouble1 * BitmapPictureRenderer.this.matrixData[0] + paramDouble2 * BitmapPictureRenderer.this.matrixData[1] + BitmapPictureRenderer.this.matrixData[2];
    }

    private double transformY(double paramDouble1, double paramDouble2)
    {
      return paramDouble1 * BitmapPictureRenderer.this.matrixData[3] + paramDouble2 * BitmapPictureRenderer.this.matrixData[4] + BitmapPictureRenderer.this.matrixData[5];
    }

    void beginElement(double paramDouble)
    {
      super.beginElement(paramDouble);
      this.matrixStack.push(this.curMatrix);
      this.curMatrix = new Matrix(this.curMatrix);
    }

    void beginLayer()
    {
    }

    void beginMask()
    {
    }

    void concatMatrix(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
    {
      BitmapPictureRenderer.this.matrixData[0] = ((float)paramDouble1);
      BitmapPictureRenderer.this.matrixData[1] = ((float)paramDouble3);
      BitmapPictureRenderer.this.matrixData[2] = ((float)paramDouble5);
      BitmapPictureRenderer.this.matrixData[3] = ((float)paramDouble2);
      BitmapPictureRenderer.this.matrixData[4] = ((float)paramDouble4);
      BitmapPictureRenderer.this.matrixData[5] = ((float)paramDouble6);
      BitmapPictureRenderer.this.tmpMatrix.setValues(BitmapPictureRenderer.this.matrixData);
      this.curMatrix.preConcat(BitmapPictureRenderer.this.tmpMatrix);
    }

    void endElement()
    {
      this.curMatrix = ((Matrix)this.matrixStack.pop());
      super.endElement();
    }

    void endLayer()
    {
    }

    void endMask()
    {
    }

    void endPictures()
    {
      BitmapPictureRenderer.Bounds localBounds = new BitmapPictureRenderer.Bounds();
      int i = 0;
      BitmapPictureRenderer.PictureStat localPictureStat;
      Object localObject1;
      double d1;
      int j;
      label68: Object localObject2;
      double d10;
      while (true)
        if (i < this.pictureStats.size())
        {
          localPictureStat = (BitmapPictureRenderer.PictureStat)this.pictureStats.get(i);
          if (localPictureStat.transformMatrices.size() == 0)
          {
            this.pictureStats.set(i, null);
            i++;
          }
          else
          {
            localObject1 = null;
            d1 = 0.0D;
            j = 0;
            if (j < localPictureStat.transformMatrices.size())
            {
              localObject2 = (Matrix)localPictureStat.transformMatrices.get(j);
              d10 = calcTransformedDiagonal(localPictureStat.origBounds, (Matrix)localObject2);
              if (d10 <= d1)
                break label528;
            }
          }
        }
      while (true)
      {
        j++;
        d1 = d10;
        localObject1 = localObject2;
        break label68;
        localPictureStat.selectedMatrix = localObject1;
        if ((0x20000 & BitmapPictureRenderer.this.flags) != 0)
          rotateForOptimalBoundingBox((BitmapPictureRenderer.Point[])localPictureStat.points.toArray(new BitmapPictureRenderer.Point[localPictureStat.points.size()]), localObject1);
        calcTransformedBounds(localPictureStat.origBounds, localObject1, localBounds);
        if (localPictureStat.maxStrokeWidth > 0.0D)
        {
          double d9 = calcTransformedStrokeWidth(localPictureStat.maxStrokeWidth, localObject1);
          growBounds(localBounds, d9 / 2.0D);
          growBounds(localPictureStat.origBounds, d9 / 2.0D);
        }
        double d2 = 1.0D;
        double d3 = 1.0D;
        if (localBounds.width() > BitmapPictureRenderer.this.prepareViewportWidth)
          d2 = BitmapPictureRenderer.this.prepareViewportWidth / localBounds.width();
        if (localBounds.height() > BitmapPictureRenderer.this.prepareViewportHeight)
          d3 = BitmapPictureRenderer.this.prepareViewportHeight / localBounds.height();
        double d4 = Math.min(d2, d3);
        if (d4 < 1.0D)
        {
          localPictureStat.selectedMatrix.preScale((float)d4, (float)d4);
          calcTransformedBounds(localPictureStat.origBounds, localObject1, localBounds);
        }
        double d5 = (localBounds.left + localBounds.right) / 2.0D;
        double d6 = (localBounds.top + localBounds.bottom) / 2.0D;
        double d7 = BitmapPictureRenderer.this.paddedPrepareViewportWidth / 2.0D;
        double d8 = BitmapPictureRenderer.this.paddedPrepareViewportHeight / 2.0D;
        localPictureStat.stageCenterTranslateX = (d7 - d5);
        localPictureStat.stageCenterTranslateY = (d8 - d6);
        BitmapPictureRenderer.Bounds.access$1802(localBounds, localBounds.left + localPictureStat.stageCenterTranslateX);
        BitmapPictureRenderer.Bounds.access$2002(localBounds, localBounds.top + localPictureStat.stageCenterTranslateY);
        BitmapPictureRenderer.Bounds.access$1902(localBounds, localBounds.right + localPictureStat.stageCenterTranslateX);
        BitmapPictureRenderer.Bounds.access$2102(localBounds, localBounds.bottom + localPictureStat.stageCenterTranslateY);
        localBounds.toRect(localPictureStat.searchRect);
        growRect(localPictureStat.searchRect, 4);
        break;
        BitmapPictureRenderer.this.curDelegate = new BitmapPictureRenderer.PreRasterizePicturesStage(BitmapPictureRenderer.this, this.pictureStats, BitmapPictureRenderer.this.paddedPrepareViewportWidth, BitmapPictureRenderer.this.paddedPrepareViewportHeight);
        return;
        label528: d10 = d1;
        localObject2 = localObject1;
      }
    }

    void renderPath()
    {
    }

    void renderPicture(int paramInt)
    {
      ((BitmapPictureRenderer.PictureStat)this.pictureStats.get(paramInt)).transformMatrices.add(new Matrix(this.curMatrix));
    }
  }

  protected class Delegate
  {
    protected Delegate()
    {
    }

    void beginElement(double paramDouble)
    {
      BitmapPictureRenderer.this.beginElement(paramDouble);
    }

    void beginLayer()
    {
      BitmapPictureRenderer.this.beginLayer();
    }

    void beginMask()
    {
      BitmapPictureRenderer.this.beginMask();
    }

    void beginPicture()
    {
    }

    void beginPictures()
    {
    }

    void beginRender()
    {
    }

    void concatMatrix(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
    {
      BitmapPictureRenderer.this.concatMatrix(paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6);
    }

    void curveTo(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
    {
      BitmapPictureRenderer.this.curveTo(paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6);
    }

    void endElement()
    {
      BitmapPictureRenderer.this.endElement();
    }

    void endLayer()
    {
      BitmapPictureRenderer.this.endLayer();
    }

    void endMask()
    {
      BitmapPictureRenderer.this.endMask();
    }

    void endPicture()
    {
    }

    void endPictures()
    {
    }

    void endRender()
    {
    }

    void lineTo(double paramDouble1, double paramDouble2)
    {
      BitmapPictureRenderer.this.lineTo(paramDouble1, paramDouble2);
    }

    void moveTo(double paramDouble1, double paramDouble2)
    {
      BitmapPictureRenderer.this.moveTo(paramDouble1, paramDouble2);
    }

    void quadraticCurveTo(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
    {
      BitmapPictureRenderer.this.quadraticCurveTo(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
    }

    void renderEllipse(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
    {
      BitmapPictureRenderer.this.renderEllipse(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
    }

    void renderLine(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
    {
      BitmapPictureRenderer.this.renderLine(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
    }

    void renderPath()
    {
      BitmapPictureRenderer.this.renderPath();
    }

    void renderPicture(int paramInt)
    {
    }

    void renderRect(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
    {
      BitmapPictureRenderer.this.renderRect(paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6);
    }

    void setStrokeWidth(double paramDouble)
    {
      BitmapPictureRenderer.this.setStrokeWidth(paramDouble);
    }
  }

  public class FinalStage extends BitmapPictureRenderer.Delegate
  {
    private Matrix curMatrix = new Matrix();
    private Stack<Matrix> matrixStack = new Stack();
    private Paint paint;
    private BitmapPictureRenderer.Picture[] pictures;
    private long renderBitmapNanos;
    private int renderCountBitmaps;
    private int renderCountPixels;
    private long renderStartMillis;

    FinalStage(BitmapPictureRenderer.Picture[] arg2)
    {
      super();
      Object localObject;
      this.pictures = localObject;
      this.paint = new Paint(7);
    }

    void beginElement(double paramDouble)
    {
      super.beginElement(paramDouble);
      this.matrixStack.push(this.curMatrix);
      this.curMatrix = new Matrix(this.curMatrix);
    }

    void beginRender()
    {
      this.renderStartMillis = System.currentTimeMillis();
      this.renderBitmapNanos = 0L;
      this.renderCountBitmaps = 0;
      this.renderCountPixels = 0;
    }

    void concatMatrix(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
    {
      BitmapPictureRenderer.this.matrixData[0] = ((float)paramDouble1);
      BitmapPictureRenderer.this.matrixData[1] = ((float)paramDouble3);
      BitmapPictureRenderer.this.matrixData[2] = ((float)paramDouble5);
      BitmapPictureRenderer.this.matrixData[3] = ((float)paramDouble2);
      BitmapPictureRenderer.this.matrixData[4] = ((float)paramDouble4);
      BitmapPictureRenderer.this.matrixData[5] = ((float)paramDouble6);
      BitmapPictureRenderer.this.tmpMatrix.setValues(BitmapPictureRenderer.this.matrixData);
      this.curMatrix.preConcat(BitmapPictureRenderer.this.tmpMatrix);
    }

    void endElement()
    {
      super.endElement();
      this.curMatrix = ((Matrix)this.matrixStack.pop());
    }

    void endRender()
    {
    }

    void renderPicture(int paramInt)
    {
      BitmapPictureRenderer.Picture localPicture = this.pictures[paramInt];
      if (localPicture != null)
      {
        BitmapPictureRenderer.this.canvas.save();
        BitmapPictureRenderer.this.canvas.concat(this.curMatrix);
        BitmapPictureRenderer.this.canvas.concat(localPicture.matrix);
        long l = System.nanoTime();
        BitmapPictureRenderer.this.canvas.drawBitmap(localPicture.bitmap, 0.0F, 0.0F, this.paint);
        this.renderBitmapNanos = (System.nanoTime() - l + this.renderBitmapNanos);
        BitmapPictureRenderer.this.canvas.restore();
        this.renderCountBitmaps = (1 + this.renderCountBitmaps);
        this.renderCountPixels += localPicture.bitmap.getWidth() * localPicture.bitmap.getHeight();
      }
    }
  }

  private static class Picture
  {
    Bitmap bitmap;
    Matrix matrix;

    Picture(Bitmap paramBitmap, Matrix paramMatrix)
    {
      this.bitmap = paramBitmap;
      this.matrix = paramMatrix;
    }
  }

  public static class PictureRasterizationInfo
  {
    int bitmapHeight;
    int bitmapWidth;
    Matrix rasterizeMatrix;
    Matrix renderMatrix;

    PictureRasterizationInfo(int paramInt1, int paramInt2, Matrix paramMatrix1, Matrix paramMatrix2)
    {
      this.bitmapWidth = paramInt1;
      this.bitmapHeight = paramInt2;
      this.rasterizeMatrix = paramMatrix1;
      this.renderMatrix = paramMatrix2;
    }
  }

  private static class PictureStat
  {
    double maxStrokeWidth;
    BitmapPictureRenderer.Bounds origBounds = new BitmapPictureRenderer.Bounds();
    ArrayList<BitmapPictureRenderer.Point> points = new ArrayList();
    Rect searchRect = new Rect();
    Matrix selectedMatrix;
    double stageCenterTranslateX;
    double stageCenterTranslateY;
    ArrayList<Matrix> transformMatrices = new ArrayList();
  }

  private static class Point
  {
    public double x;
    public double y;

    public Point(double paramDouble1, double paramDouble2)
    {
      this.x = paramDouble1;
      this.y = paramDouble2;
    }
  }

  class PreRasterizePicturesStage extends BitmapPictureRenderer.Delegate
  {
    int curPictureIndex = 0;
    private Canvas origCanvas;
    private BitmapPictureRenderer.PictureRasterizationInfo[] pictureRasterizationInfos;
    private ArrayList<BitmapPictureRenderer.PictureStat> pictureStats;
    Rect stageRect = new Rect();
    Staging staging;
    long start;
    int totalBytes;
    int totalPixels;
    int totalVisiblePixels;

    public PreRasterizePicturesStage(int paramInt1, int arg3)
    {
      super();
      this.pictureStats = paramInt1;
      int i;
      int j;
      this.staging = new Staging(i, j);
      this.pictureRasterizationInfos = new BitmapPictureRenderer.PictureRasterizationInfo[paramInt1.size()];
    }

    void beginLayer()
    {
    }

    void beginMask()
    {
    }

    void beginPicture()
    {
      BitmapPictureRenderer.PictureStat localPictureStat = (BitmapPictureRenderer.PictureStat)this.pictureStats.get(this.curPictureIndex);
      if (localPictureStat != null)
      {
        BitmapPictureRenderer.this.canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        BitmapPictureRenderer.this.canvas.save();
        BitmapPictureRenderer.this.canvas.translate((float)localPictureStat.stageCenterTranslateX, (float)localPictureStat.stageCenterTranslateY);
        localPictureStat.selectedMatrix.getValues(BitmapPictureRenderer.this.matrixData);
        BitmapPictureRenderer.this.canvas.concat(localPictureStat.selectedMatrix);
      }
    }

    void beginPictures()
    {
      this.origCanvas = BitmapPictureRenderer.this.canvas;
      BitmapPictureRenderer.this.canvas = new Canvas(this.staging.getBitmap());
      this.start = System.currentTimeMillis();
    }

    void endLayer()
    {
    }

    void endMask()
    {
    }

    void endPicture()
    {
      BitmapPictureRenderer.PictureStat localPictureStat1 = (BitmapPictureRenderer.PictureStat)this.pictureStats.get(this.curPictureIndex);
      if (localPictureStat1 != null)
        BitmapPictureRenderer.this.canvas.restore();
      try
      {
        int k = this.staging.calculateBounds(localPictureStat1.searchRect, this.stageRect);
        i = k;
        Rect localRect1 = this.stageRect;
        localRect1.right = (1 + localRect1.right);
        Rect localRect2 = this.stageRect;
        localRect2.bottom = (1 + localRect2.bottom);
        int j = this.stageRect.width() * this.stageRect.height();
        this.totalVisiblePixels = (i + this.totalVisiblePixels);
        this.totalPixels = (j + this.totalPixels);
        if (i > 0)
        {
          this.totalBytes = (4 * (this.stageRect.width() * this.stageRect.height()) + this.totalBytes);
          BitmapPictureRenderer.PictureStat localPictureStat2 = (BitmapPictureRenderer.PictureStat)this.pictureStats.get(this.curPictureIndex);
          Matrix localMatrix1 = new Matrix();
          localMatrix1.preTranslate((float)localPictureStat2.stageCenterTranslateX - this.stageRect.left, (float)localPictureStat2.stageCenterTranslateY - this.stageRect.top);
          localMatrix1.preConcat(localPictureStat2.selectedMatrix);
          Matrix localMatrix2 = new Matrix();
          localMatrix1.invert(localMatrix2);
          this.pictureRasterizationInfos[this.curPictureIndex] = new BitmapPictureRenderer.PictureRasterizationInfo(this.stageRect.width(), this.stageRect.height(), localMatrix1, localMatrix2);
        }
        this.curPictureIndex = (1 + this.curPictureIndex);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        while (true)
        {
          BitmapPictureRenderer.this.L.debug("calculateBounds error: " + localRuntimeException);
          BitmapPictureRenderer.this.L.debug("searchRect:" + localPictureStat1.searchRect + ", st.width:" + this.staging.getBitmap().getWidth() + ", st.height:" + this.staging.getBitmap().getHeight());
          int i = 0;
        }
      }
    }

    void endPictures()
    {
      BitmapPictureRenderer.this.canvas = this.origCanvas;
      long l = System.currentTimeMillis() - this.start;
      BitmapPictureRenderer.this.L.debug("Total bytes after pre-rasterization: " + this.totalBytes + ", computed in " + l + "ms");
      BitmapPictureRenderer.this.curDelegate = BitmapPictureRenderer.this.getRasterizationStage(this.pictureRasterizationInfos);
    }
  }

  class RasterizePicturesStage extends BitmapPictureRenderer.Delegate
  {
    int curPictureIndex = 0;
    private Canvas dummyCanvas = new Canvas(Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888));
    private Canvas origCanvas;
    private BitmapPictureRenderer.PictureRasterizationInfo[] pictureRasterizationInfos;
    private BitmapPictureRenderer.Picture[] pictures;
    long start;
    int totalBytes;
    int totalPixels;

    public RasterizePicturesStage(BitmapPictureRenderer.PictureRasterizationInfo[] arg2)
    {
      super();
      Object localObject;
      this.pictureRasterizationInfos = localObject;
      this.pictures = new BitmapPictureRenderer.Picture[localObject.length];
    }

    void beginPicture()
    {
      BitmapPictureRenderer.PictureRasterizationInfo localPictureRasterizationInfo = this.pictureRasterizationInfos[this.curPictureIndex];
      this.origCanvas = BitmapPictureRenderer.this.canvas;
      if (localPictureRasterizationInfo != null)
      {
        Bitmap localBitmap = Bitmap.createBitmap(localPictureRasterizationInfo.bitmapWidth, localPictureRasterizationInfo.bitmapHeight, Bitmap.Config.ARGB_8888);
        BitmapPictureRenderer.Picture localPicture = new BitmapPictureRenderer.Picture(localBitmap, localPictureRasterizationInfo.renderMatrix);
        this.pictures[this.curPictureIndex] = localPicture;
        BitmapPictureRenderer.this.canvas = new Canvas(localBitmap);
        BitmapPictureRenderer.this.canvas.concat(localPictureRasterizationInfo.rasterizeMatrix);
        return;
      }
      BitmapPictureRenderer.this.canvas = this.dummyCanvas;
    }

    void beginPictures()
    {
      this.start = System.currentTimeMillis();
    }

    void endPicture()
    {
      if (this.pictureRasterizationInfos[this.curPictureIndex] != null)
      {
        BitmapPictureRenderer.Picture localPicture = this.pictures[this.curPictureIndex];
        this.totalBytes = (4 * (localPicture.bitmap.getWidth() * localPicture.bitmap.getHeight()) + this.totalBytes);
      }
      BitmapPictureRenderer.this.canvas = this.origCanvas;
      this.curPictureIndex = (1 + this.curPictureIndex);
    }

    void endPictures()
    {
      long l = System.currentTimeMillis() - this.start;
      BitmapPictureRenderer.this.L.debug("Total bytes after rasterization: " + this.totalBytes + ", rasterized in " + l + "ms");
      BitmapPictureRenderer.this.curDelegate = new BitmapPictureRenderer.FinalStage(BitmapPictureRenderer.this, this.pictures);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.svg.jni.BitmapPictureRenderer
 * JD-Core Version:    0.6.2
 */