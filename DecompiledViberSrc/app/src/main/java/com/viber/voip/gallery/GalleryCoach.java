package com.viber.voip.gallery;

import android.os.Bundle;
import android.view.MotionEvent;
import com.viber.voip.R.layout;
import com.viber.voip.app.ViberFragmentActivity;

public class GalleryCoach extends ViberFragmentActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.gallery_coach_layout);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
      finish();
    return super.onTouchEvent(paramMotionEvent);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gallery.GalleryCoach
 * JD-Core Version:    0.6.2
 */