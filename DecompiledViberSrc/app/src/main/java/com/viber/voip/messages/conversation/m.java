package com.viber.voip.messages.conversation;

import android.content.Context;
import android.support.v4.app.LoaderManager;
import com.viber.provider.d.a;
import com.viber.voip.messages.conversation.publicaccount.n;
import com.viber.voip.messages.k;
import dagger.a;

public class m
{
  private int a;
  private Context b;
  private LoaderManager c;
  private a<k> d;

  public m(int paramInt, Context paramContext, LoaderManager paramLoaderManager, a<k> parama)
  {
    this.a = paramInt;
    this.b = paramContext;
    this.c = paramLoaderManager;
    this.d = parama;
  }

  public l a(l.a parama, d.a parama1)
  {
    if (com.viber.voip.messages.m.e(this.a))
      return new n(this.b, this.c, this.d, parama, parama1);
    return new l(this.b, this.c, this.d, parama, parama1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.m
 * JD-Core Version:    0.6.2
 */