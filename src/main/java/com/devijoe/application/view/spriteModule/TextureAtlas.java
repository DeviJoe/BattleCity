package com.devijoe.application.view.spriteModule;

import com.devijoe.application.utils.ResourceLoader;
import lombok.SneakyThrows;

import java.awt.image.BufferedImage;

/**
 * Класс хранит карту текстур (атлас) и предоставляет возможность вырезать из нее произвольные участки
 */
public class TextureAtlas {

	/** Карта с текстурами (атлас) */
	private final BufferedImage atlas;

	@SneakyThrows
	public TextureAtlas(String imageName) {
		atlas = ResourceLoader.loadImage(imageName);
	}

	/**
	 * Вырезает произвольный кусок из атласа
	 * @param x - координата Х (верхний левый угол)
	 * @param y - координата Y (верхний левый угол)
	 * @param w - ширина
	 * @param h - высота
	 * @return
	 */
	public BufferedImage cut(int x, int y, int w, int h) {
		return atlas.getSubimage(x, y, w, h);
	}

}
