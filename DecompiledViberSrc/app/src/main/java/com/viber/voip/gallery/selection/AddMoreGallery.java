package com.viber.voip.gallery.selection;

import android.content.Intent;
import android.os.Bundle;
import com.viber.voip.R.string;
import com.viber.voip.gallery.GalleryItem;
import java.util.ArrayList;

public class AddMoreGallery extends ViberGalleryActivity
{
  protected void a(ArrayList<GalleryItem> paramArrayList)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("extra_selected_images", paramArrayList);
    setResult(-1, localIntent);
    finish();
  }

  protected boolean a()
  {
    return true;
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setActionBarTitle(R.string.gallery);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gallery.selection.AddMoreGallery
 * JD-Core Version:    0.6.2
 */