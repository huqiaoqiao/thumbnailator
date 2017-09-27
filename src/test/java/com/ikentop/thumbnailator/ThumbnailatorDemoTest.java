package com.ikentop.thumbnailator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author : Huqiao
 * @since : 2017/9/26
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ThumbnailatorDemo.class)
public class ThumbnailatorDemoTest {
    @Test
    public void testZoomSizeImage() {
        int width = 70;
        int height = 90;
        ThumbnailatorDemo.zoomSizeImage(width, height);
    }

    @Test
    public void testZoomSizeKeepAspectRatio() {
        int width = 70;
        int height = 90;
        ThumbnailatorDemo.zoomSizeKeepAspectRatio(width, height);
    }

    @Test
    public void testZoomScaleImage() {
        float scale = 0.25f;
        ThumbnailatorDemo.zoomScaleImage(scale);
    }

    @Test
    public void testRotateImage() {
        int rotate = 90;
        int width = 700;
        int height = 500;
        ThumbnailatorDemo.rotateImage(rotate, width, height);
    }

    @Test
    public void testWatermarkImage() {
        float diaphaneity = 0.4f;
        float outputQuality = 0.8f;
        ThumbnailatorDemo.watermarkImage(diaphaneity, outputQuality);
    }

    @Test
    public void testCutImage() {
        int x = 300;
        int y = 300;
        int width = 400;
        int height = 400;
        ThumbnailatorDemo.cutImage(x, y, width, height);
    }

    @Test
    public void testFormatImage() {
        String format = "png";
        ThumbnailatorDemo.formatImage(format);
    }

    @Test
    public void testAsBufferedImage() {
        ThumbnailatorDemo.asBufferedImage();
    }
    @Test
    public void testOutPutStreamImage() {
        ThumbnailatorDemo.outPutStreamImage();
    }

}