package com.viber.voip.gallery.selection;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.viber.voip.R.string;
import com.viber.voip.camrecorder.preview.d;
import com.viber.voip.camrecorder.preview.d.a;
import com.viber.voip.camrecorder.preview.d.c;
import com.viber.voip.gallery.GalleryItem;
import com.viber.voip.gallery.preview.a;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.messages.m;
import com.viber.voip.messages.ui.media.SendMediaDataContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SelectionGallery extends ViberGalleryActivity
{
  private boolean e;
  private Intent f;
  private d g;

  private void a(Intent paramIntent)
  {
    SendMediaDataContainer localSendMediaDataContainer = (SendMediaDataContainer)paramIntent.getParcelableExtra("com.viber.voip.custom_cam_media_preview_media_data");
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(localSendMediaDataContainer);
    Intent localIntent = m.a(P(), false);
    localIntent.addFlags(67108864);
    localIntent.putParcelableArrayListExtra("multiply_send", localArrayList);
    localIntent.putExtras(paramIntent);
    startActivity(localIntent);
  }

  private void a(GalleryItem paramGalleryItem)
  {
    ConversationData localConversationData = P();
    if (localConversationData != null)
      d().a(localConversationData, paramGalleryItem, (Bundle)getIntent().getParcelableExtra("options"));
  }

  private void b(ArrayList<GalleryItem> paramArrayList)
  {
    ConversationData localConversationData = P();
    if (localConversationData != null)
      d().a(localConversationData, paramArrayList, (Bundle)getIntent().getParcelableExtra("options"));
  }

  private d d()
  {
    if (this.g == null)
      this.g = new d(new d.a(this))
      {
        protected int a()
        {
          return 11;
        }

        protected int b()
        {
          return 11;
        }

        protected int c()
        {
          return 10;
        }
      };
    return this.g;
  }

  protected void a(GalleryItem paramGalleryItem, boolean paramBoolean)
  {
    if ((!paramGalleryItem.isVideo()) || (this.e))
      return;
    this.e = true;
    if (paramBoolean)
      a(true);
    a(paramGalleryItem);
  }

  protected void a(ArrayList<GalleryItem> paramArrayList)
  {
    b(paramArrayList);
  }

  protected void a(List<GalleryItem> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      GalleryItem localGalleryItem = (GalleryItem)localIterator.next();
      if (localGalleryItem.hasDoodle())
        localArrayList.add(localGalleryItem.getOriginalUri());
    }
    if (localArrayList.size() > 0)
      this.b.post(new a(localArrayList));
  }

  boolean c()
  {
    return true;
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((-1 == paramInt2) && (paramIntent != null))
    {
      if (10 == paramInt1)
      {
        GalleryMediaSelector localGalleryMediaSelector = new GalleryMediaSelector(paramIntent.getParcelableArrayListExtra("image_list"));
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("media_selector", localGalleryMediaSelector);
        if (!localGalleryMediaSelector.isSelectionEmpty());
        for (boolean bool = true; ; bool = false)
        {
          localBundle.putBoolean("extra_multiple_selection", bool);
          a(false);
          a(localBundle);
          return;
        }
      }
      if (11 == paramInt1)
      {
        this.f = paramIntent;
        return;
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setActionBarTitle(R.string.gallery);
  }

  protected void onResume()
  {
    super.onResume();
    this.e = false;
    if (this.f != null)
    {
      a(this.f);
      this.f = null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gallery.selection.SelectionGallery
 * JD-Core Version:    0.6.2
 */