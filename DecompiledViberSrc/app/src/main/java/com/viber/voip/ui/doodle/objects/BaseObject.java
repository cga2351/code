package com.viber.voip.ui.doodle.objects;

import android.graphics.Canvas;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.ui.doodle.extras.e.a;
import com.viber.voip.ui.doodle.extras.i;
import com.viber.voip.ui.doodle.objects.b.b;

public abstract class BaseObject
  implements Parcelable
{
  public static final long BASE_OBJECT_CONTENT_SIZE_IN_BYTES = 1L + i.b;
  private static final Logger L = ViberEnv.getLogger();
  private final long mId;
  private boolean mIsDestroyed = false;
  protected b mPreparationCallback;

  BaseObject(Parcel paramParcel)
  {
    this.mId = paramParcel.readLong();
    if (paramParcel.readByte() == i);
    while (true)
    {
      this.mIsDestroyed = i;
      return;
      i = 0;
    }
  }

  public BaseObject(b paramb)
  {
    this.mId = paramb.b();
  }

  abstract boolean canBeDrawn();

  public int describeContents()
  {
    return 0;
  }

  public final void draw(Canvas paramCanvas)
  {
    if (this.mIsDestroyed);
    while (!canBeDrawn())
      return;
    onDraw(paramCanvas);
  }

  public void freeResources()
  {
    this.mPreparationCallback = null;
  }

  public e.a getEditableInfo()
  {
    return null;
  }

  public long getId()
  {
    return this.mId;
  }

  public long getSavedStateSizeInBytes()
  {
    return BASE_OBJECT_CONTENT_SIZE_IN_BYTES;
  }

  public abstract a getType();

  public int hashCode()
  {
    return (int)(this.mId ^ this.mId >>> 32);
  }

  public abstract boolean hit(PointF paramPointF);

  protected final boolean isDestroyed()
  {
    return this.mIsDestroyed;
  }

  public void onDestroy()
  {
    this.mIsDestroyed = true;
    freeResources();
  }

  protected abstract void onDraw(Canvas paramCanvas);

  public void setPreparationCallback(b paramb)
  {
    this.mPreparationCallback = paramb;
  }

  public String toString()
  {
    return "BaseObject{mId=" + this.mId + ", " + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.mId);
    if (this.mIsDestroyed);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeByte((byte)i);
      return;
    }
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[3];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
    }
  }

  public static abstract interface b
  {
    public abstract void a(BaseObject paramBaseObject);

    public abstract void b(BaseObject paramBaseObject);

    public abstract void c(BaseObject paramBaseObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.objects.BaseObject
 * JD-Core Version:    0.6.2
 */