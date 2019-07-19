package com.mixpanel.android.b;

import android.os.Build.VERSION;
import android.util.Pair;

public class g<F, S> extends Pair<F, S>
{
  public g(F paramF, S paramS)
  {
    super(paramF, paramS);
  }

  public boolean equals(Object paramObject)
  {
    boolean bool2;
    if (Build.VERSION.SDK_INT > 16)
      bool2 = super.equals(paramObject);
    boolean bool3;
    do
    {
      Pair localPair;
      Object localObject1;
      do
      {
        boolean bool4;
        do
        {
          Object localObject2;
          do
          {
            boolean bool1;
            do
            {
              return bool2;
              bool1 = paramObject instanceof Pair;
              bool2 = false;
            }
            while (!bool1);
            localPair = (Pair)paramObject;
            if (localPair.first == this.first)
              break;
            localObject2 = localPair.first;
            bool2 = false;
          }
          while (localObject2 == null);
          bool4 = localPair.first.equals(this.first);
          bool2 = false;
        }
        while (!bool4);
        if (localPair.second == this.second)
          break;
        localObject1 = localPair.second;
        bool2 = false;
      }
      while (localObject1 == null);
      bool3 = localPair.second.equals(this.second);
      bool2 = false;
    }
    while (!bool3);
    return true;
  }

  public int hashCode()
  {
    if (Build.VERSION.SDK_INT > 16)
      return super.hashCode();
    int i;
    int j;
    if (this.first == null)
    {
      i = 0;
      Object localObject = this.second;
      j = 0;
      if (localObject != null)
        break label48;
    }
    while (true)
    {
      return i ^ j;
      i = this.first.hashCode();
      break;
      label48: j = this.second.hashCode();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.b.g
 * JD-Core Version:    0.6.2
 */