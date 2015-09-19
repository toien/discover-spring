package com.toien.discover.spring.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody String handleFileUpload(
			@RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {

			File destFile = new File("D:/tmp/upload/" + file.getOriginalFilename());

			if (!destFile.getParentFile().exists()) {
				destFile.getParentFile().mkdir();
			}

			try {
				if (!destFile.exists()) {
					destFile.createNewFile();
				}
				file.transferTo(destFile);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return "Upload success";
	}

}
