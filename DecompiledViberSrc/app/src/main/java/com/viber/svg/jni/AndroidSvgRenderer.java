package com.viber.svg.jni;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import java.util.ArrayList;

public class AndroidSvgRenderer extends SvgRenderer
{
  private static final int FILL_RULE_EVEN_ODD = 1;
  private static final int GRADIENT_OP_PREPARE = 1;
  private static final int GRADIENT_OP_SET = 0;
  private static final int GRADIENT_TYPE_LINEAR = 0;
  private static final int GRADIENT_TYPE_RADIAL = 1;
  private static final int PAINT_TARGET_FILL = 0;
  private static final int PAINT_TARGET_STROKE = 1;
  private static final int RENDER_STATE_STACK_PREALLOCATE_SIZE = 20;
  private static final int STROKE_LINE_CAP_BUTT = 0;
  private static final int STROKE_LINE_CAP_ROUND = 1;
  private static final int STROKE_LINE_CAP_SQUARE = 2;
  private static final int STROKE_LINE_JOIN_BEVEL = 0;
  private static final int STROKE_LINE_JOIN_MITER = 1;
  private static final int STROKE_LINE_JOIN_ROUND = 2;
  protected final Logger L = Logger.create(getClass().getSimpleName());
  private Paint baseFillPaint;
  private Paint baseStrokePaint;
  private int bytesPos;
  protected Canvas canvas;
  protected Rect canvasSaveRect = new Rect();
  protected RectF canvasSaveRectF = new RectF();
  protected RenderState curRenderState;
  private int currentColorRgb = -16777216;
  private int doublesPos;
  private int floatsPos;
  private int intsPos;
  private Paint maskForceSizePaint;
  private Paint maskPaint;
  private Matrix matrix = new Matrix();
  private float[] matrixData = { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  protected Path path = new Path();
  protected ArrayList<Path> preparedPaths = new ArrayList();
  protected ArrayList<Shader> preparedShaders = new ArrayList();
  protected int renderHeight;
  private RecycleRenderStateStack renderStateStack;
  protected int renderWidth;

  AndroidSvgRenderer(int paramInt)
  {
    super(paramInt);
    initBatchArrays();
    this.renderStateStack = new RecycleRenderStateStack();
    this.renderStateStack.preallocate(20);
    this.baseFillPaint = new Paint(7);
    this.baseFillPaint.setStyle(Paint.Style.FILL);
    this.baseStrokePaint = new Paint(7);
    this.baseStrokePaint.setStyle(Paint.Style.STROKE);
    this.maskPaint = new Paint();
    this.maskPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    this.maskForceSizePaint = new Paint(1);
    this.maskForceSizePaint.setColor(16777215);
    this.maskForceSizePaint.setAlpha(1);
    this.maskForceSizePaint.setStrokeWidth(3.0F);
  }

  private byte readByte()
  {
    byte[] arrayOfByte = this.bytes;
    int i = this.bytesPos;
    this.bytesPos = (i + 1);
    return arrayOfByte[i];
  }

  private double readDouble()
  {
    double[] arrayOfDouble = this.doubles;
    int i = this.doublesPos;
    this.doublesPos = (i + 1);
    return arrayOfDouble[i];
  }

  private float readFloat()
  {
    float[] arrayOfFloat = this.floats;
    int i = this.floatsPos;
    this.floatsPos = (i + 1);
    return arrayOfFloat[i];
  }

  private int readInt()
  {
    int[] arrayOfInt = this.ints;
    int i = this.intsPos;
    this.intsPos = (i + 1);
    return arrayOfInt[i];
  }

  protected void arcTo(double paramDouble1, double paramDouble2, double paramDouble3, int paramInt1, int paramInt2, double paramDouble4, double paramDouble5)
  {
  }

  protected void beginElement(double paramDouble)
  {
    this.renderStateStack.beginElement(paramDouble);
  }

  protected void beginLayer()
  {
    this.canvas.getClipBounds(this.canvasSaveRect);
    this.canvasSaveRectF.set(this.canvasSaveRect);
    this.canvas.saveLayer(this.canvasSaveRectF, null, 31);
  }

  protected void beginMask()
  {
    this.canvas.getClipBounds(this.canvasSaveRect);
    this.canvasSaveRectF.set(this.canvasSaveRect);
    this.canvas.saveLayer(this.canvasSaveRectF, this.maskPaint, 31);
    if (this.canvas.isHardwareAccelerated())
      this.canvas.drawLine(this.canvasSaveRectF.left, this.canvasSaveRectF.top, this.canvasSaveRectF.right, this.canvasSaveRect.bottom, this.maskForceSizePaint);
  }

  protected void beginPicture()
  {
  }

  protected void beginPictures()
  {
  }

  protected void beginPrepare()
  {
  }

  protected void beginPreparedPath()
  {
  }

  protected void beginRender()
  {
  }

  protected void closePath()
  {
    this.path.close();
  }

  protected void concatMatrix(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
  {
    this.curRenderState.concatMatrix(paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6);
  }

  protected void curveTo(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
  {
    this.path.cubicTo((float)paramDouble1, (float)paramDouble2, (float)paramDouble3, (float)paramDouble4, (float)paramDouble5, (float)paramDouble6);
  }

  protected void endElement()
  {
    this.renderStateStack.endElement();
  }

  protected void endLayer()
  {
  }

  protected void endMask()
  {
    this.canvas.restore();
    this.canvas.restore();
  }

  protected void endPicture()
  {
  }

  protected void endPictures()
  {
  }

  protected void endPrepare()
  {
  }

  protected void endPreparedPath()
  {
    this.preparedPaths.add(this.path);
    this.path = new Path();
    this.path.reset();
  }

  protected void endRender()
  {
  }

  protected void internalRenderPath(Path paramPath)
  {
    if (this.curRenderState.fillEnabled)
      this.canvas.drawPath(paramPath, this.curRenderState.getFillPaint());
    if (this.curRenderState.strokeEnabled)
      this.canvas.drawPath(paramPath, this.curRenderState.getStrokePaint());
  }

  protected void lineTo(double paramDouble1, double paramDouble2)
  {
    this.path.lineTo((float)paramDouble1, (float)paramDouble2);
  }

  protected void moveTo(double paramDouble1, double paramDouble2)
  {
    this.path.moveTo((float)paramDouble1, (float)paramDouble2);
  }

  protected void processBatch()
  {
    this.bytesPos = 0;
    this.intsPos = 0;
    this.doublesPos = 0;
    this.floatsPos = 0;
    try
    {
      while (true)
      {
        int i = readByte();
        switch (i)
        {
        default:
          break;
        case 1:
          try
          {
            beginPrepare();
          }
          catch (Throwable localThrowable2)
          {
            this.L.warn("Unexpected error", localThrowable2);
          }
          break;
        case 3:
          beginRender();
          break;
        case 4:
          endRender();
          break;
        case 8:
          beginElement(readDouble());
          break;
        case 9:
          endElement();
          break;
        case 10:
          beginLayer();
          break;
        case 11:
          endLayer();
          break;
        case 12:
          beginMask();
          break;
        case 13:
          endMask();
          break;
        case 14:
          moveTo(readDouble(), readDouble());
          break;
        case 15:
          lineTo(readDouble(), readDouble());
          break;
        case 16:
          curveTo(readDouble(), readDouble(), readDouble(), readDouble(), readDouble(), readDouble());
          break;
        case 17:
          quadraticCurveTo(readDouble(), readDouble(), readDouble(), readDouble());
          break;
        case 18:
          arcTo(readDouble(), readDouble(), readDouble(), readInt(), readInt(), readDouble(), readDouble());
          break;
        case 19:
          closePath();
          break;
        case 20:
          this.curRenderState.setCurrentColor(readInt());
          break;
        case 21:
          this.curRenderState.setNonePaint(readByte());
          break;
        case 22:
          this.curRenderState.setCurrentColorPaint(readByte());
          break;
        case 23:
          this.curRenderState.setColorPaint(readByte(), readInt());
          break;
        case 24:
          int m = readByte();
          int n = readByte();
          int i1 = readByte();
          int i2 = readByte();
          float f1 = readFloat();
          float f2 = readFloat();
          float f3 = readFloat();
          float f4 = readFloat();
          int i3 = readInt();
          float[] arrayOfFloat = new float[i3];
          int[] arrayOfInt = new int[i3];
          for (int i4 = 0; i4 < i3; i4++)
          {
            arrayOfFloat[i4] = readFloat();
            arrayOfInt[i4] = readInt();
          }
          int i5 = readByte();
          Matrix localMatrix = null;
          if (i5 != 0)
          {
            double d1 = readDouble();
            double d2 = readDouble();
            double d3 = readDouble();
            double d4 = readDouble();
            double d5 = readDouble();
            double d6 = readDouble();
            this.matrixData[0] = ((float)d1);
            this.matrixData[1] = ((float)d3);
            this.matrixData[2] = ((float)d5);
            this.matrixData[3] = ((float)d2);
            this.matrixData[4] = ((float)d4);
            this.matrixData[5] = ((float)d6);
            this.matrix.setValues(this.matrixData);
            localMatrix = this.matrix;
          }
          setOrPrepareGradientPaint(m, n, i1, f1, f2, f3, f4, arrayOfInt, arrayOfFloat, i2, localMatrix);
          break;
        case 25:
          this.curRenderState.setPreparedGradientPaint(readByte(), readInt());
          break;
        case 26:
          setFillOpacity(readDouble());
          break;
        case 27:
          setFillRule(readInt());
          break;
        case 28:
          setStrokeOpacity(readDouble());
          break;
        case 29:
          setStrokeWidth(readDouble());
          break;
        case 30:
          setStrokeLineCap(readInt());
          break;
        case 31:
          setStrokeLineJoin(readInt());
          break;
        case 32:
          setStrokeMiterLimit(readDouble());
          break;
        case 33:
          int j = readInt();
          double[] arrayOfDouble = new double[j];
          for (int k = 0; k < j; k++)
            arrayOfDouble[k] = readDouble();
          setStrokeDashArray(arrayOfDouble);
          break;
        case 34:
          setStrokeDashOffset(readDouble());
          break;
        case 35:
          concatMatrix(readDouble(), readDouble(), readDouble(), readDouble(), readDouble(), readDouble());
          break;
        case 36:
          renderLine(readDouble(), readDouble(), readDouble(), readDouble());
          break;
        case 37:
          renderPath();
          break;
        case 38:
          renderEllipse(readDouble(), readDouble(), readDouble(), readDouble());
          break;
        case 39:
          renderRect(readDouble(), readDouble(), readDouble(), readDouble(), readDouble(), readDouble());
          break;
        case 42:
          beginPicture();
          break;
        case 43:
          endPicture();
          break;
        case 44:
          renderPicture(readInt());
          break;
        case 5:
          beginPreparedPath();
          break;
        case 6:
          endPreparedPath();
          break;
        case 7:
          renderPreparedPath(readInt());
          break;
        case 40:
          beginPictures();
          break;
        case 41:
          endPictures();
          break;
        case 2:
          endPrepare();
        case 45:
        }
      }
    }
    catch (Throwable localThrowable1)
    {
    }
  }

  protected void quadraticCurveTo(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    this.path.quadTo((float)paramDouble1, (float)paramDouble2, (float)paramDouble3, (float)paramDouble4);
  }

  protected void renderEllipse(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    RectF localRectF = new RectF((float)(paramDouble1 - paramDouble3), (float)(paramDouble2 - paramDouble4), (float)(paramDouble1 + paramDouble3), (float)(paramDouble2 + paramDouble4));
    this.path.addOval(localRectF, Path.Direction.CW);
    renderPath();
  }

  protected void renderLine(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    this.path.moveTo((float)paramDouble1, (float)paramDouble2);
    this.path.lineTo((float)paramDouble3, (float)paramDouble4);
    renderPath();
  }

  protected void renderPath()
  {
    internalRenderPath(this.path);
    this.path.reset();
  }

  protected void renderPicture(int paramInt)
  {
  }

  protected void renderPreparedPath(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.preparedPaths.size()))
      internalRenderPath((Path)this.preparedPaths.get(paramInt));
  }

  protected void renderRect(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
  {
    this.path.moveTo((float)paramDouble1, (float)paramDouble2);
    this.path.addRect((float)paramDouble1, (float)paramDouble2, (float)(paramDouble1 + paramDouble3), (float)(paramDouble2 + paramDouble4), Path.Direction.CW);
    renderPath();
  }

  public void setCanvas(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    this.canvas = paramCanvas;
    this.renderWidth = paramInt1;
    this.renderHeight = paramInt2;
  }

  public void setCurrentColor(int paramInt)
  {
    this.currentColorRgb = paramInt;
  }

  protected void setFillOpacity(double paramDouble)
  {
    this.curRenderState.setFillOpacity(paramDouble);
  }

  protected void setFillRule(int paramInt)
  {
    if (1 == paramInt)
    {
      this.path.setFillType(Path.FillType.EVEN_ODD);
      return;
    }
    this.path.setFillType(Path.FillType.WINDING);
  }

  protected void setOrPrepareGradientPaint(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt4, Matrix paramMatrix)
  {
    int i = paramArrayOfInt.length;
    Object localObject1 = null;
    Shader.TileMode localTileMode;
    if (i > 0)
    {
      localTileMode = Shader.TileMode.REPEAT;
      switch (paramInt4)
      {
      default:
      case 0:
      case 1:
      case 2:
      }
    }
    Object localObject2;
    while (true)
      switch (paramInt2)
      {
      default:
        localObject2 = null;
        localObject1 = localObject2;
        label79: if ((localObject1 != null) && (paramMatrix != null))
          localObject1.setLocalMatrix(paramMatrix);
        switch (paramInt1)
        {
        default:
          return;
          localTileMode = Shader.TileMode.REPEAT;
          continue;
          localTileMode = Shader.TileMode.MIRROR;
          continue;
          localTileMode = Shader.TileMode.CLAMP;
        case 0:
        case 1:
        }
        break;
      case 1:
      case 0:
      }
    if (paramFloat3 <= 0.0F);
    for (float f = 1.0E-004F; ; f = paramFloat3)
    {
      try
      {
        localObject2 = new RadialGradient(paramFloat1, paramFloat2, f, paramArrayOfInt, paramArrayOfFloat, localTileMode);
      }
      catch (Exception localException)
      {
        this.L.warn("Failed creating gradient", localException);
        localObject1 = null;
      }
      break label79;
      LinearGradient localLinearGradient = new LinearGradient(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramArrayOfInt, paramArrayOfFloat, localTileMode);
      localObject2 = localLinearGradient;
      break;
      if (localObject1 != null)
        this.curRenderState.getTargetPaint(paramInt3).setShader(localObject1);
      this.curRenderState.setTargetPaintEnabled(paramInt3, true);
      return;
      this.preparedShaders.add(localObject1);
      return;
    }
  }

  protected void setStrokeDashArray(double[] paramArrayOfDouble)
  {
    if (paramArrayOfDouble != null)
    {
      float[] arrayOfFloat = new float[paramArrayOfDouble.length];
      for (int i = 0; i < paramArrayOfDouble.length; i++)
        arrayOfFloat[i] = ((float)paramArrayOfDouble[i]);
      this.curRenderState.dashes = arrayOfFloat;
      DashPathEffect localDashPathEffect = new DashPathEffect(this.curRenderState.dashes, this.curRenderState.dashOffset);
      this.curRenderState.getStrokePaint().setPathEffect(localDashPathEffect);
    }
  }

  protected void setStrokeDashOffset(double paramDouble)
  {
    this.curRenderState.dashOffset = ((float)paramDouble);
    if (this.curRenderState.dashes != null)
    {
      DashPathEffect localDashPathEffect = new DashPathEffect(this.curRenderState.dashes, this.curRenderState.dashOffset);
      this.curRenderState.getStrokePaint().setPathEffect(localDashPathEffect);
    }
  }

  protected void setStrokeLineCap(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return;
    case 0:
      this.curRenderState.getStrokePaint().setStrokeCap(Paint.Cap.BUTT);
      return;
    case 1:
      this.curRenderState.getStrokePaint().setStrokeCap(Paint.Cap.ROUND);
      return;
    case 2:
    }
    this.curRenderState.getStrokePaint().setStrokeCap(Paint.Cap.SQUARE);
  }

  protected void setStrokeLineJoin(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return;
    case 1:
      this.curRenderState.getStrokePaint().setStrokeJoin(Paint.Join.MITER);
      return;
    case 2:
      this.curRenderState.getStrokePaint().setStrokeJoin(Paint.Join.ROUND);
      return;
    case 0:
    }
    this.curRenderState.getStrokePaint().setStrokeJoin(Paint.Join.BEVEL);
  }

