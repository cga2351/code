package com.viber.voip.ui.doodle.undo;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.util.CircularArray;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public class a
{
  private static final Logger a = ViberEnv.getLogger();
  private final CircularArray<Undo> b;
  private final a c;

  public a(a parama, Bundle paramBundle)
  {
    this.c = parama;
    this.b = new CircularArray();
    if (paramBundle != null)
      b(paramBundle);
  }

  private void b(Bundle paramBundle)
  {
    Parcelable[] arrayOfParcelable = paramBundle.getParcelableArray("back_stack_extra");
    if (arrayOfParcelable == null)
      return;
    int i = arrayOfParcelable.length;
    for (int j = 0; j < i; j++)
      b((Undo)arrayOfParcelable[j]);
    d();
  }

  private void b(Undo paramUndo)
  {
    if (Undo.None == paramUndo)
      return;
    this.b.addLast(paramUndo);
  }

  private void d()
  {
    if (this.c != null)
      this.c.a(this.b.size());
  }

  public long a()
  {
    long l = 24L;
    int i = this.b.size();
    for (int j = 0; j < i; j++)
      l += ((Undo)this.b.get(j)).getSavedStateSizeInBytes();
    return l;
  }

  public Undo a(long paramLong)
  {
    CircularArray localCircularArray = new CircularArray(this.b.size());
    Object localObject = Undo.None;
    while (true)
    {
      Undo localUndo;
      if (!this.b.isEmpty())
      {
        localUndo = (Undo)this.b.getLast();
        this.b.removeFromEnd(1);
        if (localUndo.mObjectId == paramLong)
          localObject = localUndo;
      }
      else
      {
        while (!localCircularArray.isEmpty())
        {
          b((Undo)localCircularArray.getLast());
          localCircularArray.removeFromEnd(1);
        }
      }
      localCircularArray.addLast(localUndo);
    }
    if (Undo.None != localObject)
      d();
    return localObject;
  }

  public void a(Bundle paramBundle)
  {
    int i = this.b.size();
    Undo[] arrayOfUndo = new Undo[i];
    for (int j = 0; j < i; j++)
      arrayOfUndo[j] = ((Undo)this.b.get(j));
    paramBundle.putParcelableArray("back_stack_extra", arrayOfUndo);
  }

  public void a(Undo paramUndo)
  {
    b(paramUndo);
    d();
  }

  public Undo b()
  {
    if (!this.b.isEmpty())
    {
      Undo localUndo = (Undo)this.b.getLast();
      this.b.removeFromEnd(1);
      d();
      return localUndo;
    }
    return Undo.None;
  }

  public void c()
  {
    this.b.clear();
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.undo.a
 * JD-Core Version:    0.6.2
 */