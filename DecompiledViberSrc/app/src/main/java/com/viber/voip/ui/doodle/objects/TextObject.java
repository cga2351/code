package com.viber.voip.ui.doodle.objects;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.Editable.Factory;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.TypedValue;
import com.viber.voip.ui.doodle.commands.movable.TransformationCommand.Transformations;
import com.viber.voip.ui.doodle.extras.TextInfo;
import com.viber.voip.ui.doodle.extras.e.a;
import com.viber.voip.ui.doodle.extras.i;
import com.viber.voip.ui.doodle.objects.b.e;
import com.viber.voip.ui.doodle.scene.SceneConfig;
import com.viber.voip.ui.doodle.undo.Undo;

public class TextObject extends MovableObject
{
  public static final Parcelable.Creator<TextObject> CREATOR = new Parcelable.Creator()
  {
    public TextObject a(Parcel paramAnonymousParcel)
    {
      return new TextObject(paramAnonymousParcel, null);
    }

    public TextObject[] a(int paramAnonymousInt)
    {
      return new TextObject[paramAnonymousInt];
    }
  };
  private static final long TEXT_OBJECT_CONTENT_SIZE_IN_BYTES = 0L;
  private static final float TEXT_SIZE = 47.0F;
  private static final int TEXT_SIZE_SCALE_BOUND = 2;
  private static final float TEXT_SIZE_SCALE_FACTOR_FOR_SCALE = 3.0F;
  private Rect mBounds;
  private final int mCanvasWidth;
  private Rect mInsertionBounds;
  private float mInsertionScaleFactor = 1.0F;
  private boolean mIsInScaledMode = false;
  private StaticLayout mLayout;
  private Matrix mMatrix;
  private final TextPaint mPaint = new TextPaint(1);
  private Matrix mScaledMatrix;
  private final TextPaint mScaledPaint = new TextPaint(1);
  private Path[] mScaledPaths;
  private TextInfo mTextInfo;
  private final int mTextSizeInPixels;
  private Matrix mVerticesMatrix;

  private TextObject(Parcel paramParcel)
  {
    super(paramParcel);
    this.mInsertionScaleFactor = paramParcel.readFloat();
    this.mTextSizeInPixels = paramParcel.readInt();
    this.mTextInfo = ((TextInfo)paramParcel.readParcelable(TextInfo.class.getClassLoader()));
    this.mCanvasWidth = paramParcel.readInt();
    int i = paramParcel.readInt();
    if (i > 0)
      this.mInsertionBounds = new Rect(0, 0, i, paramParcel.readInt());
    if (paramParcel.readByte() == 1);
    for (boolean bool = true; ; bool = false)
    {
      this.mIsInScaledMode = bool;
      initPaint();
      return;
    }
  }

  public TextObject(e parame)
  {
    super(parame);
    this.mTextSizeInPixels = ((int)TypedValue.applyDimension(1, 47.0F, parame.e().getResources().getDisplayMetrics()));
    this.mInsertionScaleFactor = parame.c();
    this.mTextInfo = parame.f();
    this.mCanvasWidth = Math.round(parame.d().getDrawingWidth() / (parame.d().getScaleFactor() * parame.c()));
    initPaint();
  }

  private int determineLayoutContentWidth(StaticLayout paramStaticLayout)
  {
    float f1 = 0.0F;
    for (int i = 0; i < paramStaticLayout.getLineCount(); i++)
    {
      float f2 = paramStaticLayout.getLineWidth(i);
      if (f2 > f1)
        f1 = f2;
    }
    return (int)Math.ceil(f1);
  }

