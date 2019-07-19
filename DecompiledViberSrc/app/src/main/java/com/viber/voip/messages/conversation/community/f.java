package com.viber.voip.messages.conversation.community;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import com.viber.voip.messages.m;
import com.viber.voip.model.entity.h;
import com.viber.voip.util.ViberActionRunner.d;
import com.viber.voip.util.ay;
import com.viber.voip.util.ay.a;

class f
{
  private final Activity a;

  public f(Activity paramActivity)
  {
    this.a = paramActivity;
  }

  public Uri a(int paramInt)
  {
    return ay.a(this.a, paramInt);
  }

  public void a(long paramLong)
  {
    Intent localIntent = m.a(paramLong, 5, false, false, false, false);
    this.a.setResult(-1, localIntent);
    this.a.finish();
  }

  public void a(Intent paramIntent, Uri paramUri, int paramInt)
  {
    ay.a locala = ay.a(this.a, paramIntent, paramUri);
    Intent localIntent = ay.a(this.a, locala, 720, 720);
    if (localIntent != null)
      this.a.startActivityForResult(localIntent, paramInt);
  }

  public void a(Parcelable paramParcelable)
  {
    this.a.setResult(0, new Intent().putExtra("presenter_state", paramParcelable));
    this.a.finish();
  }

  public void a(h paramh)
  {
    Intent localIntent = m.a(paramh.getId(), 5, false, false, false, false);
    if (m.b())
      localIntent.putExtra("open_add_members_intent", ViberActionRunner.d.a(paramh, true));
    this.a.setResult(-1, localIntent);
    this.a.finish();
  }

  public void b(int paramInt)
  {
    ay.b(this.a, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.community.f
 * JD-Core Version:    0.6.2
 */