package com.carfax.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.carfax.dataobjects.KataDO;
import com.carfax.payload.KataResponse;

/**
 * Rest controller will invoke this class once the form is submitted.
 * 
 * @author Mallikarjun Nuti
 *
 */
@RestController
public class KataController {
	/*
	 * Logger variable
	 */
	private static final Logger logger = LoggerFactory.getLogger(KataController.class);

	/**
	 * Once file is passed to the service request. Process the data into Data
	 * objects and print.
	 * 
	 * @param file
	 * @return Success or Failure
	 */
	@PostMapping("/uploadFile")
	public KataResponse uploadFile(@RequestParam("file") MultipartFile file) {
		try {
			String content = new String(file.getBytes(), "UTF-8");
			if (null != content && content.isEmpty()) {
				logger.info("File is empty or not uploaded properly");
				return new KataResponse("Failure");
			}
			String[] rows = content.split("\n");
			List<KataDO> dataList = new ArrayList<KataDO>();
			for (String row : rows) {

				String[] columns = row.split(",");
				if (columns.length == 4) {
					KataDO kataDo = new KataDO(columns[0], columns[1], columns[2], columns[3]);
					dataList.add(kataDo);
				} else {
					return new KataResponse("Failure");
				}
			}
			System.out.println(dataList.toString());
		} catch (IOException e) {
			logger.error("Execption in parsing the input File", e);
			return new KataResponse("Failure");
		}

		return new KataResponse("Success");
	}
}
