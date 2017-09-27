package com.ikentop.thumbnailator;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author : Huqiao
 * @description 本类是Thumbnailator的demo类, 具体帮助文档https://github.com/coobird/thumbnailator/wiki/Maven
 * @since : 2017/9/26
 */
public class ThumbnailatorDemo {

    private static final String imageUrl = "src\\main\\resources\\image\\sights.jpg";

    /**
     * 指定大小缩放图片
     *
     * @param width  指定宽度
     * @param height 指定高度
     * @description 该缩放是按照图片原尺寸比例, 取所给的宽和高最小为准
     */
    public static void zoomSizeImage(int width, int height) {
        try {
            Thumbnails.of(imageUrl).
                    size(width, height).
                    toFile("F:\\image\\sight_zoomSize.jpg");
        } catch (IOException e) {
            System.out.println("原因:" + e.getMessage());
        }
    }

    /**
     * 不按照比例,指定大小进行缩放
     *
     * @param width 宽
     * @param height 高
     */
    public static void zoomSizeKeepAspectRatio(int width, int height) {
        try {
            Thumbnails.of(imageUrl).
                    size(width, height).
                    keepAspectRatio(false).
                    toFile("F:\\image\\sight_zoomSizeKeepAspectRatio.jpg");
        } catch (IOException e) {
            System.out.println("原因:" + e.getMessage());
        }
    }

    /**
     * 按照比例缩放
     *
     * @param scale 比例 0.xxf
     */
    public static void zoomScaleImage(float scale) {
        try {
            Thumbnails.of(imageUrl).
                    scale(scale).
                    toFile("F:\\image\\sight_zoomScale.jpg");
        } catch (IOException e) {
            System.out.println("原因:" + e.getMessage());
        }
    }

    /**
     * 旋转图片
     *
     * @param rotate 角度:正数为顺时针;负数:逆时针
     * @param width  宽度
     * @param height 高度
     */
    public static void rotateImage(int rotate, int width, int height) {
        try {
            Thumbnails.of(imageUrl).
                    size(width, height).
                    rotate(rotate).
                    toFile("F:\\image\\sight_rotate.jpg");
        } catch (IOException e) {
            System.out.println("原因:" + e.getMessage());
        }
    }

    /**
     * 给图片添加水印
     *
     * @param diaphaneity   水印透明度 0~1
     * @param outputQuality 图片输出质量,0~1
     */
    public static void watermarkImage(float diaphaneity, float outputQuality) {
        try {
            Thumbnails.of(imageUrl)
                    .size(700, 500)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("src\\main\\resources\\image\\diaphaneity.jpg")), diaphaneity)
                    .outputQuality(outputQuality)
                    .toFile("F:\\image\\sight_watermark.jpg");
        } catch (IOException e) {
            System.out.println("原因:" + e.getMessage());
        }
    }

    /**
     * 裁剪图片
     *
     * @param x      裁剪的横左标
     * @param y      裁剪的纵坐标
     * @param width  裁剪后的宽
     * @param height 裁剪后的高
     */
    public static void cutImage(int x, int y, int width, int height) {
        try {
            Thumbnails.of(imageUrl)
                    .sourceRegion(x, y, width, height)
                    .size(200, 200)
                    .keepAspectRatio(false)
                    .toFile("F:\\image\\sight_cut.jpg");
        } catch (IOException e) {
            System.out.println("原因:" + e.getMessage());
        }
    }

    /**
     * 转换格式
     *
     * @param format 要转换的格式,如png,gif
     */
    public static void formatImage(String format) {
        try {
            Thumbnails.of(imageUrl)
                    .size(700, 500)
                    .outputFormat(format)
                    .toFile("F:\\image\\sight_format.jpg");
        } catch (IOException e) {
            System.out.println("原因:" + e.getMessage());
        }
    }

    /**
     * 输出到BufferedImage
     */
    public static void asBufferedImage() {
        try {
            BufferedImage thumbnail = Thumbnails.of(imageUrl)
                    .size(700, 500)
                    .asBufferedImage();
            ImageIO.write(thumbnail, "jpg", new File("F:\\image\\sight_asBuffered.jpg"));
        } catch (IOException e) {
            System.out.println("原因:" + e.getMessage());
        }
    }

    /**
     * 输出到OutPutStream
     */
    public static void outPutStreamImage() {
        try {
            OutputStream os = new FileOutputStream("F:\\image\\sight_outPutStream.jpg");
            Thumbnails.of(imageUrl)
                    .size(700, 500)
                    .toOutputStream(os);
        } catch (IOException e) {
            System.out.println("原因:" + e.getMessage());
        }
    }
}
