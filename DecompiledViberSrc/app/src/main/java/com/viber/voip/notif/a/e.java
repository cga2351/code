package com.viber.voip.notif.a;

import android.content.Context;
import android.content.Intent;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.notif.a.a.a;
import com.viber.voip.notif.i.i;
import com.viber.voip.util.ViberActionRunner.am;

public class e extends a
{
  private final MessageEntity c;
  private String d;
  private int e;
  private int f;
  private int g;
  private int h;

  private e(MessageEntity paramMessageEntity, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.c = paramMessageEntity;
    this.d = paramString;
    this.e = paramInt1;
    this.f = paramInt2;
    this.g = paramInt3;
    this.h = paramInt4;
  }

  public static e a(MessageEntity paramMessageEntity, String paramString, int paramInt)
  {
    return new e(paramMessageEntity, paramString, paramInt, R.string.mark_as_read, R.drawable.ic_action_mark_as_read, R.drawable.ic_action_wear_mark_as_read);
  }

  public static e b(MessageEntity paramMessageEntity, String paramString, int paramInt)
  {
    return new e(paramMessageEntity, paramString, paramInt, R.string.dismiss, R.drawable.ic_action_call_dismiss, R.drawable.ic_action_wear_call_dismiss);
  }

  protected int a()
  {
    return this.g;
  }

  protected Intent a(Context paramContext)
  {
    Intent localIntent = ViberActionRunner.am.b(paramContext, this.c);
    localIntent.putExtra("notification_tag", this.d);
    localIntent.putExtra("notification_id", this.e);
    return localIntent;
  }

  protected int b()
  {
    return this.f;
  }

  protected int d()
  {
    return i.f((int)this.c.getId());
  }

  protected int e()
  {
    return 0;
  }

  protected int f()
  {
    return this.h;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.a.e
 * JD-Core Version:    0.6.2
 */