  protected void setStrokeMiterLimit(double paramDouble)
  {
    this.curRenderState.getStrokePaint().setStrokeMiter((float)paramDouble);
  }

  protected void setStrokeOpacity(double paramDouble)
  {
    this.curRenderState.setStrokeOpacity(paramDouble);
  }

  protected void setStrokeWidth(double paramDouble)
  {
    this.curRenderState.getStrokePaint().setStrokeWidth((float)paramDouble);
  }

  protected class RecycleRenderStateStack
  {
    private int curStateIndex = -1;
    private ArrayList<AndroidSvgRenderer.RenderState> states = new ArrayList();

    protected RecycleRenderStateStack()
    {
    }

    public void beginElement(double paramDouble)
    {
      AndroidSvgRenderer.RenderState localRenderState = AndroidSvgRenderer.this.curRenderState;
      this.curStateIndex = (1 + this.curStateIndex);
      if (this.curStateIndex == this.states.size())
      {
        AndroidSvgRenderer.this.curRenderState = new AndroidSvgRenderer.RenderState(AndroidSvgRenderer.this);
        this.states.add(AndroidSvgRenderer.this.curRenderState);
      }
      while (true)
      {
        AndroidSvgRenderer.this.curRenderState.beginElement(localRenderState, paramDouble);
        return;
        AndroidSvgRenderer.this.curRenderState = ((AndroidSvgRenderer.RenderState)this.states.get(this.curStateIndex));
      }
    }

