package android.arch.persistence.room;

import android.arch.persistence.a.c.c;
import android.content.Context;
import java.util.List;
import java.util.Set;

public class a
{
  public final c.c a;
  public final Context b;
  public final String c;
  public final e.d d;
  public final List<e.b> e;
  public final boolean f;
  public final e.c g;
  public final boolean h;
  private final Set<Integer> i;

  public a(Context paramContext, String paramString, c.c paramc, e.d paramd, List<e.b> paramList, boolean paramBoolean1, e.c paramc1, boolean paramBoolean2, Set<Integer> paramSet)
  {
    this.a = paramc;
    this.b = paramContext;
    this.c = paramString;
    this.d = paramd;
    this.e = paramList;
    this.f = paramBoolean1;
    this.g = paramc1;
    this.h = paramBoolean2;
    this.i = paramSet;
  }

  public boolean a(int paramInt)
  {
    return (this.h) && ((this.i == null) || (!this.i.contains(Integer.valueOf(paramInt))));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.arch.persistence.room.a
 * JD-Core Version:    0.6.2
 */