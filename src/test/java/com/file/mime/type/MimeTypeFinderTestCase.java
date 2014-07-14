package com.file.mime.type;

import static org.testng.Assert.fail;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collection;

import org.testng.Assert;
import org.testng.annotations.Test;

import eu.medsea.mimeutil.MimeUtil;

public class MimeTypeFinderTestCase {
	
	@Test
	public void mimeTypeShouldBeOfMPEG() {
		File mp3File = getFile("mpegFile.mp3");
		
		MimeUtil.registerMimeDetector("eu.medsea.mimeutil.detector.MagicMimeMimeDetector");
		Collection<?> mimeTypes = MimeUtil.getMimeTypes(mp3File);
		Assert.assertTrue(mimeTypes.contains("audio/mpeg"), "should contain audio/mpeg");
		
	}

	@Test
	public void mimeTypeShouldBeOfWAV() {
		File mp3File = getFile("wavFile.wav");
		
		MimeUtil.registerMimeDetector("eu.medsea.mimeutil.detector.MagicMimeMimeDetector");
		Collection<?> mimeTypes = MimeUtil.getMimeTypes(mp3File);
		Assert.assertTrue(mimeTypes.contains("audio/x-wav"), "should contain audio/x-wav");
		
	}
	
	private File getFile(String fileName) {
		File file = null;
		URL url = URLClassLoader.getSystemResource(fileName);
		try {
			file = new File(url.toURI());
		} catch (URISyntaxException e) {
			fail("Opening of File failed");
		} finally {
		}
		return file;
	}
	
}