    public void endElement()
    {
      if (this.curStateIndex >= 0)
      {
        AndroidSvgRenderer.this.curRenderState.endElement();
        this.curStateIndex = (-1 + this.curStateIndex);
      }
      if (this.curStateIndex < 0)
      {
        AndroidSvgRenderer.this.curRenderState = null;
        return;
      }
      AndroidSvgRenderer.this.curRenderState = ((AndroidSvgRenderer.RenderState)this.states.get(this.curStateIndex));
    }

    public void preallocate(int paramInt)
    {
      for (int i = 0; i < paramInt; i++)
        this.states.add(new AndroidSvgRenderer.RenderState(AndroidSvgRenderer.this));
    }
  }

  protected class RenderState
  {
    double baseOpacity;
    float dashOffset;
    float[] dashes;
    boolean fillEnabled;
    double fillOpacity;
    Paint fillPaint = new Paint();
    boolean matrixModified;
    Paint nearestAncestorFillPaint;
    Paint nearestAncestorStrokePaint;
    boolean strokeEnabled;
    double strokeOpacity;
    Paint strokePaint = new Paint();

    public RenderState()
    {
    }

    public void beginElement(RenderState paramRenderState, double paramDouble)
    {
      this.matrixModified = false;
      if (paramRenderState == null)
      {
        this.fillEnabled = true;
        this.strokeEnabled = false;
        this.nearestAncestorFillPaint = AndroidSvgRenderer.this.baseFillPaint;
        this.nearestAncestorStrokePaint = AndroidSvgRenderer.this.baseStrokePaint;
        this.baseOpacity = paramDouble;
        setFillOpacity(1.0D);
        setStrokeOpacity(1.0D);
        this.dashes = null;
        this.dashOffset = 1.0F;
        return;
      }
      this.fillEnabled = paramRenderState.fillEnabled;
      this.strokeEnabled = paramRenderState.strokeEnabled;
      this.nearestAncestorFillPaint = paramRenderState.nearestAncestorFillPaint;
      this.nearestAncestorStrokePaint = paramRenderState.nearestAncestorStrokePaint;
      this.baseOpacity = (paramDouble * paramRenderState.baseOpacity);
      if (paramDouble != 1.0D)
      {
        setFillOpacity(paramRenderState.fillOpacity);
        setStrokeOpacity(paramRenderState.strokeOpacity);
      }
      while (true)
      {
        this.dashes = paramRenderState.dashes;
        this.dashOffset = paramRenderState.dashOffset;
        return;
        this.fillOpacity = paramRenderState.fillOpacity;
        this.strokeOpacity = paramRenderState.strokeOpacity;
      }
    }

