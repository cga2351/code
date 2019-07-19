package com.viber.voip.backup.b;

import android.content.Context;
import com.google.a.a.f.l.a;
import com.viber.voip.backup.f;
import com.viber.voip.k.d;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class b extends d
{
  private static final int b = (int)TimeUnit.SECONDS.toMillis(15L);
  private static final String[] c = { "https://www.googleapis.com/auth/drive.appdata" };
  private a d;

  public b(Context paramContext)
  {
    super(paramContext, f.b());
  }

  public b(Context paramContext, com.viber.voip.k.a parama)
  {
    super(paramContext, parama);
  }

  protected com.google.a.a.b.a.a.b.a.a a(Context paramContext, com.viber.voip.k.a parama)
  {
    return com.google.a.a.b.a.a.b.a.a.a(paramContext, Arrays.asList(c)).a(new l.a().a(b).a()).a(parama.a());
  }

  public void a()
  {
    a(this.a.a());
    if (this.d != null)
      this.d.a();
  }

  public void a(a parama)
  {
    this.d = parama;
  }

  public void a(String paramString)
  {
    super.a(paramString);
    if (this.d != null)
      this.d.a(paramString);
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void a(String paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.b.b
 * JD-Core Version:    0.6.2
 */