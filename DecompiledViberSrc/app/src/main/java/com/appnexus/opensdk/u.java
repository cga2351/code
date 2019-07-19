package com.appnexus.opensdk;

import com.appnexus.opensdk.utils.Clog;
import org.json.JSONObject;

class u
{
  private f a;
  private String b;
  private boolean c = false;
  private boolean d = false;

  public u(f paramf)
  {
    this.a = paramf;
  }

  private void d()
  {
    if ((this.d) && (!this.c))
    {
      this.a.a.getAdDispatcher().d();
      return;
    }
    this.a.f();
  }

  void a()
  {
    b();
  }

  protected void a(String paramString)
  {
    String str1 = paramString.replaceFirst("video://", "");
    String str2;
    try
    {
      JSONObject localJSONObject = new JSONObject(str1);
      str2 = localJSONObject.getString("event");
      localJSONObject.getJSONObject("params");
      if (str2.equals("adReady"))
      {
        this.a.g();
        this.d = true;
        return;
      }
      if (str2.equals("videoStart"))
        return;
      if ((str2.equals("video-error")) || (str2.equals("Timed-out")))
      {
        d();
        return;
      }
    }
    catch (Exception localException)
    {
      Clog.e(Clog.videoLogTag, "Exception: JsonError::" + str1);
      return;
    }
    if (str2.equals("video-complete"))
    {
      this.c = true;
      return;
    }
    Clog.e(Clog.videoLogTag, "Error: Unhandled event::" + str1);
  }

  protected void b()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.b;
    arrayOfObject[1] = MediaType.BANNER;
    String str = String.format("javascript:window.createVastPlayerWithContent('%s','%s')", arrayOfObject);
    this.a.e(str);
  }

  public void b(String paramString)
  {
    this.b = paramString;
  }

  protected void c()
  {
    if (!this.d)
      return;
    boolean bool = this.a.u();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Boolean.valueOf(bool);
    String str = String.format("javascript:window.viewabilityUpdate('%s')", arrayOfObject);
    this.a.e(str);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.u
 * JD-Core Version:    0.6.2
 */