  private void initContent()
  {
    this.mLayout = new StaticLayout(this.mTextInfo.getText(), this.mPaint, this.mCanvasWidth, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
    this.mBounds = new Rect(0, 0, determineLayoutContentWidth(this.mLayout), this.mLayout.getHeight());
    StaticLayout localStaticLayout = new StaticLayout(this.mTextInfo.getText(), this.mScaledPaint, Math.round(3.0F * this.mCanvasWidth), Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
    this.mScaledPaths = initPaths(localStaticLayout, this.mScaledPaint);
    this.mMatrix = new Matrix();
    float f1 = -this.mCanvasWidth / 2 + this.mBounds.width() / 2;
    float f2;
    if (this.mInsertionBounds != null)
      f2 = f1 + (this.mInsertionBounds.width() / 2 - this.mBounds.width() / 2);
    for (float f3 = 0.0F + (this.mInsertionBounds.height() / 2 - this.mBounds.height() / 2); ; f3 = 0.0F)
    {
      this.mMatrix.postTranslate(f2, f3);
      this.mScaledMatrix = new Matrix();
      this.mScaledMatrix.postTranslate(this.mBounds.width() / 2 - localStaticLayout.getWidth() / 2, this.mBounds.height() / 2 - localStaticLayout.getHeight() / 2);
      this.mScaledMatrix.postScale(0.3333333F, 0.3333333F, this.mBounds.centerX(), this.mBounds.centerY());
      this.mScaledMatrix.postTranslate(f2 - f1, f3);
      this.mPaint.setColor(this.mTextInfo.getColor());
      this.mScaledPaint.setColor(this.mTextInfo.getColor());
      if (this.mInsertionBounds == null)
        this.mInsertionBounds = new Rect(this.mBounds);
      this.mVerticesMatrix = new Matrix();
      this.mVerticesMatrix.postScale(this.mBounds.width() / this.mInsertionBounds.width(), this.mBounds.height() / this.mInsertionBounds.height(), this.mInsertionBounds.centerX(), this.mInsertionBounds.centerY());
      onBoundsReady();
      return;
      f2 = f1;
    }
  }

  private void initPaint()
  {
    this.mPaint.setTextSize(this.mTextSizeInPixels);
    this.mPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
    this.mScaledPaint.setTextSize(3.0F * this.mTextSizeInPixels);
    this.mScaledPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
  }

  private Path[] initPaths(StaticLayout paramStaticLayout, TextPaint paramTextPaint)
  {
    String str1 = this.mTextInfo.getText().toString();
    Path[] arrayOfPath = new Path[paramStaticLayout.getLineCount()];
    for (int i = 0; i < paramStaticLayout.getLineCount(); i++)
    {
      int j = paramStaticLayout.getLineStart(i);
      int k = paramStaticLayout.getLineEnd(i);
      int m = paramStaticLayout.getLineAscent(i);
      float f1 = paramStaticLayout.getLineLeft(i);
      float f2 = paramStaticLayout.getLineTop(i);
      paramStaticLayout.getLineBounds(i, new Rect());
      String str2 = str1.substring(j, k);
      Path localPath = new Path();
      paramTextPaint.getTextPath(str2, 0, str2.length(), f1, f2 - m, localPath);
      localPath.close();
      arrayOfPath[i] = localPath;
    }
    return arrayOfPath;
  }

  boolean canBeDrawn()
  {
    return (super.canBeDrawn()) && (this.mLayout != null) && (this.mScaledPaths != null);
  }

  public void freeResources()
  {
    super.freeResources();
    this.mLayout = null;
    this.mMatrix = null;
    this.mScaledPaths = null;
    this.mScaledMatrix = null;
    this.mBounds = null;
  }

  protected Rect getBounds()
  {
    return this.mInsertionBounds;
  }

  public e.a getEditableInfo()
  {
    return new TextInfo(getId(), Editable.Factory.getInstance().newEditable(this.mTextInfo.getText()), this.mTextInfo.getColor());
  }

  public long getSavedStateSizeInBytes()
  {
    return super.getSavedStateSizeInBytes() + this.mTextInfo.getSavedStateSizeInBytes() + TEXT_OBJECT_CONTENT_SIZE_IN_BYTES;
  }

  public BaseObject.a getType()
  {
    return BaseObject.a.c;
  }

  protected Matrix getVerticesMatrix()
  {
    return this.mVerticesMatrix;
  }

  public Undo onClick()
  {
    this.mPreparationCallback.b(this);
    return Undo.None;
  }

  public void onDrawingStateChanged()
  {
    if ((!this.mIsInScaledMode) && (this.mCurrentState.getScale() > 2.0F * this.mInsertionScaleFactor))
      this.mIsInScaledMode = true;
    while ((!this.mIsInScaledMode) || (this.mCurrentState.getScale() >= 2.0F * this.mInsertionScaleFactor))
      return;
    this.mIsInScaledMode = false;
  }

  protected void performDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    if (this.mIsInScaledMode)
    {
      paramCanvas.concat(this.mScaledMatrix);
      Path[] arrayOfPath = this.mScaledPaths;
      int i = arrayOfPath.length;
      for (int j = 0; j < i; j++)
        paramCanvas.drawPath(arrayOfPath[j], this.mScaledPaint);
    }
    paramCanvas.concat(this.mMatrix);
    this.mLayout.draw(paramCanvas);
    paramCanvas.restore();
  }

  public void setPreparationCallback(BaseObject.b paramb)
  {
    super.setPreparationCallback(paramb);
    if (!canBeDrawn())
      initContent();
    paramb.a(this);
  }

  public String toString()
  {
    return "TextObject{mTextInfo=" + this.mTextInfo + ", " + super.toString() + '}';
  }

  public void update(TextInfo paramTextInfo)
  {
    if (paramTextInfo.geId() == getId())
    {
      this.mTextInfo.setText(paramTextInfo.getText());
      this.mTextInfo.setColor(paramTextInfo.getColor());
      initContent();
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.mInsertionScaleFactor);
    paramParcel.writeInt(this.mTextSizeInPixels);
    paramParcel.writeParcelable(this.mTextInfo, paramInt);
    paramParcel.writeInt(this.mCanvasWidth);
    if (this.mInsertionBounds == null)
    {
      paramParcel.writeInt(-1);
      if (!this.mIsInScaledMode)
        break label92;
    }
    label92: for (int i = 1; ; i = 0)
    {
      paramParcel.writeByte((byte)i);
      return;
      paramParcel.writeInt(this.mInsertionBounds.width());
      paramParcel.writeInt(this.mInsertionBounds.height());
      break;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.objects.TextObject
 * JD-Core Version:    0.6.2
 */