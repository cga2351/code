package com.viber.voip.ui.doodle.objects.c;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.util.LongSparseArray;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.ui.doodle.extras.h;
import com.viber.voip.ui.doodle.objects.BaseObject;

public class a
{
  private static final Logger a = ViberEnv.getLogger();
  private final LongSparseArray<BaseObject> b;
  private final h c;

  public a(h paramh, Bundle paramBundle)
  {
    this.c = paramh;
    this.b = new LongSparseArray();
    if (paramBundle != null)
      b(paramBundle);
  }

  private void b(Bundle paramBundle)
  {
    Parcelable[] arrayOfParcelable = paramBundle.getParcelableArray("objects_extra");
    if (arrayOfParcelable == null);
    while (true)
    {
      return;
      int i = arrayOfParcelable.length;
      for (int j = 0; j < i; j++)
        a((BaseObject)arrayOfParcelable[j]);
    }
  }

  public long a()
  {
    long l = 24L;
    int i = this.b.size();
    for (int j = 0; j < i; j++)
      l += ((BaseObject)this.b.get(this.b.keyAt(j))).getSavedStateSizeInBytes();
    return l;
  }

  public BaseObject a(long paramLong)
  {
    System.currentTimeMillis();
    return (BaseObject)this.b.get(paramLong);
  }

  public void a(Bundle paramBundle)
  {
    int i = this.b.size();
    BaseObject[] arrayOfBaseObject = new BaseObject[i];
    for (int j = 0; j < i; j++)
      arrayOfBaseObject[j] = ((BaseObject)this.b.get(this.b.keyAt(j)));
    paramBundle.putParcelableArray("objects_extra", arrayOfBaseObject);
  }

  public void a(BaseObject paramBaseObject)
  {
    this.b.append(paramBaseObject.getId(), paramBaseObject);
  }

  public void b()
  {
    int i = 0;
    int j = this.b.size();
    while (i < j)
    {
      b(this.b.keyAt(i));
      i++;
    }
  }

  public void b(long paramLong)
  {
    BaseObject localBaseObject = (BaseObject)this.b.get(paramLong);
    if (localBaseObject != null)
    {
      localBaseObject.onDestroy();
      this.b.remove(paramLong);
      if (this.c != null)
        this.c.a(paramLong);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.objects.c.a
 * JD-Core Version:    0.6.2
 */