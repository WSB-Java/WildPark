/**
 * @author Xtry333
 */
package wildpark.model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

public class World {
	public static int WIDTH = 200;
	public static int HEIGHT = 100;

	public static long SEED = 0;

	public static double DISTANCE_EXPO = 1.33f;
	public static double ELEVATION_SCALE = 0.007f;

	public static int DISTANCE_CALCULATION_METHOD = 3;

	static OpenSimplexNoise openSimplexNoise;

	public static Image generate() {

		openSimplexNoise = new OpenSimplexNoise(SEED);

		// double[][] elevation = new double[WIDTH][HEIGHT];
		BufferedImage worldImg = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

		int centerX = WIDTH / 2;
		int centerY = HEIGHT / 2;
		double maxDistance = Math.hypot(centerX, centerY);

		for (int y = 0; y < HEIGHT; y++) {
			for (int x = 0; x < WIDTH; x++) {
				double nx = x * ELEVATION_SCALE, ny = y * ELEVATION_SCALE;
				double distx = centerX - x;
				double disty = centerY - y;

				double d = -1;
				if (DISTANCE_CALCULATION_METHOD == 1)
					d = Math.hypot(distx, disty) / maxDistance;
				else if (DISTANCE_CALCULATION_METHOD == 2)
					d = Math.max(Math.abs(distx), Math.abs(disty)) / maxDistance;
				else if (DISTANCE_CALCULATION_METHOD == 3)
					d = 1 - (1.0 * x / WIDTH);

				if (DISTANCE_EXPO != 1.0 && d != -1)
					d = Math.pow(d, DISTANCE_EXPO);

				double e = (1.0000f * noise(1 * nx, 1 * ny) + 0.5000f * noise(2 * nx, 2 * ny)
						+ 0.2500f * noise(4 * nx, 4 * ny) + 0.1250f * noise(8 * nx, 8 * ny)
						+ 0.0625f * noise(16 * nx, 16 * ny) + 0.0313f * noise(32 * nx, 32 * ny)
						+ 0.0156f * noise(64 * nx, 64 * ny));
				e /= (1.0f + 0.5f + 0.25f + 0.125f + 0.0625f + 0.0313f + 0.0156f);

				if (d != -1)
					e = (e + 0.05) * (1 - 1.00 * Math.pow(d, 2.00));

				// e = Math.pow(e, 4.00f);
				// elevation[x][y] = e;
				// int eI = (int)(e * 255);
				// System.out.println(d);

				if (e < .2)
					worldImg.setRGB(x, y, new Color(29, 37, 186).getRGB()); // OCEAN
				else if (e < .30)
					worldImg.setRGB(x, y, new Color(30, 42, 255).getRGB()); // OCEAN
				else if (e < .315)
					worldImg.setRGB(x, y, Color.YELLOW.getRGB()); // BEACH
				else if (e < .40)
					worldImg.setRGB(x, y, new Color(51, 204, 0).getRGB()); // LAND 1
				else if (e < .55)
					worldImg.setRGB(x, y, new Color(45, 179, 0).getRGB()); // LAND 2
				else
					worldImg.setRGB(x, y, Color.ORANGE.getRGB()); // MOUNTAINS
			}
		}

		File file = new File("map.png");
		try {
			ImageIO.write(worldImg, "png", file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		worldImg.getScaledInstance(WIDTH*8, HEIGHT*8, 0);
		//java.awt.Image i = worldImg.getScaledInstance(WIDTH*8, HEIGHT*8, 0);
		return SwingFXUtils.toFXImage(worldImg, null);
	}

	public static Image getImage(int[][] worldArray) {

		BufferedImage worldImg = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				switch (worldArray[j][i]) {
				case 0:
					worldImg.setRGB(j, i, Color.BLUE.getRGB());
					break;
				case 1:
					worldImg.setRGB(j, i, Color.GREEN.getRGB());
					break;
				}
				// worldImg.setRGB(j, i, new Color().new);
			}
		}

		return SwingFXUtils.toFXImage(worldImg, null);
	}

	static double noise(double x, double y) {
		return (openSimplexNoise.eval(x, y) / 2.0f + 0.5f);
	}
}
