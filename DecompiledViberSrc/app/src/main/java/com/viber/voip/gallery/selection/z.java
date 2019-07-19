package com.viber.voip.gallery.selection;

import android.os.Handler;
import android.support.v4.app.Fragment;
import com.viber.voip.util.e.g;
import dagger.b;

public final class z
  implements b<ViberGalleryActivity>
{
  public static void a(ViberGalleryActivity paramViberGalleryActivity, Handler paramHandler)
  {
    paramViberGalleryActivity.b = paramHandler;
  }

  public static void a(ViberGalleryActivity paramViberGalleryActivity, com.viber.common.permission.c paramc)
  {
    paramViberGalleryActivity.d = paramc;
  }

  public static void a(ViberGalleryActivity paramViberGalleryActivity, g paramg)
  {
    paramViberGalleryActivity.c = paramg;
  }

  public static void a(ViberGalleryActivity paramViberGalleryActivity, dagger.android.c<Fragment> paramc)
  {
    paramViberGalleryActivity.a = paramc;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gallery.selection.z
 * JD-Core Version:    0.6.2
 */