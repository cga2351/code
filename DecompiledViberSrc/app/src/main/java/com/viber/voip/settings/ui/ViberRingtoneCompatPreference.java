package com.viber.voip.settings.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.preference.Preference;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.viber.voip.R.styleable;
import com.viber.voip.util.dk;

public class ViberRingtoneCompatPreference extends Preference
{
  private int a;
  private boolean b;
  private boolean c;

  public ViberRingtoneCompatPreference(Context paramContext)
  {
    this(paramContext, null);
  }

  public ViberRingtoneCompatPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ViberRingtoneCompatPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }

  public ViberRingtoneCompatPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ViberRingtoneCompatPreference, paramInt1, paramInt2);
    this.a = localTypedArray.getInt(R.styleable.ViberRingtoneCompatPreference_android_ringtoneType, 1);
    this.b = localTypedArray.getBoolean(R.styleable.ViberRingtoneCompatPreference_android_showDefault, true);
    this.c = localTypedArray.getBoolean(R.styleable.ViberRingtoneCompatPreference_android_showSilent, true);
    localTypedArray.recycle();
  }

  protected Object a(TypedArray paramTypedArray, int paramInt)
  {
    return paramTypedArray.getString(paramInt);
  }

  protected void a(Uri paramUri)
  {
    f(dk.m(paramUri));
  }

  protected void a(boolean paramBoolean, Object paramObject)
  {
    String str = (String)paramObject;
    if (paramBoolean);
    while (TextUtils.isEmpty(str))
      return;
    a(Uri.parse(str));
  }

  public boolean a(int paramInt, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      Uri localUri = (Uri)paramIntent.getParcelableExtra("android.intent.extra.ringtone.PICKED_URI");
      if (b(dk.m(localUri)))
        a(localUri);
    }
    return true;
  }

  public int b()
  {
    return this.a;
  }

  protected void b(Intent paramIntent)
  {
    paramIntent.putExtra("android.intent.extra.ringtone.EXISTING_URI", f());
    paramIntent.putExtra("android.intent.extra.ringtone.SHOW_DEFAULT", this.b);
    if (this.b)
      paramIntent.putExtra("android.intent.extra.ringtone.DEFAULT_URI", RingtoneManager.getDefaultUri(b()));
    paramIntent.putExtra("android.intent.extra.ringtone.SHOW_SILENT", this.c);
    paramIntent.putExtra("android.intent.extra.ringtone.TYPE", this.a);
    paramIntent.putExtra("android.intent.extra.ringtone.TITLE", y());
  }

  public Intent e()
  {
    Intent localIntent = new Intent("android.intent.action.RINGTONE_PICKER");
    b(localIntent);
    return localIntent;
  }

  protected Uri f()
  {
    String str = g(null);
    boolean bool = TextUtils.isEmpty(str);
    Uri localUri = null;
    if (!bool)
      localUri = Uri.parse(str);
    return localUri;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.ViberRingtoneCompatPreference
 * JD-Core Version:    0.6.2
 */