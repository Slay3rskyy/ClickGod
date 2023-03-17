package com.github.slay3rskyy;


import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class Utils {

	public static Image load(String imageName){
		try {
			return ImageIO.read(Objects.requireNonNull(Utils.class.getResource("/"+imageName)));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
