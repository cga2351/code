package com.google.d.b.a;

import com.google.d.a.b;
import com.google.d.b.c;
import com.google.d.b.h;
import com.google.d.c.a;
import com.google.d.f;
import com.google.d.k;
import com.google.d.t;
import com.google.d.w;
import com.google.d.x;

public final class d
  implements x
{
  private final c a;

  public d(c paramc)
  {
    this.a = paramc;
  }

  w<?> a(c paramc, f paramf, a<?> parama, b paramb)
  {
    Object localObject1 = paramc.a(a.get(paramb.a())).a();
    if ((localObject1 instanceof w));
    for (Object localObject2 = (w)localObject1; ; localObject2 = ((x)localObject1).a(paramf, parama))
    {
      if ((localObject2 != null) && (paramb.b()))
        localObject2 = ((w)localObject2).a();
      return localObject2;
      if (!(localObject1 instanceof x))
        break;
    }
    if (((localObject1 instanceof t)) || ((localObject1 instanceof k)))
    {
      t localt;
      if ((localObject1 instanceof t))
      {
        localt = (t)localObject1;
        label117: if (!(localObject1 instanceof k))
          break label157;
      }
      label157: for (k localk = (k)localObject1; ; localk = null)
      {
        localObject2 = new l(localt, localk, paramf, parama, null);
        break;
        localt = null;
        break label117;
      }
    }
    throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer reference.");
  }

  public <T> w<T> a(f paramf, a<T> parama)
  {
    b localb = (b)parama.getRawType().getAnnotation(b.class);
    if (localb == null)
      return null;
    return a(this.a, paramf, parama, localb);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.d.b.a.d
 * JD-Core Version:    0.6.2
 */