package com.viber.voip.phone.viber;

import android.graphics.Rect;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class LocalVideoContentPositionManager
{
  private boolean mIsViewInInteraction;
  private final PositionChangedListener mListener;
  private final Deque<Screen> mScreensStack;
  private final GravityHolder mViewQuadrant;

  public LocalVideoContentPositionManager(PositionChangedListener paramPositionChangedListener)
  {
    this.mListener = paramPositionChangedListener;
    this.mScreensStack = new ArrayDeque(2);
    this.mScreensStack.addLast(new Screen());
    this.mViewQuadrant = new GravityHolder(null);
  }

  private void applyGravity(int paramInt, Screen paramScreen)
  {
    int i = this.mViewQuadrant.get(paramInt);
    if (i == -1)
      return;
    int k;
    int j;
    switch (i)
    {
    default:
      k = 0;
      j = 0;
    case 0:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      paramScreen.mViewRect.offsetTo(j, k);
      return;
      j = paramScreen.mAvailableRect.left;
      k = paramScreen.mAvailableRect.top;
      continue;
      j = paramScreen.mAvailableRect.right - paramScreen.mViewRect.width();
      k = paramScreen.mAvailableRect.top;
      continue;
      j = paramScreen.mAvailableRect.right - paramScreen.mViewRect.width();
      k = paramScreen.mAvailableRect.bottom - paramScreen.mViewRect.height();
      continue;
      j = paramScreen.mAvailableRect.left;
      k = paramScreen.mAvailableRect.bottom - paramScreen.mViewRect.height();
    }
  }

  private void correctPosition(Screen paramScreen)
  {
    correctXPosition(paramScreen);
    correctYPosition(paramScreen);
  }

  private void correctXPosition(Screen paramScreen)
  {
    if (paramScreen.mViewRect.left < paramScreen.mAvailableRect.left)
      paramScreen.mViewRect.offset(paramScreen.mAvailableRect.left - paramScreen.mViewRect.left, 0);
    while (paramScreen.mViewRect.right <= paramScreen.mAvailableRect.right)
      return;
    paramScreen.mViewRect.offset(paramScreen.mAvailableRect.right - paramScreen.mViewRect.right, 0);
  }

  private void correctYPosition(Screen paramScreen)
  {
    if (paramScreen.mViewRect.top < paramScreen.mAvailableRect.top)
      paramScreen.mViewRect.offset(0, paramScreen.mAvailableRect.top - paramScreen.mViewRect.top);
    while (paramScreen.mViewRect.bottom <= paramScreen.mAvailableRect.bottom)
      return;
    paramScreen.mViewRect.offset(0, paramScreen.mAvailableRect.bottom - paramScreen.mViewRect.bottom);
  }

  private boolean hasMask()
  {
    return this.mScreensStack.size() > 1;
  }

  private void notify(Screen paramScreen, PositionChangedListener paramPositionChangedListener)
  {
    if (paramPositionChangedListener != null)
      paramPositionChangedListener.onPositionChanged(paramScreen.mViewRect.left, paramScreen.mViewRect.top);
  }

  public void addMask(Rect paramRect, PositionChangedListener paramPositionChangedListener)
  {
    if (hasMask())
      removeMask(null);
    Screen localScreen = new Screen((Screen)this.mScreensStack.peekLast());
    Rect localRect1 = localScreen.mAvailableRect;
    localRect1.left += paramRect.left;
    Rect localRect2 = localScreen.mAvailableRect;
    localRect2.top += paramRect.top;
    Rect localRect3 = localScreen.mAvailableRect;
    localRect3.right -= paramRect.right;
    Rect localRect4 = localScreen.mAvailableRect;
    localRect4.bottom -= paramRect.bottom;
    this.mScreensStack.addLast(localScreen);
    correctPosition(localScreen);
    notify(localScreen, paramPositionChangedListener);
  }

  public void applyGravity(int paramInt)
  {
    Screen localScreen = (Screen)this.mScreensStack.peekLast();
    applyGravity(paramInt, localScreen);
    correctPosition(localScreen);
    notify(localScreen, this.mListener);
  }

  public void calculateFinalPosition(int paramInt, PositionChangedListener paramPositionChangedListener)
  {
    Screen localScreen = (Screen)this.mScreensStack.peekLast();
    if ((localScreen.mAvailableRect.isEmpty()) || (localScreen.mViewRect.isEmpty()))
      return;
    int i;
    if (localScreen.mViewRect.centerY() >= localScreen.mAvailableRect.centerY())
      if (localScreen.mViewRect.centerX() >= localScreen.mAvailableRect.centerX())
        i = 2;
    while (true)
    {
      this.mViewQuadrant.updateCurrent(paramInt, i);
      applyGravity(paramInt, localScreen);
      correctPosition(localScreen);
      notify(localScreen, paramPositionChangedListener);
      return;
      i = 3;
      continue;
      if (localScreen.mViewRect.centerX() >= localScreen.mAvailableRect.centerX())
        i = 1;
      else
        i = 0;
    }
  }

  public void clear()
  {
    while (hasMask())
      this.mScreensStack.pollLast();
    ((Screen)this.mScreensStack.peek()).clear();
    this.mIsViewInInteraction = false;
    this.mViewQuadrant.resetToDefault();
  }

  public void removeMask(PositionChangedListener paramPositionChangedListener)
  {
    if (hasMask())
    {
      Screen localScreen1 = (Screen)this.mScreensStack.pollLast();
      Screen localScreen2 = (Screen)this.mScreensStack.peekLast();
      if ((localScreen1.mInteracted) && (!localScreen2.mViewRect.equals(localScreen1.mViewRect)))
      {
        localScreen2.mViewRect.set(localScreen1.mViewRect);
        correctPosition(localScreen2);
      }
      notify(localScreen2, paramPositionChangedListener);
    }
  }

  public void requestPositionChange(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Screen localScreen = (Screen)this.mScreensStack.peekLast();
      if (!localScreen.mInteracted)
        localScreen.mInteracted = true;
      localScreen.mViewRect.offset(paramInt1, paramInt2);
      correctPosition(localScreen);
      notify(localScreen, this.mListener);
    }
  }

  public void setIsViewInInteraction(boolean paramBoolean)
  {
    this.mIsViewInInteraction = paramBoolean;
  }

  public void setQuadrant(@LocalVideoContentPositionManagerQuadrant int paramInt)
  {
    this.mViewQuadrant.setDefault(paramInt);
  }

  public void updateAvailableRect(int paramInt, Rect paramRect)
  {
    Screen localScreen = (Screen)this.mScreensStack.peekLast();
    localScreen.mAvailableRect.set(paramRect);
    if (!this.mIsViewInInteraction)
      applyGravity(paramInt, localScreen);
    correctPosition(localScreen);
    notify(localScreen, this.mListener);
  }

  public void updateViewRect(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.mScreensStack.iterator();
    while (localIterator.hasNext())
    {
      Screen localScreen = (Screen)localIterator.next();
      localScreen.mViewRect.right = (paramInt1 + localScreen.mViewRect.left);
      localScreen.mViewRect.bottom = (paramInt2 + localScreen.mViewRect.top);
      correctPosition(localScreen);
    }
    notify((Screen)this.mScreensStack.peekLast(), this.mListener);
  }

  private static final class GravityHolder
  {

    @LocalVideoContentPositionManagerQuadrant
    private int mCurrent = -1;

    @LocalVideoContentPositionManagerQuadrant
    private int mDefault = -1;

    @LocalVideoContentPositionManagerQuadrant
    private int rotateQuadrantToOrientation(int paramInt1, @LocalVideoContentPositionManagerQuadrant int paramInt2)
    {
      if (paramInt2 == -1)
        return paramInt2;
      return (paramInt2 + paramInt1 / 90) % 4;
    }

    public int get(int paramInt)
    {
      return rotateQuadrantToOrientation(paramInt, this.mCurrent);
    }

    public void resetToDefault()
    {
      this.mCurrent = this.mDefault;
    }

    public void setDefault(int paramInt)
    {
      this.mDefault = paramInt;
      if (this.mCurrent == -1)
        this.mCurrent = paramInt;
    }

    public void updateCurrent(int paramInt1, int paramInt2)
    {
      switch (paramInt1)
      {
      default:
      case 90:
      case 180:
      case 270:
      }
      while (true)
      {
        this.mCurrent = paramInt2;
        return;
        paramInt2 = rotateQuadrantToOrientation(270, paramInt2);
        continue;
        paramInt2 = rotateQuadrantToOrientation(180, paramInt2);
        continue;
        paramInt2 = rotateQuadrantToOrientation(90, paramInt2);
      }
    }
  }

  public static abstract interface PositionChangedListener
  {
    public abstract void onPositionChanged(int paramInt1, int paramInt2);
  }

  private static final class Screen
  {
    final Rect mAvailableRect;
    boolean mInteracted;
    final Rect mViewRect;

    public Screen()
    {
      this.mViewRect = new Rect();
      this.mAvailableRect = new Rect();
    }

    public Screen(Screen paramScreen)
    {
      this.mViewRect = new Rect(paramScreen.mViewRect);
      this.mAvailableRect = new Rect(paramScreen.mAvailableRect);
    }

    public void clear()
    {
      this.mInteracted = false;
      this.mViewRect.setEmpty();
      this.mAvailableRect.setEmpty();
    }

    public String toString()
    {
      return "Screen{mInteracted=" + this.mInteracted + ", mViewRect=" + this.mViewRect.toShortString() + ", mAvailableRect=" + this.mAvailableRect.toShortString() + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.LocalVideoContentPositionManager
 * JD-Core Version:    0.6.2
 */