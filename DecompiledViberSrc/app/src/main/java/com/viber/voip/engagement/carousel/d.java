package com.viber.voip.engagement.carousel;

import android.util.SparseArray;
import com.viber.voip.engagement.data.b;

public class d
  implements i
{
  protected final String a;
  protected final SparseArray<String> b;

  public d(String paramString, SparseArray<String> paramSparseArray)
  {
    this.a = paramString;
    this.b = paramSparseArray;
  }

  public String a()
  {
    return this.a;
  }

  public String a(int paramInt)
  {
    return (String)this.b.get(paramInt);
  }

  public void a(b paramb)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.carousel.d
 * JD-Core Version:    0.6.2
 */