package com.viber.voip.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import com.viber.common.d.d;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.g.a;
import com.viber.common.dialogs.h.a;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.messages.extras.image.b;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.util.e.j;
import java.util.ArrayList;
import java.util.List;

public final class ay
{
  public static Intent a(Activity paramActivity, a parama, int paramInt1, int paramInt2)
  {
    Intent localIntent;
    if ((parama.b == null) || (j.b(parama.b)))
    {
      com.viber.voip.ui.dialogs.o.c().b(paramActivity);
      localIntent = null;
    }
    do
    {
      return localIntent;
      localIntent = b.a(paramActivity, parama.b, paramInt1, paramInt2);
    }
    while (parama.c == null);
    localIntent.putExtra("image_change_type", parama.c);
    return localIntent;
  }

  private static Resources a()
  {
    return ViberApplication.getLocalizedResources();
  }

  public static Uri a(Activity paramActivity, int paramInt)
  {
    Uri localUri = dv.h.a(paramActivity, null, true);
    if ((localUri != null) && (com.viber.voip.util.upload.o.b(true)) && (com.viber.voip.util.upload.o.a(true)))
      ViberActionRunner.a(paramActivity, localUri, paramInt);
    return localUri;
  }

  public static Uri a(Fragment paramFragment, int paramInt)
  {
    Uri localUri = dv.h.a(paramFragment.getActivity(), null, true);
    if ((localUri != null) && (com.viber.voip.util.upload.o.b(true)) && (com.viber.voip.util.upload.o.a(true)))
      ViberActionRunner.a(paramFragment, localUri, paramInt);
    return localUri;
  }

  private static a a(Context paramContext)
  {
    a locala = new a();
    locala.b = dv.h.a(paramContext, null, false);
    if (locala.b != null)
      locala.b = d.a(locala.b, paramContext, "com.viber.voip.provider.file");
    if ((com.viber.voip.util.upload.o.b(true)) && (com.viber.voip.util.upload.o.a(true)))
    {
      ArrayList localArrayList = new ArrayList();
      Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
      localIntent.putExtra("output", locala.b);
      ViberActionRunner.a(paramContext, localIntent, locala.b);
      localArrayList.add(localIntent);
      locala.a = Intent.createChooser(new Intent().setType("image/*").setAction("android.intent.action.PICK"), a().getString(R.string.msg_options_take_photo));
      locala.a.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[])localArrayList.toArray(new Parcelable[0]));
    }
    return locala;
  }

  public static a a(Context paramContext, Intent paramIntent, Uri paramUri)
  {
    a locala = new a();
    if ((paramIntent != null) && (paramIntent.getData() != null))
    {
      locala.c = "Gallery";
      locala.b = j.a(paramContext, paramIntent.getData(), "image");
    }
    do
    {
      return locala;
      if (paramUri != null)
      {
        locala.c = "Camera";
        locala.b = paramUri;
        return locala;
      }
    }
    while ((paramIntent == null) || (da.a(paramIntent.getStringExtra("backgroundUri"))));
    locala.b = Uri.parse(paramIntent.getStringExtra("backgroundUri"));
    return locala;
  }

  public static void a(Activity paramActivity, boolean paramBoolean)
  {
    if ((paramActivity != null) && (com.viber.voip.util.upload.o.b(true)) && (com.viber.voip.util.upload.o.a(true)))
      ad.a(paramBoolean).a(paramActivity).a(paramActivity);
  }

  public static void a(Fragment paramFragment, boolean paramBoolean)
  {
    if ((paramFragment != null) && (com.viber.voip.util.upload.o.b(true)) && (com.viber.voip.util.upload.o.a(true)))
      ad.a(paramBoolean).a(paramFragment).b(paramFragment);
  }

  public static void b(Activity paramActivity, int paramInt)
  {
    paramActivity.startActivityForResult(Intent.createChooser(new Intent().setType("image/*").setAction("android.intent.action.PICK"), a().getString(R.string.msg_options_take_photo)), paramInt);
  }

  public static void b(Fragment paramFragment, int paramInt)
  {
    paramFragment.startActivityForResult(Intent.createChooser(new Intent().setType("image/*").setAction("android.intent.action.PICK"), a().getString(R.string.msg_options_take_photo)), paramInt);
  }

  public static Uri c(Fragment paramFragment, int paramInt)
  {
    a locala = a(paramFragment.getContext());
    if ((locala.a != null) && (locala.b != null))
      paramFragment.startActivityForResult(locala.a, paramInt);
    return locala.b;
  }

  public static class a
  {
    public Intent a = null;
    public Uri b = null;
    public String c = null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.ay
 * JD-Core Version:    0.6.2
 */