package com.viber.voip.flatbuffers.c;

import com.google.d.j;
import com.google.d.k;
import com.google.d.l;
import com.google.d.n;
import com.google.d.p;
import com.google.d.q;
import com.google.d.s;
import com.google.d.t;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.FavoritesMetadata;
import java.lang.reflect.Type;

public class e
  implements k<FavoritesMetadata>, t<FavoritesMetadata>
{
  public l a(FavoritesMetadata paramFavoritesMetadata, Type paramType, s params)
  {
    q localq = new q();
    if (paramFavoritesMetadata.getMetadata() == null)
      return n.a;
    return localq.a(paramFavoritesMetadata.getMetadata());
  }

  public FavoritesMetadata a(l paraml, Type paramType, j paramj)
    throws p
  {
    FavoritesMetadata localFavoritesMetadata = new FavoritesMetadata();
    if (paraml.j());
    for (String str = null; ; str = paraml.toString())
    {
      localFavoritesMetadata.setMetadata(str);
      return localFavoritesMetadata;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.c.e
 * JD-Core Version:    0.6.2
 */