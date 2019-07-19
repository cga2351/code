package com.viber.voip.messages.conversation.adapter.a.c.a;

import android.content.Context;
import android.content.res.Resources;
import com.viber.voip.R.dimen;

public class a
{
  private final int a;
  private final int b;
  private final int c;
  private final int d;
  private final int e;

  public a(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    this.a = localResources.getDimensionPixelSize(R.dimen.message_headers_margin);
    int i = localResources.getDimensionPixelSize(R.dimen.message_balloon_vertical_padding);
    this.c = i;
    this.b = i;
    int j = localResources.getDimensionPixelSize(R.dimen.message_balloon_vertical_aggregated_padding);
    this.e = j;
    this.d = j;
  }

  public int a(boolean paramBoolean)
  {
    if (paramBoolean)
      return this.d;
    return this.b;
  }

  public int b(boolean paramBoolean)
  {
    if (paramBoolean)
      return this.e;
    return this.c;
  }

  public int c(boolean paramBoolean)
  {
    if (paramBoolean)
      return this.b;
    return 0;
  }

  public int d(boolean paramBoolean)
  {
    if (paramBoolean)
      return this.a;
    return 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.a.c.a.a
 * JD-Core Version:    0.6.2
 */