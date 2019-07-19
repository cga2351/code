package com.viber.voip.camrecorder.preview;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.gallery.GalleryItem;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.util.ViberActionRunner.x;
import com.viber.voip.util.upload.o;
import java.util.ArrayList;

public abstract class d
{
  private static final Logger a = ViberEnv.getLogger();
  private final c b;

  public d(c paramc)
  {
    this.b = paramc;
  }

  private boolean d()
  {
    return (!o.b(true)) || (!o.a(true));
  }

  protected abstract int a();

  public boolean a(ConversationData paramConversationData, GalleryItem paramGalleryItem, Bundle paramBundle)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramGalleryItem);
    return a(paramConversationData, localArrayList, paramBundle);
  }

  public boolean a(ConversationData paramConversationData, ArrayList<GalleryItem> paramArrayList, Bundle paramBundle)
  {
    if (d());
    Activity localActivity;
    do
    {
      return false;
      localActivity = this.b.a();
    }
    while (localActivity == null);
    int i;
    if ((paramArrayList.size() == 1) && (!((GalleryItem)paramArrayList.get(0)).isGif()))
    {
      GalleryItem localGalleryItem = (GalleryItem)paramArrayList.get(0);
      Uri localUri = localGalleryItem.getItemUri();
      boolean bool1 = localGalleryItem.isVideo();
      if (bool1)
      {
        i = b();
        boolean bool2 = paramConversationData.canSendTimeBomb;
        MediaPreviewActivity.a(localActivity, paramConversationData.conversationId, localUri.getPath(), localUri, bool2, bool1, false, i, paramBundle);
      }
    }
    while (true)
    {
      return true;
      i = a();
      break;
      Intent localIntent = ViberActionRunner.x.a(localActivity, paramConversationData, paramArrayList, paramBundle);
      this.b.a(localIntent, c());
    }
  }

  protected abstract int b();

  protected abstract int c();

  public static final class a
    implements d.c<Activity>
  {
    private final Activity a;

    public a(Activity paramActivity)
    {
      this.a = paramActivity;
    }

    public Activity a()
    {
      return this.a;
    }

    public void a(Intent paramIntent, int paramInt)
    {
      this.a.startActivityForResult(paramIntent, paramInt);
    }
  }

  public static final class b
    implements d.c<Activity>
  {
    private final Fragment a;

    public b(Fragment paramFragment)
    {
      this.a = paramFragment;
    }

    public Activity a()
    {
      return this.a.getActivity();
    }

    public void a(Intent paramIntent, int paramInt)
    {
      this.a.startActivityForResult(paramIntent, paramInt);
    }
  }

  public static abstract interface c<A extends Activity>
  {
    public abstract A a();

    public abstract void a(Intent paramIntent, int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camrecorder.preview.d
 * JD-Core Version:    0.6.2
 */