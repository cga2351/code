package com.viber.svg.jni;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.viber.svg.jni.rapidshape.RapidShapeSet;
import com.viber.svg.jni.rapidshape.RapidShapeSetCompiler;
import com.viber.svg.jni.rapidshape.RapidShapeSetDescriptor;
import com.viber.svg.jni.rapidshape.RapidShapeStagingDrawDelegate;
import com.viber.svg.jni.rapidshape.RapidShapeStagingDrawInterface;
import java.util.ArrayList;
import java.util.Iterator;

public class RapidShapePictureRenderer extends AndroidSvgRenderer
{
  private RapidShapeSetBuilder builder = new RapidShapeSetBuilder(null);
  private Picture[] pictures;
  private RapidShapeSet rapidShapeSet;

  public RapidShapePictureRenderer(int paramInt)
  {
    super(paramInt);
  }

  protected void beginPicture()
  {
    this.builder.beginPicture();
  }

  protected void beginPictures()
  {
  }

  protected void endPicture()
  {
    this.builder.endPicture();
  }

  protected void endPictures()
  {
    this.builder.build();
    this.pictures = this.builder.getPictures();
    this.rapidShapeSet = this.builder.getShapeSet();
    this.builder = null;
  }

  protected void renderPath()
  {
    this.builder.renderPath(this.path);
  }

  protected void renderPicture(int paramInt)
  {
    this.pictures[paramInt].render();
  }

  protected void renderPreparedPath(int paramInt)
  {
    this.builder.renderPath((Path)this.preparedPaths.get(paramInt));
  }

  private class Picture
  {
    final Paint[] origPaints;
    final int rapidShapeStartIndex;

    Picture(int paramArrayOfPaint, Paint[] arg3)
    {
      this.rapidShapeStartIndex = paramArrayOfPaint;
      Object localObject;
      this.origPaints = localObject;
    }

    void render()
    {
      int i = this.rapidShapeStartIndex;
      int j = 0;
      while (j < this.origPaints.length)
      {
        RapidShapeSet localRapidShapeSet = RapidShapePictureRenderer.this.rapidShapeSet;
        Canvas localCanvas = RapidShapePictureRenderer.this.canvas;
        int k = i + 1;
        localRapidShapeSet.drawShape(localCanvas, i, this.origPaints[j]);
        j++;
        i = k;
      }
    }
  }

  private class RapidShapeSetBuilder
  {
    int curRapidShapeIndex = 0;
    StagingPicture curStagingPicture;
    RapidShapeSet shapeSet;
    ArrayList<StagingPicture> stagingPictures = new ArrayList();

    private RapidShapeSetBuilder()
    {
    }

    private void addPath(Path paramPath, Paint paramPaint)
    {
      this.curStagingPicture.addPath(paramPath, paramPaint);
      this.curRapidShapeIndex = (1 + this.curRapidShapeIndex);
    }

    private RapidShapeSetDescriptor compile()
    {
      return new RapidShapeSetCompiler(1024).compile(getDelegate());
    }

    private RapidShapeStagingDrawDelegate getDelegate()
    {
      return new RapidShapeStagingDrawDelegate()
      {
        public void drawShapesForStaging(RapidShapeStagingDrawInterface paramAnonymousRapidShapeStagingDrawInterface)
        {
          Iterator localIterator = RapidShapePictureRenderer.RapidShapeSetBuilder.this.stagingPictures.iterator();
          while (localIterator.hasNext())
          {
            RapidShapePictureRenderer.RapidShapeSetBuilder.StagingPicture localStagingPicture = (RapidShapePictureRenderer.RapidShapeSetBuilder.StagingPicture)localIterator.next();
            for (int i = 0; i < localStagingPicture.paths.size(); i++)
            {
              Paint localPaint = paramAnonymousRapidShapeStagingDrawInterface.beginShape((Paint)localStagingPicture.origPaints.get(i));
              paramAnonymousRapidShapeStagingDrawInterface.getCanvas().drawPath((Path)localStagingPicture.paths.get(i), localPaint);
              paramAnonymousRapidShapeStagingDrawInterface.endShape();
            }
          }
        }
      };
    }

    public int beginPicture()
    {
      int i = this.stagingPictures.size();
      this.curStagingPicture = new StagingPicture(this.curRapidShapeIndex);
      this.stagingPictures.add(this.curStagingPicture);
      return i;
    }

    public void build()
    {
      this.shapeSet = new RapidShapeSet(compile(), getDelegate());
    }

    public void endPicture()
    {
    }

    public RapidShapePictureRenderer.Picture[] getPictures()
    {
      RapidShapePictureRenderer.Picture[] arrayOfPicture = new RapidShapePictureRenderer.Picture[this.stagingPictures.size()];
      for (int i = 0; i < arrayOfPicture.length; i++)
        arrayOfPicture[i] = ((StagingPicture)this.stagingPictures.get(i)).toPicture();
      return arrayOfPicture;
    }

    public RapidShapeSet getShapeSet()
    {
      return this.shapeSet;
    }

    public void renderPath(Path paramPath)
    {
      if (RapidShapePictureRenderer.this.curRenderState.fillEnabled)
        addPath(paramPath, RapidShapePictureRenderer.this.curRenderState.getFillPaint());
      if (RapidShapePictureRenderer.this.curRenderState.strokeEnabled)
        addPath(paramPath, RapidShapePictureRenderer.this.curRenderState.getStrokePaint());
    }

    private class StagingPicture
    {
      final ArrayList<Paint> origPaints = new ArrayList();
      final ArrayList<Path> paths = new ArrayList();
      final int rapidShapeStartIndex;

      StagingPicture(int arg2)
      {
        int i;
        this.rapidShapeStartIndex = i;
      }

      public void addPath(Path paramPath, Paint paramPaint)
      {
        this.paths.add(paramPath);
        this.origPaints.add(paramPaint);
      }

      public RapidShapePictureRenderer.Picture toPicture()
      {
        return new RapidShapePictureRenderer.Picture(RapidShapePictureRenderer.this, this.rapidShapeStartIndex, (Paint[])this.origPaints.toArray(new Paint[this.origPaints.size()]));
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.svg.jni.RapidShapePictureRenderer
 * JD-Core Version:    0.6.2
 */