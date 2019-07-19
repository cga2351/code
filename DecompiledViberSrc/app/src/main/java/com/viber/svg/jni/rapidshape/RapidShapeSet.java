package com.viber.svg.jni.rapidshape;

import android.graphics.Canvas;
import android.graphics.Paint;

public class RapidShapeSet
  implements RapidShapeTraverser.Visitor
{
  private RapidShapeAtlas atlas;
  private Canvas canvas;
  private Paint paint;
  RapidShape[] shapes;

  public RapidShapeSet(RapidShapeSetDescriptor paramRapidShapeSetDescriptor, RapidShapeAtlas paramRapidShapeAtlas)
  {
    this.atlas = paramRapidShapeAtlas;
    this.shapes = createShapes(paramRapidShapeSetDescriptor);
  }

  public RapidShapeSet(RapidShapeSetDescriptor paramRapidShapeSetDescriptor, RapidShapeStagingDrawDelegate paramRapidShapeStagingDrawDelegate)
  {
    this.shapes = createShapes(paramRapidShapeSetDescriptor);
    this.atlas = new RapidShapeAtlasBuilder(paramRapidShapeSetDescriptor.atlasWidth, paramRapidShapeSetDescriptor.atlasHeight, 1024, 1024, this.shapes).build(paramRapidShapeStagingDrawDelegate);
  }

  private static RapidShape[] createShapes(RapidShapeSetDescriptor paramRapidShapeSetDescriptor)
  {
    RapidShape[] arrayOfRapidShape = new RapidShape[paramRapidShapeSetDescriptor.shapes.length];
    for (int i = 0; i < arrayOfRapidShape.length; i++)
      arrayOfRapidShape[i] = new RapidShape(paramRapidShapeSetDescriptor.shapes[i], paramRapidShapeSetDescriptor.opBuffer);
    return arrayOfRapidShape;
  }

  static Paint getStagingPaint(Paint paramPaint)
  {
    Paint localPaint = new Paint(7);
    localPaint.setColor(-1);
    localPaint.setStrokeCap(paramPaint.getStrokeCap());
    localPaint.setStrokeJoin(paramPaint.getStrokeJoin());
    localPaint.setStrokeMiter(paramPaint.getStrokeMiter());
    localPaint.setStrokeWidth(paramPaint.getStrokeWidth());
    localPaint.setStyle(paramPaint.getStyle());
    return localPaint;
  }

  public void drawShape(Canvas paramCanvas, int paramInt, Paint paramPaint)
  {
    RapidShape localRapidShape = this.shapes[paramInt];
    RapidShapeDescriptor localRapidShapeDescriptor = localRapidShape.getDescriptor();
    this.atlas.setCurrentShape(localRapidShapeDescriptor);
    this.canvas = paramCanvas;
    this.paint = paramPaint;
    localRapidShape.traverse(this, localRapidShapeDescriptor.stagingOffsetX, localRapidShapeDescriptor.stagingOffsetY);
  }

  public void visitBitmap(int paramInt1, int paramInt2, int paramInt3)
  {
    this.atlas.drawRegion(paramInt1, paramInt2, paramInt3, this.canvas, this.paint);
  }

  public void visitOpaque(int paramInt1, int paramInt2, int paramInt3)
  {
    this.canvas.drawRect(paramInt2, paramInt3, paramInt2 + paramInt1, paramInt3 + paramInt1, this.paint);
  }

  public void visitTransparent(int paramInt1, int paramInt2, int paramInt3)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.svg.jni.rapidshape.RapidShapeSet
 * JD-Core Version:    0.6.2
 */