    public void concatMatrix(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
    {
      if ((!this.matrixModified) && (AndroidSvgRenderer.this.canvas != null))
      {
        this.matrixModified = true;
        AndroidSvgRenderer.this.canvas.save();
      }
      AndroidSvgRenderer.this.matrixData[0] = ((float)paramDouble1);
      AndroidSvgRenderer.this.matrixData[1] = ((float)paramDouble3);
      AndroidSvgRenderer.this.matrixData[2] = ((float)paramDouble5);
      AndroidSvgRenderer.this.matrixData[3] = ((float)paramDouble2);
      AndroidSvgRenderer.this.matrixData[4] = ((float)paramDouble4);
      AndroidSvgRenderer.this.matrixData[5] = ((float)paramDouble6);
      AndroidSvgRenderer.this.matrix.setValues(AndroidSvgRenderer.this.matrixData);
      if (AndroidSvgRenderer.this.canvas != null)
        AndroidSvgRenderer.this.canvas.concat(AndroidSvgRenderer.this.matrix);
    }

    public void endElement()
    {
      if (this.matrixModified)
        AndroidSvgRenderer.this.canvas.restore();
    }

    public Paint getFillPaint()
    {
      if (this.fillPaint != this.nearestAncestorFillPaint)
      {
        this.fillPaint.set(this.nearestAncestorFillPaint);
        this.nearestAncestorFillPaint = this.fillPaint;
      }
      return this.fillPaint;
    }

    public Paint getStrokePaint()
    {
      if (this.strokePaint != this.nearestAncestorStrokePaint)
      {
        this.strokePaint.set(this.nearestAncestorStrokePaint);
        this.nearestAncestorStrokePaint = this.strokePaint;
      }
      return this.strokePaint;
    }

    Paint getTargetPaint(int paramInt)
    {
      if (paramInt == 0)
        return getFillPaint();
      return getStrokePaint();
    }

    protected void resetBaseOpacity()
    {
      this.baseOpacity = 1.0D;
      setFillOpacity(this.fillOpacity);
      setStrokeOpacity(this.strokeOpacity);
    }

    void setColorPaint(int paramInt1, int paramInt2)
    {
      int i = paramInt2 | (int)(255.0D * this.fillOpacity * this.baseOpacity) << 24;
      Paint localPaint = getTargetPaint(paramInt1);
      localPaint.setShader(null);
      localPaint.setColor(i);
      setTargetPaintEnabled(paramInt1, true);
    }

    void setCurrentColor(int paramInt)
    {
    }

    void setCurrentColorPaint(int paramInt)
    {
      setColorPaint(paramInt, AndroidSvgRenderer.this.currentColorRgb);
    }

    public void setFillOpacity(double paramDouble)
    {
      this.fillOpacity = paramDouble;
      getFillPaint().setAlpha((int)(255.0D * this.fillOpacity * this.baseOpacity));
    }

    void setNonePaint(int paramInt)
    {
      setTargetPaintEnabled(paramInt, false);
    }

    void setPreparedGradientPaint(int paramInt1, int paramInt2)
    {
      if ((paramInt2 < AndroidSvgRenderer.this.preparedShaders.size()) && (AndroidSvgRenderer.this.preparedShaders.get(paramInt2) != null))
        getTargetPaint(paramInt1).setShader((Shader)AndroidSvgRenderer.this.preparedShaders.get(paramInt2));
      setTargetPaintEnabled(paramInt1, true);
    }

    public void setStrokeOpacity(double paramDouble)
    {
      this.strokeOpacity = paramDouble;
      getStrokePaint().setAlpha((int)(255.0D * this.strokeOpacity * this.baseOpacity));
    }

    void setTargetPaintEnabled(int paramInt, boolean paramBoolean)
    {
      if (paramInt == 0)
      {
        this.fillEnabled = paramBoolean;
        return;
      }
      this.strokeEnabled = paramBoolean;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.svg.jni.AndroidSvgRenderer
 * JD-Core Version:    0.6.2
 */