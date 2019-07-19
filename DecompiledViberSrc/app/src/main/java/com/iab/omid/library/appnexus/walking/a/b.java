package com.iab.omid.library.appnexus.walking.a;

import android.os.AsyncTask;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

public abstract class b extends AsyncTask<Object, Void, String>
{
  private a a;
  protected final b d;

  public b(b paramb)
  {
    this.d = paramb;
  }

  public void a(a parama)
  {
    this.a = parama;
  }

  protected void a(String paramString)
  {
    if (this.a != null)
      this.a.a(this);
  }

  public void a(ThreadPoolExecutor paramThreadPoolExecutor)
  {
    executeOnExecutor(paramThreadPoolExecutor, new Object[0]);
  }

  public static abstract interface a
  {
    public abstract void a(b paramb);
  }

  public static abstract interface b
  {
    public abstract void a(JSONObject paramJSONObject);

    public abstract JSONObject b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.omid.library.appnexus.walking.a.b
 * JD-Core Version:    0.6.2
 */