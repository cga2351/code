package com.viber.svg.jni.rapidshape;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.util.SparseIntArray;
import com.viber.svg.jni.Logger;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class RapidShapeSetCompiler
  implements RapidShapeStagingDrawInterface
{
  private static Logger L = Logger.create(RapidShapeSetCompiler.class.getSimpleName());
  private RapidShapeOpsBuilder builder;
  private int curShapeAtlasStartIndex = 0;
  private int curShapeOpBufferStartIndex = 0;
  private ArrayList<byte[]> opBuffers = new ArrayList();
  private int[] pixelTransferBuffer;
  private Rect rect = new Rect();
  private ArrayList<RapidShapeDescriptor> shapeDescriptors = new ArrayList();
  private ArrayList<ShapeStat> shapeStats = new ArrayList();
  private Bitmap stagingBitmap;
  private Canvas stagingCanvas;
  private int stagingDimension;
  private int stagingOffsetX;
  private int stagingOffsetY;
  private byte[] stagingOpBuffer;
  private byte[] stagingPixels;
  private RapidShapeTraverser traverser;

  public RapidShapeSetCompiler(int paramInt)
  {
    this.stagingDimension = paramInt;
    this.stagingOffsetX = (paramInt >> 1);
    this.stagingOffsetY = (paramInt >> 1);
    this.stagingBitmap = Bitmap.createBitmap(paramInt, paramInt, Bitmap.Config.ALPHA_8);
    this.stagingCanvas = new Canvas(this.stagingBitmap);
    this.stagingPixels = new byte[paramInt * paramInt];
    int i = paramInt / 8;
    this.stagingOpBuffer = new byte[2 * (i * i / 4)];
    this.pixelTransferBuffer = new int[paramInt * 8];
    this.traverser = new RapidShapeTraverser(this.stagingOpBuffer, 0);
    this.builder = new RapidShapeOpsBuilder(this.stagingPixels, paramInt, this.stagingOpBuffer);
  }

  private void adjustRect(Rect paramRect)
  {
    int i = 8;
    int j = nextPowerOfTwo(paramRect.width());
    int k = nextPowerOfTwo(paramRect.height());
    if (j > k)
      if (j >= i)
        break label152;
    while (true)
    {
      int m = i + paramRect.left;
      int n = i + paramRect.top;
      int i1 = m - this.stagingBitmap.getWidth();
      if (i1 > 0)
        paramRect.left -= i1;
      for (int i2 = m - i1; ; i2 = m)
      {
        paramRect.right = i2;
        int i3 = n - this.stagingBitmap.getHeight();
        if (i3 > 0)
          paramRect.top -= i3;
        for (int i4 = n - i3; ; i4 = n)
        {
          paramRect.bottom = i4;
          return;
          j = k;
          break;
        }
      }
      label152: i = j;
    }
  }

  private int calculateShapeBounds(Rect paramRect)
  {
    int i = 2147483647;
    int j = -2147483648;
    int k = this.stagingBitmap.getWidth();
    int m = this.stagingBitmap.getHeight();
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = j;
    int i4 = i;
    while (n < m)
    {
      int i5 = i1;
      int i6 = i2;
      int i7 = j;
      int i8 = i;
      int i9 = i3;
      int i10 = i4;
      int i11 = 0;
      while (i11 < k)
      {
        byte[] arrayOfByte = this.stagingPixels;
        int i12 = i5 + 1;
        if (arrayOfByte[i5] != 0)
        {
          i6++;
          if (i11 < i10)
            i10 = i11;
          if (i11 > i9)
            i9 = i11;
          if (n < i8)
            i8 = n;
          if (n > i7)
            i7 = n;
        }
        i11++;
        i5 = i12;
      }
      n++;
      i4 = i10;
      i3 = i9;
      i = i8;
      j = i7;
      i2 = i6;
      i1 = i5;
    }
    paramRect.left = i4;
    paramRect.top = i;
    paramRect.right = i3;
    paramRect.bottom = j;
    return i2;
  }

  private ShapeStat collectStats(Rect paramRect, int paramInt1, int paramInt2)
  {
    ShapeStat localShapeStat = new ShapeStat(paramInt1, paramInt2);
    localShapeStat.traverse(this.traverser, paramRect);
    L.debug("collectStats stats: " + localShapeStat);
    return localShapeStat;
  }

  private String collectTotalStats()
  {
    Iterator localIterator = this.shapeStats.iterator();
    int i = 0;
    int j = 0;
    int k = 0;
    int m = 0;
    while (localIterator.hasNext())
    {
      ShapeStat localShapeStat = (ShapeStat)localIterator.next();
      m += localShapeStat.vertexMemAtoms;
      k += localShapeStat.vertexMemOpaque;
      j += localShapeStat.memAtlas;
      i += localShapeStat.memTotal;
    }
    return "vmemA:" + m + ", vmemO:" + k + ", memA:" + j + ", memTotal:" + i;
  }

  private void dumpBitmap(Bitmap paramBitmap, String paramString)
  {
    try
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(paramString);
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

  private void getPixels(Bitmap paramBitmap, byte[] paramArrayOfByte, int[] paramArrayOfInt)
  {
    int i = paramBitmap.getWidth();
    Bitmap localBitmap = paramBitmap.copy(Bitmap.Config.ARGB_8888, false);
    int j = paramArrayOfInt.length;
    int k = j / this.stagingDimension;
    int m = 0;
    int i2;
    for (int n = 0; m < i; n = i2)
    {
      localBitmap.getPixels(paramArrayOfInt, 0, i, 0, m, i, k);
      int i1 = 0;
      int i4;
      for (i2 = n; i1 < j; i2 = i4)
      {
        int i3 = (0xFF000000 & paramArrayOfInt[i1]) >>> 24;
        i4 = i2 + 1;
        paramArrayOfByte[i2] = ((byte)i3);
        i1++;
      }
      m += k;
    }
  }

  private int nextPowerOfTwo(int paramInt)
  {
    int i = paramInt - 1;
    int j = i | i >> 1;
    int k = j | j >> 2;
    int m = k | k >> 4;
    int n = m | m >> 8;
    return 1 + (n | n >> 16);
  }

  public Paint beginShape(Paint paramPaint)
  {
    this.stagingCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    this.stagingCanvas.save();
    this.stagingCanvas.translate(this.stagingOffsetX, this.stagingOffsetY);
    return RapidShapeSet.getStagingPaint(paramPaint);
  }

  public RapidShapeSetDescriptor compile(RapidShapeStagingDrawDelegate paramRapidShapeStagingDrawDelegate)
  {
    paramRapidShapeStagingDrawDelegate.drawShapesForStaging(this);
    L.debug("================== total mem stats =================");
    L.debug("=========== " + collectTotalStats());
    int i = this.curShapeAtlasStartIndex / 128;
    if (this.curShapeAtlasStartIndex % 128 > 0)
      i++;
    int j = i * 8;
    int k = 0;
    int m = 0;
    while (k < this.opBuffers.size())
    {
      m += ((byte[])this.opBuffers.get(k)).length;
      k++;
    }
    byte[] arrayOfByte1 = new byte[m];
    int n = 0;
    int i1 = 0;
    while (n < this.opBuffers.size())
    {
      byte[] arrayOfByte2 = (byte[])this.opBuffers.get(n);
      this.opBuffers.set(n, null);
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i1, arrayOfByte2.length);
      i1 += arrayOfByte2.length;
      n++;
    }
    return new RapidShapeSetDescriptor(1024, j, (RapidShapeDescriptor[])this.shapeDescriptors.toArray(new RapidShapeDescriptor[this.shapeDescriptors.size()]), arrayOfByte1);
  }

  public void endShape()
  {
    this.stagingCanvas.restore();
    getPixels(this.stagingBitmap, this.stagingPixels, this.pixelTransferBuffer);
    calculateShapeBounds(this.rect);
    int i = this.rect.width();
    int j = this.rect.height();
    if (this.rect.isEmpty());
    adjustRect(this.rect);
    int k = this.rect.left - this.stagingOffsetX;
    int m = this.rect.top - this.stagingOffsetY;
    int n = this.builder.build(this.rect.left, this.rect.top, this.rect.width());
    ShapeStat localShapeStat = collectStats(this.rect, i, j);
    this.shapeStats.add(localShapeStat);
    RapidShapeDescriptor localRapidShapeDescriptor = new RapidShapeDescriptor(this.rect.width(), this.curShapeOpBufferStartIndex, this.curShapeAtlasStartIndex, k, m);
    this.curShapeOpBufferStartIndex = (n + this.curShapeOpBufferStartIndex);
    this.curShapeAtlasStartIndex += localShapeStat.atomCount;
    byte[] arrayOfByte = Arrays.copyOf(this.stagingOpBuffer, n);
    this.shapeDescriptors.add(localRapidShapeDescriptor);
    this.opBuffers.add(arrayOfByte);
  }

  public Canvas getCanvas()
  {
    return this.stagingCanvas;
  }

  private static class ShapeStat
    implements RapidShapeTraverser.Visitor
  {
    int atomCount;
    SparseIntArray bitmapCountsPerSize = new SparseIntArray();
    int bytesPerAtomIndex;
    int bytesPerOpaqueIndex;
    int bytesPerVertexCoord;
    int memAtlas;
    int memTotal;
    SparseIntArray opaqueCountsPerSize = new SparseIntArray();
    int opsBlockCount;
    int shapeHeight;
    int shapeWidth;
    SparseIntArray transparentCountsPerSize = new SparseIntArray();
    int vertexMemAtoms;
    int vertexMemOpaque;

    public ShapeStat(int paramInt1, int paramInt2)
    {
      this.shapeWidth = paramInt1;
      this.shapeHeight = paramInt2;
    }

    private int bytesPerUnit(int paramInt)
    {
      if (paramInt >= 65536)
        return 4;
      if (paramInt >= 256)
        return 2;
      return 1;
    }

    private void calcMem()
    {
      this.bytesPerVertexCoord = bytesPerUnit(Math.max(this.shapeWidth, this.shapeHeight));
      this.bytesPerAtomIndex = bytesPerUnit(6 * this.atomCount);
      int i = 6 * getTotalCount(this.opaqueCountsPerSize);
      this.bytesPerOpaqueIndex = bytesPerUnit(i);
      int j = 16 + 8 * this.bytesPerVertexCoord + 6 * this.bytesPerAtomIndex;
      int k = 8 * this.bytesPerVertexCoord + 6 * this.bytesPerOpaqueIndex;
      this.vertexMemAtoms = (j * this.atomCount);
      this.vertexMemOpaque = (i * k);
      this.memAtlas = (8 * (8 * this.atomCount));
      this.memTotal = (this.vertexMemAtoms + this.vertexMemOpaque + this.memAtlas);
    }

    private int getTotalCount(SparseIntArray paramSparseIntArray)
    {
      int i = 0;
      int j = 0;
      while (i < paramSparseIntArray.size())
      {
        j += paramSparseIntArray.get(paramSparseIntArray.keyAt(i));
        i++;
      }
      return j;
    }

    private void stringifyCounts(SparseIntArray paramSparseIntArray, StringBuilder paramStringBuilder)
    {
      for (int i = 0; i < paramSparseIntArray.size(); i++)
      {
        if (i > 0)
          paramStringBuilder.append(',');
        int j = paramSparseIntArray.keyAt(i);
        int k = paramSparseIntArray.get(j);
        paramStringBuilder.append(j).append(':').append(k);
      }
    }

    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append('{');
      localStringBuilder.append("ob:").append(this.opsBlockCount);
      localStringBuilder.append(", ac:").append(this.atomCount);
      localStringBuilder.append(", T:{");
      stringifyCounts(this.transparentCountsPerSize, localStringBuilder);
      localStringBuilder.append('}');
      localStringBuilder.append(", O:{");
      stringifyCounts(this.opaqueCountsPerSize, localStringBuilder);
      localStringBuilder.append('}');
      localStringBuilder.append(", B:{");
      stringifyCounts(this.bitmapCountsPerSize, localStringBuilder);
      localStringBuilder.append('}');
      localStringBuilder.append(", bpvc: " + this.bytesPerVertexCoord + ", bpai:" + this.bytesPerAtomIndex + ", bpoi:" + this.bytesPerOpaqueIndex + ", vmemA:" + this.vertexMemAtoms + ", vmemO:" + this.vertexMemOpaque + ", memA:" + this.memAtlas + ", memTotal:" + this.memTotal);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }

    void traverse(RapidShapeTraverser paramRapidShapeTraverser, Rect paramRect)
    {
      this.opsBlockCount = paramRapidShapeTraverser.traverse(this, paramRect.width(), paramRect.left, paramRect.top);
      calcMem();
    }

    public void visitBitmap(int paramInt1, int paramInt2, int paramInt3)
    {
      Integer localInteger1 = Integer.valueOf(this.bitmapCountsPerSize.get(paramInt1));
      if (localInteger1 == null);
      for (Integer localInteger2 = Integer.valueOf(1); ; localInteger2 = Integer.valueOf(1 + localInteger1.intValue()))
      {
        this.bitmapCountsPerSize.put(paramInt1, localInteger2.intValue());
        int i = paramInt1 / 8;
        this.atomCount = (i * i + this.atomCount);
        return;
      }
    }

    public void visitOpaque(int paramInt1, int paramInt2, int paramInt3)
    {
      Integer localInteger1 = Integer.valueOf(this.opaqueCountsPerSize.get(paramInt1));
      if (localInteger1 == null);
      for (Integer localInteger2 = Integer.valueOf(1); ; localInteger2 = Integer.valueOf(1 + localInteger1.intValue()))
      {
        this.opaqueCountsPerSize.put(paramInt1, localInteger2.intValue());
        return;
      }
    }

    public void visitTransparent(int paramInt1, int paramInt2, int paramInt3)
    {
      Integer localInteger1 = Integer.valueOf(this.transparentCountsPerSize.get(paramInt1));
      if (localInteger1 == null);
      for (Integer localInteger2 = Integer.valueOf(1); ; localInteger2 = Integer.valueOf(1 + localInteger1.intValue()))
      {
        this.transparentCountsPerSize.put(paramInt1, localInteger2.intValue());
        return;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.svg.jni.rapidshape.RapidShapeSetCompiler
 * JD-Core Version:    0.6.2
 */