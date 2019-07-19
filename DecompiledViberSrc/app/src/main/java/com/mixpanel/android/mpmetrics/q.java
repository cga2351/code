package com.mixpanel.android.mpmetrics;

import com.mixpanel.android.b.f;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

class q
{
  private long a;
  private long b;
  private long c;
  private String d;
  private Random e;

  q()
  {
    a();
    this.e = new Random();
  }

  private JSONObject a(boolean paramBoolean)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("$mp_event_id", Long.toHexString(this.e.nextLong()));
      localJSONObject.put("$mp_session_id", this.d);
      if (paramBoolean);
      for (long l = this.a; ; l = this.b)
      {
        localJSONObject.put("$mp_session_seq_id", l);
        localJSONObject.put("$mp_session_start_sec", this.c);
        if (!paramBoolean)
          break;
        this.a = (1L + this.a);
        return localJSONObject;
      }
      this.b = (1L + this.b);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      f.e(c.a, "Cannot create session metadata JSON object", localJSONException);
    }
    return localJSONObject;
  }

  protected void a()
  {
    this.a = 0L;
    this.b = 0L;
    this.d = Long.toHexString(new Random().nextLong());
    this.c = (System.currentTimeMillis() / 1000L);
  }

  public JSONObject b()
  {
    return a(true);
  }

  public JSONObject c()
  {
    return a(false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.mpmetrics.q
 * JD-Core Version:    0.6.2
 */